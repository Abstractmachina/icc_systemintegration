package ic.doc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.DayOfWeek;
import org.junit.Test;

public class ForeCasterAdapterTest {

  // this one tests actual adaptation of client code. This unit test would have to
  // be updated if another client is used.
  @Test
  public void AdapterConvertsForecastCorrectlyFromWeatherCom() {
    ForeCasterAdapter adapter = new ForeCasterAdapter();
    Query q = new Query(DayOfWeek.MONDAY, "LONDON");
    Forecast fc = adapter.requestForecast(q);

    assertThat(fc.day(), is(DayOfWeek.MONDAY));
    assertThat(fc.region(), is("LONDON"));
    System.out.println("Forecast is " + fc.Summary());
    System.out.println("Temperature is " + fc.temperature());
    System.out.println("Time of Query is " + fc.queryTime());
  }
}
