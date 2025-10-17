import java.util.ArrayList;


public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public boolean addStudent(Student s) {
        for (Student st : students) {
            if (st.getNom().equalsIgnoreCase(s.getNom()) &&
                    st.getPrenom().equalsIgnoreCase(s.getPrenom())) {
                System.out.println("⚠ Student with the same name already exists: " + st);
                return false;
            }
        }
        students.add(s);
        return true;
    }

    /*    public Student removeStudent(int num){
            if(num>0 && num <students.size()){
                return students.remove(num);
            }
            return null;

    }
    ✅ Pros:

Very short and simple.

Directly uses the index in the ArrayList.

❌ Cons:

It removes a student based on their position in the list, not their actual student number.

If your list order changes (like after sorting), remove(2) might delete a different student than you expect.

The Num you auto-generate and the index are not always the same thing.*/
public Student removeStudent(int num){
    for (Student st : students){
        if (st.getNum() == num){
            students.remove(st);
            System.out.println("✅ Student removed: "+ st);
            return st;
        }
    }
    System.out.println("⚠ No student found with number: " + num);
    return null;
}
    public Student findStudent(int num){
        for (Student st : students){
            if (st.getNum() == num){
                System.out.println(st.toString());
                return st;
            }

        }
        System.out.println("there's no such a student with this number: "+num);
        return null;
    }
    public Student FindStudentName(String Nom, String Prenom){
        for (Student st : students){
            if(st.getNom().equalsIgnoreCase(Nom) && st.getPrenom().equalsIgnoreCase(Prenom)){
                System.out.println(st.toString());
                return st;
            }
        }
        System.out.println("there's no such a student with this name: "+Nom+""+Prenom);
        return null;
    }
    public void displayStudents(){
        for (Student  s : students){
            System.out.println(s.toString());
        }

    }
}
