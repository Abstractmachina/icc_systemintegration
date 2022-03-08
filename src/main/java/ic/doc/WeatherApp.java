package ic.doc;

import java.time.DayOfWeek;

public class WeatherApp {
  private ForecastCache cache;

  public WeatherApp(IForecaster forecaster) {
    cache = new ForecastCache();
    cache.setForecaster(forecaster);
  }

  public Forecast retrieveForecast(DayOfWeek day, String region) {
    Query q = new Query(day, region);
      return cache.getForecast(q);
  }
  //retrieve forecast based on index in cache
//  public Forecast retrieveForecast(int i) {
//  }


  public void setCacheLimit(int size) {
    cache.setLimit(size);
  }

  public int cacheLimit() {
    return cache.limit();
  }
  public int cacheSize() {
    return cache.size();
  }

  public void addForecast(IForecaster fc) {

  }
}
