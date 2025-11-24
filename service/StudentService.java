package service;

import dao.StudentDAO;
import model.Student;

import java.io.IOException;
import java.util.List;

public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public void addStudent(String id, String name, String dept) throws IOException {
        Student s = new Student(id, name, dept);
        studentDAO.addStudent(s);
    }

    public List<Student> getStudents() throws IOException {
        return studentDAO.getAllStudents();
    }
}

