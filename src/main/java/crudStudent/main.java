package crudStudent;

import student.student;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        CrudStudent stu =  new CrudStudent(1,"Tingning","Male","MIS", LocalDate.of(2005,05,05),"BTB");

        stu.header();
        stu.getAllStudents();


    }
}
