package dao;

import model.Student;
import util.CSVUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String STUDENT_FILE = "students.csv";

    public void addStudent(Student s) throws IOException {
        CSVUtil.appendLine(STUDENT_FILE, s.toString());
    }

    public List<Student> getAllStudents() throws IOException {
        List<String> lines = CSVUtil.readAllLines(STUDENT_FILE);
        List<Student> students = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                students.add(new Student(parts[0], parts[1], parts[2]));
            }
        }
        return students;
    }
}
