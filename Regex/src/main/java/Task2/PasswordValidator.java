package Task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    //^ represents starting character of the string.
    //(?=.*[0-9]) represents a digit must occur at least once.
    //(?=.*[a-z]) represents a lower case alphabet must occur at least once.
    //(?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
    //(?=.*[@#$%^&-+=()] represents a special character that must occur at least once.
    //(?=\\S+$) white spaces don’t allowed in the entire string.
    //.{8, 20} represents at least 8 characters and at most 20 characters.
    //?=[A-Z]{3} if we need first 3 letters upper case
    //(?=(?:[^A-Z]*[A-Z]){3}) if we need 3 upper case letters anywhere in text
    //$ represents the end of the string.

    //Read about Guava Solution (Google)
    public static boolean isPasswordValid(String password){
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[,./?])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = pattern.matcher(password);
        return m.matches();
    }
}
