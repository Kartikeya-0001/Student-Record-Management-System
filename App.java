import controller.StudentRecordSystem;
import entity.Student;
import io.FileHandler;
import java.util.*;

public class App {

    public static void main(String[] args) {

        List<Student> studentList = FileHandler.load("students.txt");

        System.out.println("Students Successfully Loaded:");
        for (Student s : studentList) s.show();

        StudentRecordSystem system = new StudentRecordSystem(studentList);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Student Record Console ======");
            System.out.println("1. Register New Student");
            System.out.println("2. Display All Records");
            System.out.println("3. Lookup by Name");
            System.out.println("4. Remove by Name");
            System.out.println("5. Sort by Highest Marks");
            System.out.println("6. Save Changes & Quit");
            System.out.print("Select option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Roll No: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Full Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Marks: ");
                    double marks = Double.parseDouble(sc.nextLine());

                    system.insert(new Student(id, name, email, course, marks));
                    break;

                case 2:
                    system.displayAll();
                    break;

                case 3:
                    System.out.print("Enter Name to Search: ");
                    system.searchByFullName(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Name to Remove: ");
                    system.removeByFullName(sc.nextLine());
                    break;

                case 5:
                    system.sortDescendingMarks();
                    break;

                case 6:
                    FileHandler.save("students.txt", studentList);
                    System.out.println("Exiting Program...");
                    return;

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }
}
