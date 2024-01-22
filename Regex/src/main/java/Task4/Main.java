package Task4;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Task4.DateValidator.extractAndDisplayDateInfo;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите дату и время: ");
            String userInput = scanner.nextLine();

            extractAndDisplayDateInfo(userInput);
        }
    }


}
