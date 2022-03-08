package ic.doc;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ForecastCache {

  private int limit = 10;
  private LinkedHashMap<Query, Forecast> cachedForecasts = new LinkedHashMap<>();
  private IForecaster forecaster;

  public ForecastCache() {}

  public Forecast getForecast(Query query) {
    if (cachedForecasts.containsKey(query)) {
      return cachedForecasts.get(query);
    }
    //if query does not exist, request from client.
    requestForecastFromClient(query);
    return cachedForecasts.get(query);
  }

  public Forecast getForecast(int idx) {
    Set<Entry<Query, Forecast>> entrySet = cachedForecasts.entrySet();
    Iterator<Map.Entry<Query, Forecast>> iterator = entrySet.iterator();

    int i = 1;
    int index = idx;
    while (iterator.hasNext()) {
      if (index - 1 == i) {
        return iterator.next().getValue();
      }
      iterator.next();
      i++;
    }
    return null;
  }

  private void requestForecastFromClient(Query q) {
    Forecast fc = forecaster.requestForecast(q);
    cachedForecasts.put(q, fc);
  }


  public void setLimit(int l) {
    limit = l;
  }

  public int size() {
    return cachedForecasts.size();
  }

  public int limit() {
    return limit;
  }

  public void setForecaster(IForecaster forecaster) {
    this.forecaster = forecaster;
  }
}
