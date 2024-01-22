package Task4;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {

    static int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void extractAndDisplayDateInfo(String input) {
        String dateTimeRegex = "^(\\d{2})[./]?((?=\\d{2})\\d{2})?[./]?(\\d{4})(?: ?(\\d{1,2}):(\\d{1,2}))?$";
        Pattern pattern = Pattern.compile(dateTimeRegex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            int day = matcher.group(2) == null ? 0 : Integer.parseInt(matcher.group(1));
            int month = matcher.group(2) == null ? 0 : Integer.parseInt(matcher.group(2));
            int year = matcher.group(3) == null ? 0 : Integer.parseInt(matcher.group(3));
            int hour = matcher.group(4) == null ? 0 : Integer.parseInt(matcher.group(4));
            int minute = matcher.group(5) == null ? 0 : Integer.parseInt(matcher.group(5));

            if (isValidDate(day, month, year)) {
                System.out.print("Day of month - " + day);
                System.out.print(", month of year - " + month);
                if (year != 0) {
                    System.out.print(", year - " + year);
                }
                if (hour != 0 || minute != 0) {
                    System.out.print(", " + (hour != 0 ? hour + " hours " : "") + (minute != 0 ? minute + " minutes" : ""));
                }
                System.out.println();
            } else {
                System.out.println("Invalid date.");
            }
        } else {
            System.out.println("Invalid input format.");
        }
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false; // Month should be in the range [1, 12]
        }
        if (day < 1 || day > isDaysValid(month, year)) {
            return false; // Day should be in the range [1, days in month]
        }
        return true;
    }

    public static int isDaysValid(int month, int year) {
        if (month < 1 || month > 12) {
            return 0;
        }
        if (month == 2) {
            return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28; // February has 28 or 29 days
        }
        return daysInMonth[month];
    }
}



