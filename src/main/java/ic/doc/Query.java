package ic.doc;

import java.time.DayOfWeek;

public class Query {
  private DayOfWeek day;
  private String region;

  Query(DayOfWeek d, String r) {
    day = d;
    region = r.toUpperCase();
  }

  public DayOfWeek day() {
    return day;
  }

  public String region() {
    return region;
  }
}
