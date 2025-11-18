package crudStudent;

import java.time.LocalDate;
import java.util.Scanner;

public class CrudStudent {
//    Data member
    Scanner sc = new Scanner(System.in);
    private int id;
    private String name;
    private String gender;
    private String major;
    private LocalDate dob;
    private String address;

//    Constructor
    public CrudStudent(int id, String name, String gender,String major, LocalDate dob, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.dob = dob;
        this.address = address;

    }

//    function
    public void header(){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s", "id", "name", "gender", "major","dob", "address");
        System.out.println("\n");
    }

    public void getAllStudents(){

        System.out.printf("%-15d %-15s %-15s %-15s %-15tF %-15s", id, name, gender,major, dob, address);
    }


}
