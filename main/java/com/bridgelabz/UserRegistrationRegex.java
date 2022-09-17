package com.bridgelabz;

import java.util.regex.Pattern;

public class UserRegistrationRegex {
    public boolean validateFirstName(String name) throws InvalidUserDetailsException{
 //        firstName or lastName starts with Cap and has minimum 3 characters
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]{2,}");
        boolean isValid = pattern.matcher(name).matches();
        if (isValid) {
            return true;
        } else {
            throw new InvalidUserDetailsException("Invalid First Name => " + name);
        }
    }

    public boolean validateLastName(String name) throws InvalidUserDetailsException {
//        Validation for firstName or lastName is same
        boolean isValid = validateFirstName(name);
        if (isValid) {
            return true;
        } else {
            throw new InvalidUserDetailsException("Invalid Last Name => " + name);
        }
    }

    public boolean validateEmail(String email) throws InvalidUserDetailsException {
/*        E.g. abc.xyz@bl.co.in
        Email has 3 mandatory parts (abc, bl & co) and 2 optional (xyz & in)
        with precise @ and . positions
 */
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+([._-[+]][a-zA-Z0-9]+)*@([a-z1-9]+)([.][a-z]*)?(\\.[a-z]{2,})$");
        boolean isValid = pattern.matcher(email).matches();
        if (isValid) {
            return true;
        } else {
            throw new InvalidUserDetailsException("Invalid email => " + email);
        }
    }

    public boolean validateMobileNo(String mobileNo) throws InvalidUserDetailsException {
        Pattern pattern = Pattern.compile("^[\\d]{2}\\s[\\d]{10}$");
        boolean isValid = pattern.matcher(mobileNo).matches();
        if (isValid) {
            return true;
        } else {
            throw new InvalidUserDetailsException("Invalid Mobile Number => " + mobileNo);
        }
    }

    public boolean validatePassword(String password) throws InvalidUserDetailsException {
        boolean isValid = validatePassRule1(password);
        if (isValid) {
            isValid = validatePassRule2(password);
            if (isValid) {
                isValid = validatePassRule3(password);
                if (isValid) {
                    isValid = validatePassRule4(password);
                    if (isValid) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean validatePassRule1(String password) throws InvalidUserDetailsException {
        //minimum 8 characters
        Pattern pattern = Pattern.compile("[\\S]{8,}");
        Boolean isValid = pattern.matcher(password).matches();
        if (isValid) {
            return true;
        } else {
            throw new InvalidUserDetailsException("Invalid Password => Password must have minimum 8 characters");
        }
    }

    boolean validatePassRule2(String password) throws InvalidUserDetailsException {
        //At least one upperCase letter
        Pattern pattern = Pattern.compile("(?=.*[A-Z])[\\S]{8,}");
        Boolean isValid = pattern.matcher(password).matches();
        if (isValid) {
            return true;
        } else {
            throw new InvalidUserDetailsException("Invalid Password => password must have at least one uppercase letter");
        }
    }

    boolean validatePassRule3(String password) throws InvalidUserDetailsException {
        //At least one upperCase letter
        Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[0-9])[\\S]{8,}");
        Boolean isValid = pattern.matcher(password).matches();
        if (isValid) {
            return true;
        } else {
            throw new InvalidUserDetailsException("Invalid Password => password must have at least numeric letter");
        }
    }

    boolean validatePassRule4(String password) throws InvalidUserDetailsException {
        //At least one upperCase letter
        Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[^\\w\\d\\s:])(?=.*[0-9])[\\S]{8,}");
        Boolean isValid = pattern.matcher(password).matches();
        if (isValid) {
            return true;
        } else {
            throw new InvalidUserDetailsException("Invalid Password => password must have one special character");
        }
    }
}
