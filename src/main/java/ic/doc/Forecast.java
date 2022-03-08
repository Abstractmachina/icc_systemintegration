package ic.doc;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Forecast {
  private final DayOfWeek day; //using java built in DayOfWeek
  // -> less coupling than Day enum from client api.
  private final String region; //keeping as string, no need to add additional enum
  private final String summary;
  private final float temperature;
  private final LocalDateTime querytime;

  public Forecast(DayOfWeek day, String region, String summary, float temperature) {
    this.day = day;
    this.region = region;
    this.summary = summary;
    this.temperature = temperature;
    this.querytime = LocalDateTime.now();
  }

}
