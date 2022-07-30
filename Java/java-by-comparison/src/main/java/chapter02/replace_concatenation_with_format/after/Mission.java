package chapter02.replace_concatenation_with_format.after;


import chapter02.replace_concatenation_with_format.Logbook;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Mission {

    Logbook logbook;
    LocalDate start;

    void update(String author, String message) {
        LocalDate today = LocalDate.now();
        String month = String.valueOf(today.getMonthValue());
        String entry = String.format("%S: [%tm-%<te-%tY](Day %d)> %s%n",
                author, today, ChronoUnit.DAYS.between(start, today) + 1, message);
        logbook.write(entry);
    }
}
