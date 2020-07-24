package studentdbapp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private  int tuitionBalance;
    private static int courseFee = 600;
    private static int id = 1001;

    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student's name: ");
        this.firstName = in.nextLine();
        System.out.print("Enter student's last name: ");
        this.lastName = in.nextLine();
        System.out.print("1 - Freshman \n2 - Sophomore \n3 - Junior \n4 - Senior\nEnter student's class level: ");
        this.gradeYear = in.nextInt();

        generateId();
    }

    private void generateId(){
        id++;
        this.studentID = gradeYear + "" + id;
    }

    public void enroll() {
        do {
            System.out.println("Enter the course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + courseFee;
            } else {
                break;
            }
        }
            while (1 !=0);
    }

    public void viewBalance(){
        System.out.println("Balance is: " + tuitionBalance + " EUR");
    }

    public void payTuition(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter payment amount: ");
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Payment of " + payment + " received.");
        viewBalance();
    }

    public void showInfo(){
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Grade level: " + gradeYear + "\nStudent ID: " + studentID);
        System.out.println("Courses enrolled: " + courses);
        System.out.println("Balance: " + tuitionBalance + " EUR");
    }
}
