import java.io.*;
import java.util.Scanner;

public class Main implements Serializable {
    // 🎨 Colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[0;35m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String GREEN = "\u001B[0;32m";
    public static final String WHITE = "\u001B[37m";
    public static final String BackBlue = "\u001B[0;104m";

    public static void main(String[] args) throws  InterruptedException {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            // 🌟 Short, compact animation
            clearScreen();
            loadingBar("Loading Student Manager System", 20);
            glowHeaderCompact();

            // 🧭 Menu Options
            System.out.println(PURPLE +  "║  1️⃣  🆕 Add Student                            ║" + RESET);
            System.out.println(RED +    "║  2️⃣  ❌ Remove Student by Number               ║" + RESET);
            System.out.println(CYAN +   "║  3️⃣  🔢 Find Student by Number                 ║" + RESET);
            System.out.println(WHITE +   "║  4️⃣  🧑‍🎓 Find Student by Name                 ║" + RESET);
            System.out.println(GREEN +  "║  5️⃣  📋 Display All Students                   ║" + RESET);
            System.out.println(YELLOW + "║  0️⃣  🚪 Exit                                   ║" + RESET);
            System.out.println(CYAN +"╚════════════════════════════════════════════════╝" + RESET);


            typePrint(YELLOW + "\n👉 Enter your choice: " + RESET, 2);
            choice = sc.nextInt();
            //System.out.println(GREEN + "You chose option " + choice + " ✅" + RESET);

            switch (choice) {
                case 1:
                    Student s = new Student("", "", 0, 0, 0, 0);
                    System.out.print("\n Enter First Name: "); s.setNom(sc.next());
                    System.out.print("Enter Last Name: "); s.setPrenom(sc.next());
                    s.setMath(checkValidGrade(sc, "Math"));
                     s.setNoteJava(checkValidGrade(sc, "Java"));
                     s.setEnglish(checkValidGrade(sc, "English"));
                     s.setPhysics(checkValidGrade(sc, "Physics"));
                    if (manager.addStudent(s)){
                        System.out.println(GREEN + "\n✅ Student added successfully!" + RESET);
                        System.out.println(CYAN + s + RESET);

                    }else
                        System.out.println("⚠ Student already exists!");
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
                    System.out.println(/*BackBlue+*/ "Num | Name           | Math | Java | Eng  | Phys");
                    System.out.println("------------------------------------------------");
                    manager.displayStudents();
                    break;

                case 0:
                    System.out.println("👋 Exiting...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }

            Thread.sleep(600);
        } while (choice != 0);

        sc.close();
    }


    // 🧼 Clear Screen
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").startsWith("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Could not clear the screen.");
        }
    }


    public static void glowHeaderCompactV2() throws InterruptedException {
        String[] colors = {CYAN, BLUE, MAGENTA, GREEN, YELLOW};
        String title = "🎓 Student Manager Menu";

        for (String color : colors) {
            System.out.print("\r" + color + title + RESET);
            Thread.sleep(100);
        }
        System.out.println("\n" + CYAN + "────────────────────────────────────────────────" + RESET + "\n");
    }


    // 💫 Compact glowing header
    public static void glowHeaderCompact() throws InterruptedException {
        String[] colors = {CYAN, BLUE, MAGENTA, GREEN, YELLOW};
        String title = "🎓  Student Manager Menu";

        System.out.println();
        for (String color : colors) {
            System.out.print("\r" + color + "╔════════════════════════════════════════════════╗" + RESET);
            Thread.sleep(70);
        }
        System.out.println();
        for (String color : colors) {
            System.out.print("\r" + color + "║        " + title + "                ║" + RESET);
            Thread.sleep(70);
        }
        System.out.println();
        for (String color : colors) {
            System.out.print("\r" + color + "╚════════════════════════════════════════════════╝" + RESET);
            Thread.sleep(70);
        }
        System.out.println("\n");
    }


    // 💫 Loading Bar Animation
    public static void loadingBar(String message, int length) throws InterruptedException {
        System.out.print(PURPLE + message + " ");
        for (int i = 0; i <= length; i++) {
            System.out.print("█");
            Thread.sleep(25);
        }
        System.out.println(RESET + " ✅\n");
        Thread.sleep(200);
    }

    // ✍️ Typewriter
    public static void typePrint(String text, int delay) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            Thread.sleep(delay);
        }
    }
    public static double checkValidGrade(Scanner sc, String Subject){
        double Grade;
        do {
            System.out.print("Enter "+Subject+" grade (0 - 20): ");
            Grade = sc.nextDouble();
            if (Grade<0 || Grade >20){
                System.out.println(RED + "⚠️ Invalid Input! Please Enter A Value Between 0 And 20." + RESET);
            }
        }while (Grade < 0 || Grade > 20);
        return Grade;
    }
}
