package Task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    //Simple = ^(.+)@(.+)$
    //Using only letters, numbers adn "- . _" symbols ^[A-Za-z0-9+_.-]+@(.+)$
    //^(?i)[a-zA-Z0-9]+(?:[-._][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\.[a-zA-Z0-9]+(?:\.[a-zA-Z0-9]+)*$
    //My solution ^[a-zA-Z0-9]+(?:[._-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\.[a-zA-Z0-9]+(?:\.[a-zA-Z0-9]+)*$

    public static boolean isEmailValid(String email) {
        String regex = "^[a-zA-Z0-9]+(?:[._-][a-zA-Z0-9]+)*@[a-z]+\\.[a-z]+(?:\\.[a-z]+)*$";
        Pattern pattern = Pattern.compile(regex);
        if (email == null) {
            return false;
        }
        Matcher m = pattern.matcher(email);
        return m.matches();
    }
}
