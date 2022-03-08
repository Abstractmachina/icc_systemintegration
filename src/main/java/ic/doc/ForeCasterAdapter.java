package ic.doc;

import com.weather.Day;
import com.weather.Region;

public class ForeCasterAdapter implements Forecaster {

  @Override
  public Forecast requestForecast(Query query) {
    com.weather.Forecaster forecaster = new com.weather.Forecaster();
    Region region = Region.valueOf(query.region());
    Day day = Day.valueOf(query.day().name());

    com.weather.Forecast rawForecast = forecaster.forecastFor(region, day);

    return new Forecast(
        query.day(), query.region(), rawForecast.summary(), (float) rawForecast.temperature());
  }
}
