package ic.doc;

import java.time.DayOfWeek;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;

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

  public void setCacheLimit(int size) {
    cache.setLimit(size);
  }

  public int cacheLimit() {
    return cache.limit();
  }
  public int cacheSize() {
    return cache.size();
  }

  public void flushCache() {
    cache.clear();
  }

  public Entry<Query, Forecast> retrieveFirstForecast() {
    return cache.getFirst();
  }

  public Entry<Query, Forecast> retrieveLastForecast() {
    return cache.getLast();
  }
}
