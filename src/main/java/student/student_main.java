package student;
import java.util.Scanner;

public class student_main {

    public static Scanner sc = new Scanner(System.in);
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        int op=0;
        student stu = new student();
        stu.Option();

        do{
            System.out.print(RED + "\nPlease choose an option: " + RESET);

            if (!sc.hasNextInt()) {
                sc.nextLine();
                stu.InvalidOption();
                continue;
            }
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1->stu.insertStudent();
                case 2->stu.showAllStudents();
                case 3->stu.searchStudent();
                case 4->stu.updateStudent();
                case 5->stu.deleteStudent();
                case 6->stu.sortStudent();
                case 7->{
                    stu.goodbye();
                    return;}
                default -> stu.InvalidArray();
            }
        }while(op<=7);
    }

    }

