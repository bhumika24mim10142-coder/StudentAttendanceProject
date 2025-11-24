Student Attendance Management System (SAMS)
The Student Attendance Management System (SAMS) is a simple, console-based Java application designed to help maintain student records and mark attendance in an organized and persistent way. The project focuses on clean architecture, practical Java concepts, and easy data management using CSV file handling.
This system helps the user (teacher/admin) to store student details, mark daily attendance, and check attendance reports anytime. Data is saved permanently in CSV files, so even after closing the program, all information remains safe.

Key Features
Student Management: Add new students and view the complete list of students.


Attendance Marking: Mark attendance (Present/Absent) for any selected date.


Attendance Reports:


View attendance for a specific date


View attendance history of a specific student


Persistent Data Storage: All student and attendance records are saved in CSV files.


Simple Console UI: Easy-to-follow menu-driven interface for smooth interaction.


Validation: Date format validation ensures proper data entry.



Technology Stack
Component
Description
Language
Java
Storage Format
CSV (for permanent data storage)
Date Handling
java.time.LocalDate
Architecture
Multi-layered (UI → Service → DAO → CSV Files)


Project Structure
The project is divided into multiple packages to keep everything organized and maintainable.
Package
Purpose
model
Contains basic data classes like Student and AttendanceRecord
dao
Handles reading/writing CSV files
service
Contains business logic (add student, mark attendance, etc.)
util
Utility classes for CSV operations and date validation
ui
Handles the user interface and menu navigation


Files and Their Roles
File Name
Description
MainMenu.java
Contains the main method and controls the UI workflow
ConsoleUI.java
Shows menu and takes user input
StudentService.java
Business logic for students
AttendanceService.java
Business logic for attendance
StudentDAO.java
Saves/reads student data in CSV
AttendanceDAO.java
Saves/reads attendance data in CSV
Student.java
Model class for student details
AttendanceRecord.java
Model class for attendance entry
CSVUtil.java
Utility class for CSV reading/writing
DateUtil.java
Validates date format


Getting Started
Prerequisites
You need to have JDK installed on your system.
Compiling and Running
Download or clone the src folder. Then:
Open terminal inside the src directory.


Compile the project:


javac */*.java */*/*.java

Run the application:


java ui.MainMenu


Usage
Below is the explanation of each menu option:
Option
Description
What Happens
1. Add Student
Add student ID, name, and department
Creates a new Student object and saves it
2. View Students
Show all registered students
Displays list fetched from students.csv
3. Mark Attendance
Mark Present/Absent for each student for a given date
Saves attendance entries into attendance.csv
4. View Attendance by Date
Show attendance for one specific date
Reads the attendance file and filters by date
5. View Attendance by Student
Show complete attendance of a student
Searches attendance.csv for that student
6. Exit
Close the program
Ends UI loop


Date Format
Dates must be entered in YYYY-MM-DD (Example: 2025-11-25).



Data Files Created
File Name
Purpose
students.csv
Stores all student details
attendance.csv
Stores all attendance records (date + present/absent)

Example CSV structure:
studentId,name,department
1,Rohit Sharma,CSE

date,studentId,status
2025-01-05,1,PRESENT


Code Highlight (Storage Snippet)
(This is an example of how attendance is stored in CSV files.)
public void saveAll(List<AttendanceRecord> records) {
    try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
        for (AttendanceRecord r : records) {
            out.println(r.getDate() + "," + r.getStudentId() + "," + r.getStatus());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


Author
This project was developed by:
Bhumika singh thakur 
24MIM10142
