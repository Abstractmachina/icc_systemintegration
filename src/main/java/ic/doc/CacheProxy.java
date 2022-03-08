package ic.doc;

import java.util.Map;

public class CacheProxy {

  private int limit;
  private Map<Query, IForecast> cachedForecasts;

  public CacheProxy() {
    limit = 0;
  }

  public void retrieveForecast(IForecast fc) {
    // look in cache,
    // if cache doesnt exist, request forecast from client.
  }

  private void requestForecast() {}

  public void setLimit(int l) {
    limit = l;
  }

  public int limit() {
    return limit;
  }
}
