package ic.doc;

public class WeatherApp {
  private CacheProxy cache;

  private void setCacheLimit(int size) {
    cache.setSize(size);
  }

  //retrieve forecast based on index in cache
  private void retrieveForecast(int i) {

    //look in cache for forecast,
    //if not found, retrieve forecast from client.

  }

  private void updateCache() {}

  private void clientForecastRequest() {}

}
