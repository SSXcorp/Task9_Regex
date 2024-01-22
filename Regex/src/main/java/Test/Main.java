package Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите дату и время: ");
            String userInput = scanner.nextLine();

            extractAndDisplayDateInfo(userInput);
        }
    }
    //^((\d{2})[./](\d{2})[./])?((\d{2})[./])?(\d{4})(?: ?(\d{1,2}):(\d{1,2}))?$
    public static void extractAndDisplayDateInfo(String input) {
        String dateTimeRegex = "^((\\d{2})[./](\\d{2})[./])?((\\d{2})[./])?(\\d{4})(?: ?(\\d{1,2}):(\\d{1,2}))?$";
        Pattern pattern = Pattern.compile(dateTimeRegex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            int day, month;
            if (matcher.group(1) == null) {
                day = 0;
                month = 0;
                if (matcher.group(5) != null) month = Integer.parseInt(matcher.group(5));
            }
            else {
                day = Integer.parseInt(matcher.group(2));
                month = Integer.parseInt(matcher.group(3));
            }
//            day = matcher.group(1) == null ? 0 : Integer.parseInt(matcher.group(2));
//            month = matcher.group(1) == null ? Integer.parseInt(matcher.group(5)) : Integer.parseInt(matcher.group(3));
            int year = Integer.parseInt(matcher.group(6));
            int hour = matcher.group(7) == null ? 0 : Integer.parseInt(matcher.group(7));
            int minute = matcher.group(8) == null ? 0 : Integer.parseInt(matcher.group(8));

            String time = ", " + (hour != 0 ? hour + " hours " : "") + (minute != 0 ? minute + " minutes" : "");

            if (year < 1000 || hour > 24 || minute >= 60) {
                System.out.println("Incorrect date format!");
                return;
            }
            if(month == 0){
                System.out.println("Year :" + year);
                if (hour != 0 || minute != 0) {
                    System.out.print(time);
                    System.out.println();
                }
            } else if (month > 0 && month <= 12) {
                if (day == 0){
                    System.out.println("Month of year " + month + ",");
                    System.out.println("year " + year);
                    if (hour != 0 || minute != 0) {
                        System.out.print(time);
                        System.out.println();
                    }
                } else if (day != 0) {
                    if (isValidDate(day, month, year)){
                        System.out.print("Day of month - " + day);
                        System.out.print(", month of year - " + month);
                        System.out.println(", year " + year);
                        if (hour != 0 || minute != 0) {
                            System.out.print(time);
                            System.out.println();
                        }
                    } else System.out.println("Invalid date.");
                }
            } else System.out.println("Incorrect date format!");

        } else System.out.println("Incorrect date format!");
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
