package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private int mailBoxCapacity;
    private String email;

    // Static variables
    private final static int DEFAULT_PASSWORD_LENGTH = 10;
    private final static String COMPANY_SUFFIX = "company.com";

    // Constructor taking firstName and lastName and department
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email : " + this.firstName + this.lastName);

        // set department
        this.department = setDepartment();
        System.out.println("Department : " + this.department) ;

        // set random password
        this.password = generatePassword(DEFAULT_PASSWORD_LENGTH);
        System.out.println("Password : " + this.password) ;

        // construct email combining first-name and last-name
        // @ department-name.company.com
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "." + COMPANY_SUFFIX;
        System.out.println("Email : " + this.email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("Enter the Department\n1. Sales\n2. Development\n3. Accounts\n0 None");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter department code : ");
        int department = input.nextInt();

        switch (department) {
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }
    }

    // Generate a random string password
    private String generatePassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234566789!@#$%&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);    // Create new String() as password type is array of char.
    }

    // change password

    // set mailbox capacity

    // set alternate email address


}