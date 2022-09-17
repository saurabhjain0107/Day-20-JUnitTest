package com.bridgelabz;

import java.util.Scanner;

public class UserRegistrationMain {
    public static void main(String[] args) {
        UserRegistrationRegex regex=new UserRegistrationRegex();
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter first name: ");
        String firstName=scanner.next();
        regex.validateFirstName(firstName);

        System.out.println("\nEnter last name: ");
        String lastName=scanner.next();
        regex.validateLastName(lastName);

        System.out.println("\nEnter email: ");
        String email=scanner.next();
        regex.validateEmail(email);

        System.out.println("\nEnter mobile no as per format: (e.g. 91 9867859848) ");
        scanner.nextLine();
        String mobileNo=scanner.nextLine();
        regex.validateMobileNo(mobileNo);

        System.out.println("\nEnter Password:");
        String password=scanner.next();
        regex.validatePassword(password);

        System.out.println("\nValid Emails: ");
        String[] validEmail={"abc@yahoo.com","abc-100@yahoo.com","abc.100@yahoo.com","abc111@abc.com","abc-100@abc.net","abc.100@abc.com.au","abc@1.com","abc@gmail.com.com","abc+100@gmail.com"};
        for (String s : validEmail) {
            regex.validateEmail(s);
        }

        System.out.println("\nInValid Emails: ");
        String[] inValidEmail={"abc","abc@.com.my","abc123@gmail.a","abc123@.com","abc123@.com.com","abc()*@gmail.com","abc@%*.com","abc..2002@gmail.com","abc.@gmail.com","abc@abc@gmail.com","abc@gmail.com.1a","abc@gmail.com.aa.au"};
        for (String s : inValidEmail) {
            regex.validateEmail(s);
        }
    }
}
