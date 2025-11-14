package entity;

public class Student implements Comparable<Student> {

    private int id;
    private String fullName;
    private String mail;
    private String program;
    private double score;

    public Student(int id, String fullName, String mail, String program, double score) {
        this.id = id;
        this.fullName = fullName;
        this.mail = mail;
        this.program = program;
        this.score = score;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public double getScore() { return score; }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.score, other.score);
    }

    @Override
    public String toString() {
        return id + "|" + fullName + "|" + mail + "|" + program + "|" + score;
    }

    public void show() {
        System.out.println("\nRoll No: " + id);
        System.out.println("Name: " + fullName);
        System.out.println("Email: " + mail);
        System.out.println("Course: " + program);
        System.out.println("Marks: " + score);
    }
}
