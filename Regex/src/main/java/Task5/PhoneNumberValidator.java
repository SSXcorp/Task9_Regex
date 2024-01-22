package Task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneNumberRegex = "^380(50|66|95|99|63|73|93|67|68|96|97|98)\\d{7}$";
        Pattern pattern = Pattern.compile(phoneNumberRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
