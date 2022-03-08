package ic.doc;

import java.util.Map;

public class CacheProxy {

  private int limit;
  private Map<Query, IForecast> cachedForecasts;

  public void setSize(int i) {}

  public void retrieveForecast(IForecast fc) {
    //look in cache,
    //if cache doesnt exist, request forecast from client.
  }

  private void requestForecast() {}

}
