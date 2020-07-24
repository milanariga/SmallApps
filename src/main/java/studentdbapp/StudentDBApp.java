package studentdbapp;

import java.util.Scanner;

public class StudentDBApp {

    public static void main(String[] args) {
        System.out.println("Enter number of students enrolling");
        Scanner in = new Scanner(System.in);
        int numOfStudent = in.nextInt();
        Student[] students = new Student[numOfStudent];


        for (int i = 0; i < numOfStudent; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
            students[i].showInfo();

        }

    }
}
