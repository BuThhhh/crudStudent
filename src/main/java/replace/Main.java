package replace;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

class Student{
    private int id;
    private String name;
    private String gender, major, dob, address;

    public static Scanner sc = new Scanner(System.in);
    public static int count=0;

    public Student(int id, String name, String gender, String major, String dob, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.dob = dob;
        this.address = address;
    }
    public String getName(){
        return name;
    }
    public Student(){
        id=0;
        name="";
        gender="";
        major="";
        dob="";
    }
    public static void header(){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s ", "id", "name", "gender", "major", "dob", "address");
    }
    public void output(){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s ",this.id,this.name,this.gender,this.major,this.dob,this.address);
    }
    public static void input(Student[] stu){

        sc.nextLine();
        System.out.print("Enter Name : ");
        String name=sc.nextLine();
        System.out.print("Enter Gender : ");
        String gender=sc.nextLine();
        System.out.print("Enter Major : ");
        String major=sc.nextLine();
//        System.out.print("Enter Dob : ");
        String dob= LocalDate.now().toString();
        System.out.print("Enter Address : ");
        String address=sc.nextLine();

        stu[count] = new Student(count+1,name,gender,major,dob,address);
        count++;
    }

    public static void output(Student[] stu){
        header();
        System.out.println();
        for(int i=0;i<count;i++){
            stu[i].output();
            System.out.println();
        }
    }

    public static void search(String namesearch ,Student[] stu){
        boolean check=false;
        header();
        System.out.println();
        for(int i=0;i<count;i++){
            if(namesearch.equalsIgnoreCase(stu[i].getName())){
                stu[i].output();
                check=true;
            }
        }
        System.out.println((!check)?"RECORD FOUND":"RECORD NOT FOUND");
    }

    public int getId(){
        return id;
    }
    public static void update(String names, Student[] stu){
        boolean check=false;

        for (int i=0;i<count;i++){
            if(stu[i].getName().equalsIgnoreCase(names)){
                System.out.print("Enter Name : ");
                String name=sc.nextLine();
                System.out.print("Enter Gender : ");
                String gender=sc.nextLine();
                System.out.print("Enter Major : ");
                String major=sc.nextLine();
//        System.out.print("Enter Dob : ");
                String dob= LocalDate.now().toString();
                System.out.print("Enter Address : ");
                String address=sc.nextLine();

                stu[i] = new Student(stu[i].getId(),name,gender,major,dob,address);
                check=true;
                break;
            }
        }
        System.out.println((!check)?"UPDATE COMPLETE":"UPDATE NOT COMPLETE");
    }
    public static void delete(String names, Student[] stu){
        boolean check=false;
        for (int i=0;i<count;i++){
            if(stu[i].getName().equalsIgnoreCase(names)){
                for(int j=0;j<count-1;j++){
                    stu[j]=stu[j+1];
                }
                --count;
                check=true;
            }
        }
        System.out.println((!check)?"DELETE NOT COMPLETE":"DELETE COMPLETE");
    }
    public static void sort(Student[] stu){
        boolean check=false;

        for(int i=0;i<count;i++){
            for(int j=0;j<count-1;j++){
                if(stu[j].getName().compareToIgnoreCase(stu[j+1].getName())>0) {
                    Student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                    check = true;
                }
            }
        }
        System.out.println((!check)?"SORT NOT COMPLETE":"SORT COMPLETE");
    }
}
public class Main {
    public static void main(String[] args) {
        Student[] storage=new Student[10];
        int op =1;
        while(op!=0){
            System.out.print("\n---------------> USE FUNCTION CRUD ARRAY <---------------\n"+
                    "1. Create                      \n"+
                    "2. Read                        \n"+
                    "3. Search                      \n"+
                    "4. Update                      \n"+
                    "5. Delete                      \n"+
                    "6. Sort                        \n"+
                    "7. Exit                        \n"+
                    "=======================================================\n");

            System.out.print("Enter your Option: ");
            op = Student.sc.nextInt();
            switch(op){
                case 1-> Student.input(storage);
                case 2-> Student.output(storage);
                case 3->{
                    Student.sc.nextLine();
                    System.out.println("Search by name : ");
                    String namesearch =Student.sc.nextLine();
                    Student.search(namesearch,storage);
                }
                case 4->{
                    Student.sc.nextLine();
                    System.out.println("Update by name : ");
                    String names =Student.sc.nextLine();
                    Student.update(names,storage);
                }
                case 5 ->{
                    Student.sc.nextLine();
                    System.out.print("Delete by name : ");
                    String names =Student.sc.nextLine();
                    Student.delete(names,storage);
                }
                case 6 ->{
                    Student.sort(storage);
                }
                case 7->{
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }
}

