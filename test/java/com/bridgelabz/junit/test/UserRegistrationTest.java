package com.bridgelabz.junit.test;

import com.bridgelabz.InvalidUserDetailsException;
import com.bridgelabz.UserRegistrationRegex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class UserRegistrationTest {
    static UserRegistrationRegex userRegistration;

    @BeforeAll
    public static void initialize() {
        userRegistration = new UserRegistrationRegex();
    }

    @Test
    public void givenFirstName_WhenValid_ShouldReturnsTrue() throws InvalidUserDetailsException {
        boolean result = userRegistration.validateFirstName("Abc");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenInValid_ShouldReturnsFalse() {
        Assertions.assertThrows(InvalidUserDetailsException.class, () -> userRegistration.validateFirstName("ab"));
    }

    @Test
    public void givenLastName_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result = userRegistration.validateLastName("Xyz");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenInValid_ShouldReturnFalse() {
        Assertions.assertThrows(InvalidUserDetailsException.class,() -> userRegistration.validateLastName("xy"));
    }

    @Test
    public void givenEmail_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result = userRegistration.validateEmail("Abc.def@xyz.co.in");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_WhenInValid_ShouldReturnFalse() {
       Assertions.assertThrows(InvalidUserDetailsException.class, () -> userRegistration.validateEmail("Abc.co.in"));
    }

    @Test
    public void givenMobileNumber_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result = userRegistration.validateMobileNo("91 8962782478");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMobileNumber_WhenInValid_ShouldReturnFalse() {
   Assertions.assertThrows(InvalidUserDetailsException.class, () -> userRegistration.validateMobileNo("962345624"));
    }

    @Test
    public void givenPassword_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result = userRegistration.validatePassword("A54tbh15@");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPassword_WhenInValid_ShouldReturnFalse() {
        Assertions.assertThrows(InvalidUserDetailsException.class,() -> userRegistration.validatePassword("89621a"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com", "abc-100@abc.net", "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com"})
    public void givenEmail_WhenValid_ShouldReturnTrue(String email) throws InvalidUserDetailsException {
        Assertions.assertTrue(userRegistration.validateEmail(email));

    }
    @ParameterizedTest
    @ValueSource(strings = {"abc","abc@.com.my","abc123@gmail.a","abc123@.com","abc123@.com.com","abc()*@gmail.com","abc@%*.com","abc..2002@gmail.com","abc.@gmail.com","abc@abc@gmail.com","abc@gmail.com.1a","abc@gmail.com.aa.au"})
    public void givenEmail_WhenInValid_ShouldReturnFalse(String email) {
        Assertions.assertThrows(InvalidUserDetailsException.class, () -> userRegistration.validateEmail(email));
    }
}
