package model;

public class Attendancerecord {
    private String date; // YYYY-MM-DD
    private String studentId;
    private String status; // PRESENT or ABSENT

    public AttendanceRecord(String date, String studentId, String status) {
        this.date = date;
        this.studentId = studentId;
        this.status = status;
    }

    public String getDate() { return date; }
    public String getStudentId() { return studentId; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return date + "," + studentId + "," + status;
    }
}
