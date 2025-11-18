package student;
import java.time.LocalDate;
import java.util.Scanner;

public class student {
    Scanner sc=new Scanner(System.in);
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public int id;
    public String name;
    public int age;
    public String gender;
    public int grade;
    public String major;
    public LocalDate dob;
    public String address;
    public int n;
    public student[] stu;

    public void Option(){
        System.out.print("\n\n"+CYAN +"---------------> USE FUNCTION CRUD ARRAY <---------------\n\n"+RESET+
                "1. Create                   \n"+
                "2. Read                       \n"+
                "3. Search                      \n"+
                "4. Update                      \n"+
                "5. Delete                      \n"+
                "6. Sort                        \n"+
                "7. Exit                        \n");
    }

    public void goodbye(){
        System.out.println(RED + "Goodbye !" + RESET);
    }

    public void InvalidArray() {
        System.out.println(RED+"=======> Invalid <======="+RESET);
    }
    public void InvalidOption() {
        System.out.println(RED + "=======> Invalid option <=======" + RESET);
    }

    public void createStudent(){
        System.out.print("Enter your ID : ");
        id=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your name : ");
        name=sc.nextLine();
        System.out.print("Enter your age : ");
        age=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your gender : ");
        gender=sc.nextLine();
        System.out.print("Enter your grade : ");
        grade=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your major : ");
        major=sc.nextLine();
        System.out.print("Enter your dob : ");
          dob=LocalDate.now();
        sc.nextLine();
        System.out.print("Enter your address : ");
        address = sc.nextLine();

    }

    public void input() {
        System.out.print("Enter number of students: ");
        n = sc.nextInt();
        sc.nextLine();
        stu = new student[n];
    }

    public void insertStudent() {
            input();
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            stu[i] = new student();
            stu[i].createStudent();
        }
    }

    public void displayStudent() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Grade: " + grade);
        System.out.println("Major: " + major);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Address: " + address);
        System.out.println("----------------------------");
    }
    public void showAllStudents() {
        System.out.println("\nAll Students Information: ");
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student Information "+(i+1)+"---");
            stu[i].displayStudent();
        }
    }

    public void deleteStudent() {
        System.out.println("=======> Delete <=======");
        boolean check = false;
        System.out.print("Enter Student id to Delete : ");
        int DeleteValue = sc.nextInt();

        for(int i=0;i<n;i++){
            if(DeleteValue == stu[i].id){
                for(int j=i;j<n-1;j++){
                    stu[j]=stu[j+1];
                }
                --n;
            }
        }
        System.out.println((!check)?"Delete Successfully": "No record found 😊!");
    }

    public void searchStudent() {
        System.out.println("=======> Search <=======");
        boolean check = false;
        System.out.print("Enter id or name you want to Search : ");
        String SearchValue = sc.nextLine();

        for(int i=0;i<n;i++){
            if (SearchValue.equals(String.valueOf(stu[i].id)) || SearchValue.equalsIgnoreCase(stu[i].name)){
                stu[i].displayStudent();
                check = true;
            }
        }
        System.out.println((check)?" ": "No record found !");
    }

    public void updateStudent() {
        System.out.println("=======> Update <=======");
        System.out.print("Enter Number you want to Update : ");
        int updateValue = sc.nextInt();
        boolean check = false;

        for (int i = 0; i < n; i++) {
            if (stu[i].id == updateValue) {
                stu[i].insertStudent();
                check = true;
                System.out.println("Updated successfully!");
                break;
            }
        }
        System.out.println((check)? "No record found !": "");
    }

    public void sortStudent() {
        System.out.println("=======> Sort <=======");
        if (stu == null || n == 0) {
            System.out.println("No students to sort!");
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (stu[j].id > stu[j + 1].id) {
                    // swap
                    student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }

        System.out.println("\nStudents sorted by ID (ascending):");
        showAllStudents();

    }
}