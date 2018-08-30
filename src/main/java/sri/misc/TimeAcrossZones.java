package sri.misc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeAcrossZones {
    public static void print() {
        Instant now = Instant.now();
        System.out.println("Current local time. "+ LocalDateTime.now());
        ZoneId.getAvailableZoneIds().forEach(
                zone -> {
                    ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.of(zone));
                    System.out.format("Zone: %s --> Time: %s \n",zone,zonedDateTime);
                }
        );
    }

    public static void main(String[] args) {
        print();
    }
}
