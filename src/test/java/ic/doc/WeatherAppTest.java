package ic.doc;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherAppTest {
  WeatherApp app = new WeatherApp();



  @Test
  public void canSetCacheLimit() {
    app.setCacheLimit(2);

    assertThat(app.cacheSize(), is(2));
  }
  @Test
  public void canUpdateCacheWithCurrentWeather() {
    //app.updateCache();
    //app.getLastEntry();
  }

//  @Test
//  public void printWeatherOnRequest() {
//
//  }

}