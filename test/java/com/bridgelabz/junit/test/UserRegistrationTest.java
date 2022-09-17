package com.bridgelabz.junit.test;

import com.bridgelabz.UserRegistrationRegex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class UserRegistrationTest {
    static UserRegistrationRegex userRegistration;
    @BeforeAll
    public static void initialize(){
        userRegistration =new UserRegistrationRegex();
    }
    @Test
    public void givenFirstName_WhenValid_ShouldReturnsTrue(){
        boolean result= userRegistration.validateFirstName("Abc");
        Assertions.assertTrue(result);
    }
    @Test
    public void givenFirstName_WhenInValid_ShouldReturnsFalse(){
        boolean result= userRegistration.validateFirstName("ab");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenLastName_WhenValid_ShouldReturnTrue(){
        boolean result= userRegistration.validateLastName("Xyz");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenInValid_ShouldReturnFalse(){
        boolean result= userRegistration.validateLastName("xy");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenEmail_WhenValid_ShouldReturnTrue(){
        boolean result=userRegistration.validateEmail("Abc.def@xyz.co.in");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_WhenInValid_ShouldReturnFalse(){
        boolean result=userRegistration.validateEmail("Abc.co.in");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenMobileNumber_WhenValid_ShouldReturnTrue(){
        boolean result=userRegistration.validateMobileNo("91 9874561230");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMobileNumber_WhenInValid_ShouldReturnFalse(){
        boolean result=userRegistration.validateMobileNo("965874526");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenPassword_WhenValid_ShouldReturnTrue(){
        boolean result=userRegistration.validatePassword("A54tbh15@");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPassword_WhenInValid_ShouldReturnFalse(){
        boolean result=userRegistration.validatePassword("96526d");
        Assertions.assertFalse(result);
    }

}
