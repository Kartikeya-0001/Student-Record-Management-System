package io;
import entity.Student;
import java.io.*;
import java.util.*;

public class FileHandler {
    public static List<Student> load(String file) {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String row;

            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                String course = data[3];
                double marks = Double.parseDouble(data[4]);

                list.add(new Student(id, name, email, course, marks));
            }
        } catch (Exception e) {
            System.out.println("No previous record found or error loading file.");
        }
        return list;
    }

    public static void save(String file, List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
            System.out.println("All records saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving student data.");
        }
    }
}
