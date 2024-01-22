package Task5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a phone number: ");
            String userInput = scanner.nextLine();

            if (PhoneNumberValidator.isValidPhoneNumber(userInput)) {
                System.out.println("The number " + userInput + " is correct!");
            }
            else {
                System.out.println("Invalid phone number!");
            }
        }
    }
}

