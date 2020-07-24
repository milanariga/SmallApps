package emailApp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String companySuffix = "adf.com";
    private int defaultPassLength = 8;
    private String department;
    private int mailboxCapacity = 500;
    private String alternativeEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //System.out.println("emailApp.Email created: " + this.firstName + " " + this.lastName);

        this.department = getDepartment();
        //System.out.println("Department " + department);

        this.password = generatePassword(defaultPassLength);
        //System.out.println("Password: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        //System.out.println("emailApp.Email: " + email);
    }

    private String getDepartment(){
        System.out.print("Departments codes:\n1 Sales\n2 Development\n3 Accounting\n4 none\nEnter the code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if (depChoice == 1){
            return "sales";
        }
        else if (depChoice == 2){
            return "dev";
        }
        else if (depChoice == 3){
            return "acc";
        }
        else {
            return "";
        }
    }

    private String generatePassword(int length){
        String passwordOption = "ABCDEFGHIJKLMNOPRSTUWXYZabcdefghijklmnoprstuwxyz1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordOption.length());
            password[i] = passwordOption.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void setAlternativeEmail(String altEmail) {
        this.alternativeEmail = altEmail;
    }

    public void changePassword(String pass){
        this.password = pass;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternativeEmail(){
        return alternativeEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nEmail: " + email +
                "\nMailbox capacity: " + mailboxCapacity + "MB";
    }
}

