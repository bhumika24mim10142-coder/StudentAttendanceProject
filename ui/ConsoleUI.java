package ui;

import model.Student;
import model.AttendanceRecord;
import service.StudentService;
import service.AttendanceService;
import util.DateUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private StudentService studentService = new StudentService();
    private AttendanceService attendanceService = new AttendanceService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {
            System.out.println("\n===== Student Attendance Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Mark Attendance");
            System.out.println("4. View Attendance By Date");
            System.out.println("5. View Attendance By Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        addStudent();
                        break;
                    case "2":
                        viewStudents();
                        break;
                    case "3":
                        markAttendance();
                        break;
                    case "4":
                        viewByDate();
                        break;
                    case "5":
                        viewByStudent();
                        break;
                    case "6":
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addStudent() throws IOException {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();

        studentService.addStudent(id, name, dept);
        System.out.println("Student added successfully.");
    }

    private void viewStudents() throws IOException {
        List<Student> students = studentService.getStudents();

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println(s.getStudentId() + " | " + s.getName() + " | " + s.getDepartment());
        }
    }

    private void markAttendance() throws IOException {

        System.out.print("Enter date (YYYY-MM-DD) or type 'today': ");
        String date = scanner.nextLine();

        if (date.equalsIgnoreCase("today")) {
            date = DateUtil.today();
        }

        if (!DateUtil.isValidDate(date)) {
            System.out.println("Invalid date format!");
            return;
        }

        List<Student> students = studentService.getStudents();
        List<String> ids = new ArrayList<>();
        List<String> statuses = new ArrayList<>();

        for (Student s : students) {
            System.out.print("Is " + s.getName() + " Present? (P/A): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.startsWith("P")) {
                statuses.add("PRESENT");
            } else {
                statuses.add("ABSENT");
            }

            ids.add(s.getStudentId());
        }

        attendanceService.markAttendance(date, ids, statuses);
        System.out.println("Attendance recorded for " + date);
    }

    private void viewByDate() throws IOException {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        List<AttendanceRecord> records = attendanceService.getByDate(date);

        System.out.println("\n--- Attendance for " + date + " ---");
        for (AttendanceRecord r : records) {
            System.out.println(r.getStudentId() + " | " + r.getStatus());
        }
    }

    private void viewByStudent() throws IOException {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        List<AttendanceRecord> records = attendanceService.getByStudent(id);

        System.out.println("\n--- Attendance for Student " + id + " ---");
        for (AttendanceRecord r : records) {
            System.out.println(r.getDate() + " | " + r.getStatus());
        }
    }
}
