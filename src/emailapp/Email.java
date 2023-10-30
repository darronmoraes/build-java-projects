package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private int mailBoxCapacity = 500;
    private String email;

    // Static variables
    private final static int DEFAULT_PASSWORD_LENGTH = 10;
    private final static String COMPANY_SUFFIX = "company.com";

    // Constructor taking firstName and lastName and department
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email : " + this.firstName + this.lastName);

        // set department
        this.department = setDepartment();
        //System.out.println("Department : " + this.department) ;

        // set random password
        this.password = generatePassword(DEFAULT_PASSWORD_LENGTH);
        //System.out.println("Password : " + this.password) ;

        // construct email and set
        this.email = generateEmail();
        //System.out.println("Email : " + this.email);
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

    // Construct email having first-name and last-name
    private String generateEmail() {
        if (this.department.isEmpty()) {
            return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + COMPANY_SUFFIX;
        } else {
            return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "." + COMPANY_SUFFIX;
        }
    }

    // change password
    public void changePassword(String password) {
        this.password = password;
    }

    // set mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    // set alternate email address
    public void setAlternateEmail(String email) {
        this.alternateEmail = email;
    }

    // Get mailbox capacity
    public int getMailBoxCapacity() {return this.mailBoxCapacity;}

    // Get alternate address
    public String getAlternateEmail() {return this.alternateEmail;}

    // Get password
    public String getPassword() {return this.password;}

    // function to display name, email and mail-box capacity
    public void display() {
        System.out.println("NAME : " + this.firstName + " " + this.lastName);
        System.out.println("EMAIL : " + this.email);
        System.out.println("MAIL-BOX CAPACITY : " + this.mailBoxCapacity);
    }
}
