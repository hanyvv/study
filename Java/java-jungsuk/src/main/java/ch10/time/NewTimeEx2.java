package ch10.time;

import java.time.*;

public class NewTimeEx2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2015, 12, 31);
        LocalTime time = LocalTime.of(12, 34, 56);

        LocalDateTime dt = LocalDateTime.of(date, time);

        ZoneId zid = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt = dt.atZone(zid);
        String strZid = zdt.getZone().getId();

        ZonedDateTime seoulTime = ZonedDateTime.now();
        ZoneId nyId = ZoneId.of("America/New_York");
        ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);

        OffsetDateTime odt = zdt.toOffsetDateTime();


        System.out.println("dt = " + dt);
        System.out.println("zid = " + zid);
        System.out.println("zdt = " + zdt);
        System.out.println("strZid = " + strZid);
        System.out.println("seoulTime = " + seoulTime);
        System.out.println("nyId = " + nyId);
        System.out.println("nyTime = " + nyTime);
    }
}
