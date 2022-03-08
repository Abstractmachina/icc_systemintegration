package ic.doc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class WeatherAppTest {

  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
  private final IForecaster forecaster = context.mock(IForecaster.class);

  WeatherApp app = new WeatherApp(forecaster);

  @Test
  public void canSetCacheLimit() {
    app.setCacheLimit(22);

    assertThat(app.cacheLimit(), is(22));
  }

  @Test
  public void canRequestFromClient() {
    // mock forecaster will be called as cache does not contain any forecasts.
    context.checking(
        new Expectations() {
          {
            exactly(1).of(forecaster).requestForecast(with(any(Query.class)));
            will(returnValue(with(any(Forecast.class))));
          }
        });

    Forecast fc = app.retrieveForecast(DayOfWeek.MONDAY, "London");
  }

  @Test
  public void canStoreForecastsInCache() {
    context.checking(new Expectations() {
      {
        allowing(forecaster).requestForecast(with(any(Query.class)));
      }
    });

    Forecast fc0 = app.retrieveForecast(DayOfWeek.MONDAY, "London");
    Forecast fc1 = app.retrieveForecast(DayOfWeek.TUESDAY, "Edinburgh");
    Forecast fc2 = app.retrieveForecast(DayOfWeek.WEDNESDAY, "Birmingham");

    assertThat(app.cacheSize(),is(3));

  }

  @Test
  public void cacheIsLimited() {
    context.checking(new Expectations() {
      {
        allowing(forecaster).requestForecast(with(any(Query.class)));
      }
    });
    app.flushCache();
    app.setCacheLimit(2);

    Forecast fc0 = app.retrieveForecast(DayOfWeek.MONDAY, "London");
    Forecast fc1 = app.retrieveForecast(DayOfWeek.TUESDAY, "Edinburgh");
    Forecast fc2 = app.retrieveForecast(DayOfWeek.WEDNESDAY, "Birmingham");

    assertThat(app.cacheSize(),is(2));
  }

  @Test
  public void oldestEntryIsDeletedWhenLimitIsReached() {
    context.checking(new Expectations() {
      {
        allowing(forecaster).requestForecast(with(any(Query.class)));
      }
    });
    app.flushCache();
    app.setCacheLimit(2);

    Forecast fc0 = app.retrieveForecast(DayOfWeek.MONDAY, "London");
    Forecast fc1 = app.retrieveForecast(DayOfWeek.TUESDAY, "Edinburgh");
    Forecast fc2 = app.retrieveForecast(DayOfWeek.WEDNESDAY, "Birmingham");

    assertThat(app.retrieveFirstForecast().getKey().day(), is(DayOfWeek.TUESDAY));
  }
}
