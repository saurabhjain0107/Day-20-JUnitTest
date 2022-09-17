package com.bridgelabz;

import java.util.regex.Pattern;

public class UserRegistrationRegex {
    public boolean validateFirstName(String name){
//        firstName or lastName starts with Cap and has minimum 3 characters
        Pattern pattern=Pattern.compile("^[A-Z][a-zA-Z]{2,}");
        boolean isValid = pattern.matcher(name).matches();
        if (isValid){
            System.out.println(name+" is valid");
        }else{
            System.out.println(name+" is not valid");
        }
        return isValid;
    }
    public boolean validateLastName(String name){
//        Validation for firstName or lastName is same
        boolean isValid = validateFirstName(name);
        return isValid;
    }
    public boolean validateEmail(String email){
/*        E.g. abc.xyz@bl.co.in
        Email has 3 mandatory parts (abc, bl & co) and 2 optional (xyz & in)
        with precise @ and . positions
 */
        Pattern pattern=Pattern.compile("^[a-zA-Z0-9]+([._-[+]][a-zA-Z0-9]+)*@([a-z1-9]+)([.][a-z]*)?(\\.[a-z]{2,})$");
        boolean isValid = pattern.matcher(email).matches();
        if (isValid){
            System.out.println("email is valid => "+email);
        }else
            System.out.println("email is not valid => "+email);
        return isValid;
    }
    public boolean validateMobileNo(String mobileNo){
        Pattern pattern= Pattern.compile("^[\\d]{2}\\s[\\d]{10}$");
        boolean isValid = pattern.matcher(mobileNo).matches();
        if (isValid){
            System.out.println("mobile is valid");
        }else {
            System.out.println("mobile is not valid");
        }
        return isValid;
    }
    public boolean validatePassword(String password){
        boolean isValid=validatePassRule1(password);
        if (isValid){
            isValid=validatePassRule2(password);
            if (isValid){
                isValid=validatePassRule3(password);
                if (isValid){
                    isValid=validatePassRule4(password);
                    if (isValid){
                        System.out.println("Password is valid");
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean validatePassRule1(String password){
        //minimum 8 characters
        Pattern pattern=Pattern.compile("[\\S]{8,}");
        Boolean isValid=pattern.matcher(password).matches();
        if (isValid){
            System.out.println("Rule1 Pass...");
        }else {
            System.out.println("Invalid Password! => Password must have minimum 8 characters");
        }
        return isValid;
    }
    boolean validatePassRule2(String password){
        //At least one upperCase letter
        Pattern pattern=Pattern.compile("(?=.*[A-Z])[\\S]{8,}");
        Boolean isValid=pattern.matcher(password).matches();
        if (isValid){
            System.out.println("Rule2 Pass...");
        }else {
            System.out.println("Invalid Password! => password must have at least one uppercase letter");
        }
        return isValid;
    }
    boolean validatePassRule3(String password){
        Pattern pattern=Pattern.compile("(?=.*[A-Z])(?=.*[0-9])[\\S]{8,}");
        Boolean isValid=pattern.matcher(password).matches();
        if (isValid){
            System.out.println("Rule3 Pass...");
        }else {
            System.out.println("Invalid Password! => password must have at least numeric letter");
        }
        return isValid;
    }

    boolean validatePassRule4(String password){
        //aAt least one upperCase letter
        Pattern pattern=Pattern.compile("(?=.*[A-Z])(?=.*[^\\w\\d\\s:])(?=.*[0-9])[\\S]{8,}");
        Boolean isValid=pattern.matcher(password).matches();
        if (isValid){
            System.out.println("Rule4 Pass...");
        }else {
            System.out.println("Invalid Password! => password must have one special character");
        }
        return isValid;
    }
}
