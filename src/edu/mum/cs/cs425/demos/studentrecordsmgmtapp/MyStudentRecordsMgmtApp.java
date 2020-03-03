package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) {

        ArrayList <Student> arr = new ArrayList<>();
        arr.add(new Student(110001, "Dave", LocalDate.of(1951, 11,18)));
        arr.add(new Student(110002, "Anna", LocalDate.of(19901, 12,7)));
        arr.add(new Student(110003, "Erica", LocalDate.of(1974, 1,31)));
        arr.add(new Student(110004, "Carlos", LocalDate.of(2009, 8,22)));
        arr.add(new Student(110005, "Bob", LocalDate.of(1990, 3,5)));

        MyStudentRecordsMgmtApp.printListOfStudents(arr);
        MyStudentRecordsMgmtApp.getListOfPlatinumAlumniStudents(arr);

        ArrayList <Integer> arr2 = new ArrayList<> (Arrays.asList(20,15,35,22,21));
        MyStudentRecordsMgmtApp.printHelloWorld(arr2);

        ArrayList <Integer> arr3 = new ArrayList<> (Arrays.asList(1,2,3,4,5));
        ArrayList <Integer> arr4 = new ArrayList<> (Arrays.asList(19,9,11,0,12));
        MyStudentRecordsMgmtApp.findSecondBiggest(arr3);
        MyStudentRecordsMgmtApp.findSecondBiggest(arr4);
    }



    public static void printListOfStudents(List<Student> list){
        list.sort(Comparator.comparing(Student::getName));
        System.out.println("******List of Students******");
        for (Student student: list) {
            System.out.println(student);
        }
    }

    public  static void getListOfPlatinumAlumniStudents(List<Student> list){
        list.sort(Comparator.comparing(Student::getDateOfAdmission).reversed());
        System.out.println("******Platinum Alumni students******");
        for (Student student: list) {
            if(student.getDateOfAdmission().getYear()<=1990) System.out.println(student);
        }
    }

    public static void printHelloWorld(List<Integer> list){
        System.out.println("******Divisible by 5 or 7?******");
        for (int x: list) {
                    if(x%5 == 0 && x%7 == 0) System.out.println(x + " Hello World");
                    else if (x%7 == 0) System.out.println(x + " World");
                    else if (x%5 == 0 ) System.out.println(x + " Hello");
                }
    }

    public static void findSecondBiggest(List<Integer> list){
        int max = 0;
        int max2 = 0;

        for (int x: list) {
            if(x>max) max = x;
        }
        for(int x: list){
            if (x<max && x>max2) max2 = x;
        }
        System.out.println("Second largest number of " +list.toString() + "= " + max2);
    }
}
