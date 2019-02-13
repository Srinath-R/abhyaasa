package sri.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DurationTest {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void run() {
        LocalDateTime start = LocalDateTime.parse("2018-12-03 09:37:17",dateTimeFormatter);
        LocalDateTime end = LocalDateTime.parse("2018-12-04 10:38:25",dateTimeFormatter);

        System.out.format("%d hrs %d min %d secs",start.until(end, ChronoUnit.HOURS),
                start.until(end, ChronoUnit.MINUTES)%60,start.until(end, ChronoUnit.SECONDS)%60);
    }

    private interface IFoo {
    }

    private class Foo implements IFoo{

    }

    public void test(Foo foo) {
        System.out.println("Fooo");
    }

    public void test(IFoo foo) {
        System.out.println("IFooo");
    }

    public static void main(String[] args) {
        new DurationTest().test(null);
    }
}
