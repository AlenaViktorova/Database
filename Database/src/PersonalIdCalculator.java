import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PersonalIdCalculator {
    public static long calculateAge(String personalId) {
        LocalDate birthDate = extractBirthDate(personalId);
        LocalDate currentDate = LocalDate.now(ZoneId.of("Europe/Prague"));

        return ChronoUnit.YEARS.between(birthDate, currentDate);
    }

    private static LocalDate extractBirthDate(String personalId) {
        String datePart = personalId.replaceAll("[^0-9]", "");
        String yearPart = datePart.substring(0, 2);
        String monthPart = datePart.substring(2, 4);

        int month = Integer.parseInt(monthPart);
        if (month > 50) {
            month -= 50;
        }

        int year = Integer.parseInt(yearPart);
        if (year > 23) {
            year = 1900 + year;
        } else {
            year = 2000 + year;
        }

        String formattedDate = String.format("%d%02d%s", year, month, datePart.substring(4, 6));
        return convertToDate(formattedDate);
    }

    private static LocalDate convertToDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(dateString, formatter);
    }
}
