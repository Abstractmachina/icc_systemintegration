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
  // app.addForecast(forecast);

  @Test
  public void canSetCacheLimit() {
    app.setCacheLimit(2);

    assertThat(app.cacheSize(), is(2));
  }

  @Test
  public void canRequestFromClient() {

//    // mock forecaster needs to be called,as cache does not contain forecast.
//    context.checking(
//        new Expectations() {
//          {
//            exactly(1).of(forecaster).requestForecast(with(any(Query.class)));
//            //will(returnValue(any(Forecast.class)));
//          }
//        });
//
//    Forecast fc = app.retrieveForecast(DayOfWeek.MONDAY, "London");
  }

  @Test
  public void canGetForecastByIndex() {

    //    Forecast fc = app.retrieveForecast(0);
  }

  @Test
  public void canUpdateCacheWithCurrentWeather() {
    // app.updateCache();
    // app.getLastEntry();
  }

  //  @Test
  //  public void printWeatherOnRequest() {
  //
  //  }

}
