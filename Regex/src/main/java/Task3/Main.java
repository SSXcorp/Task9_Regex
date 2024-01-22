package Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your Email: ");

            if(EmailValidator.isEmailValid(scanner.nextLine())){
                System.out.println("Your email is correct!");
            }
            else {
                System.out.println("Your email is incorrect!");
            }
        }
    }
}
