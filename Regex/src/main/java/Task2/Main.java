package Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your password: ");

            if(PasswordValidator.isPasswordValid(scanner.nextLine())){
                System.out.println("Your password is correct!");
            }
            else {
                System.out.println("Your password is incorrect!");
            }
        }
    }
}
