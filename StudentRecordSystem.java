package controller;
import entity.Student;
import java.util.*;

public class StudentRecordSystem {

    private List<Student> db;

    public StudentRecordSystem(List<Student> db) {
        this.db = db;
    }

    public void insert(Student s) {
        db.add(s);
        System.out.println("Student inserted.");
    }
    public void displayAll() {
        Iterator<Student> itr = db.iterator();
        while (itr.hasNext()) {
            itr.next().show();
        }
    }
    public void searchByFullName(String name) {
        boolean flag = false;
        for (Student s : db) {
            if (s.getFullName().equalsIgnoreCase(name)) {
                s.show();
                flag = true;
            }
        }
        if (!flag) System.out.println("No matching student found.");
    }
    public void removeByFullName(String name) {
        db.removeIf(s -> s.getFullName().equalsIgnoreCase(name));
        System.out.println("Delete operation executed.");
    }
    public void sortDescendingMarks() {
        db.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));
        System.out.println("Students sorted by marks (highest to lowest):");
        displayAll();
    }
}
