import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private static int count = 1;
    private int Num;
    private String Nom;
    private String Prenom;
    public ArrayList<Double> Grades;
    double Math;
    double NoteJava;
    double English;
    double Physics;
    public Student(String Nom,String Prenom,double Math,double NoteJava,double English,double Physics){
        this.Num = count++;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Grades = new ArrayList<>();
        this.Math = Math;
        this.NoteJava = NoteJava;
        this.English = English;
        this.Physics = Physics;
    }

    public int getNum(){
        return this.Num;
    }
    public void setNum(int Num){
        this.Num = Num;
    }
    public String getNom(){
        return this.Nom ;
    }
    public void setNom(String Nom){
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public ArrayList<Double> getGrades() {
        return Grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        Grades = grades;
    }

    public double getMath() {
        return Math;
    }

    public void setMath(double math) {
        Math = math;
    }

    public double getNoteJava() {
        return NoteJava;
    }

    public void setNoteJava(double noteJava) {
        NoteJava = noteJava;
    }

    public double getEnglish() {
        return English;
    }

    public void setEnglish(double english) {
        English = english;
    }

    public double getPhysics() {
        return Physics;
    }

    public void setPhysics(double physics) {
        Physics = physics;
    }

    @Override
    public String toString() {
        return String.format("%-3d | %-12s | %-4.1f | %-4.1f | %-4.1f | %-4.1f",
                getNum(), getNom() + " " + getPrenom(), getMath(), getNoteJava(), getEnglish(), getPhysics());
    }

}
