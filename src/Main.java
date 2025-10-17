import java.io.*;
import java.util.Scanner;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n===== Student Manager Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student by Number");
            System.out.println("3. Find Student by Number");
            System.out.println("4. Find Student by Name");
            System.out.println("5. Display All Students");
            System.out.println("0. Exit");
            System.out.print("👉 Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s = new Student("", "", 0, 0, 0, 0); // temporary empty values

                    System.out.print("Enter First Name: ");
                    s.setNom(sc.next());

                    System.out.print("Enter Last Name: ");
                    s.setPrenom(sc.next());

                    System.out.print("Enter Math grade: ");
                    s.setMath(sc.nextDouble());

                    System.out.print("Enter Java grade: ");
                    s.setNoteJava(sc.nextDouble());

                    System.out.print("Enter English grade: ");
                    s.setEnglish(sc.nextDouble());

                    System.out.print("Enter Physics grade: ");
                    s.setPhysics(sc.nextDouble());

                    if (manager.addStudent(s)) {
                        System.out.println("✅ Student added: " + s);
                    } else {
                        System.out.println("⚠ Student already exists!");
                    }
                    break;


                case 2:
                    System.out.print("Enter student number to remove: ");
                    int numRemove = sc.nextInt();
                    manager.removeStudent(numRemove);
                    break;

                case 3:
                    System.out.print("Enter student number to find: ");
                    int numFind = sc.nextInt();
                    manager.findStudent(numFind);
                    break;

                case 4:
                    System.out.print("Enter First Name: ");
                    String searchNom = sc.next();
                    System.out.print("Enter Last Name: ");
                    String searchPrenom = sc.next();
                    manager.FindStudentName(searchNom, searchPrenom);
                    break;

                case 5:
                    System.out.println("\n📋 All Students:");
                    System.out.println("Num | Name           | Math | Java | Eng  | Phys");
                    System.out.println("------------------------------------------------");
                    manager.displayStudents();
                    break;

                case 0:
                    System.out.println("👋 Exiting...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}