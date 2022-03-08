package ic.doc;

import com.weather.Day;
import com.weather.Forecaster;
import com.weather.Region;
import java.time.DayOfWeek;

public class ForeCasterAdapter implements IForecaster {

  @Override
  public Forecast requestForecast(Query query) {
    Forecaster forecaster = new Forecaster();
    Region region = Region.valueOf(query.region());
    Day day = Day.valueOf(query.day().name());

    com.weather.Forecast rawForecast = forecaster.forecastFor(region, day);

    return new Forecast(query.day(), query.region(), rawForecast.summary(), (float) rawForecast.temperature() );
  }
}
