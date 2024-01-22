package TestEmail;

import Task3.EmailValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailValidatorTest {

    @Test
    public void testValidEmailAndDomain1() {
        assertTrue(EmailValidator.isEmailValid("example.s@email.co"));
    }

    @Test
    public void testValidEmailAndDomain() {
        assertTrue(EmailValidator.isEmailValid("Anton_Shwetz@gmail.com"));
    }

    @Test
    public void testValidEmailAndDoubleDomain() {
        assertTrue(EmailValidator.isEmailValid("solist777@unit.test.ua"));
    }

    @Test
    public void testValidEmailAndDoubleDomain2() {
        assertTrue(EmailValidator.isEmailValid("example@email.com.ua"));
    }

    @Test
    public void testInvalidEmailWithSpace() {
        assertFalse(EmailValidator.isEmailValid("invalid email@example.com"));
    }

    @Test
    public void testInvalidEmailWithoutAt() {
        assertFalse(EmailValidator.isEmailValid("invalid.email.com"));
    }

    @Test
    public void testInvalidEmailWithUpperCaseDomain() {
        assertFalse(EmailValidator.isEmailValid("user@Example.com"));
    }

    @Test
    public void testInvalidEmailWithNotAllowedSpecialSymbol() {
        assertFalse(EmailValidator.isEmailValid("user$example@example.com"));
    }

    @Test
    public void testInvalidEmailWithoutDotInDomain() {
        assertFalse(EmailValidator.isEmailValid("missing@domain"));
    }

    @Test
    public void testInvalidEmailWithSpaceInTheEnd() {
        assertFalse(EmailValidator.isEmailValid("hello.world@domain.com "));
    }

    @Test
    public void testInvalidEmailWithoutLettersOrNumbersAfterSpecialSymbol() {
        assertFalse(EmailValidator.isEmailValid("solo.@shadow.daemon"));
    }

    @Test
    public void testInvalidEmailWithDoubleDotInDomain() {
        assertFalse(EmailValidator.isEmailValid("good@domain..com"));
    }

    @Test
    public void testInvalidEmailWithDoubleDotInEmail() {
        assertFalse(EmailValidator.isEmailValid("double..@domain"));
    }

}
