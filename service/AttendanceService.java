package service;

import dao.AttendanceDAO;
import model.AttendanceRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

    private AttendanceDAO attendanceDAO = new AttendanceDAO();

    public void markAttendance(String date, List<String> studentIds, List<String> statuses) throws IOException {
        for (int i = 0; i < studentIds.size(); i++) {
            AttendanceRecord record = new AttendanceRecord(date, studentIds.get(i), statuses.get(i));
            attendanceDAO.addRecord(record);
        }
    }

    public List<AttendanceRecord> getAll() throws IOException {
        return attendanceDAO.getAllRecords();
    }

    public List<AttendanceRecord> getByDate(String date) throws IOException {
        List<AttendanceRecord> all = attendanceDAO.getAllRecords();
        List<AttendanceRecord> result = new ArrayList<>();

        for (AttendanceRecord r : all) {
            if (r.getDate().equals(date)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<AttendanceRecord> getByStudent(String studentId) throws IOException {
        List<AttendanceRecord> all = attendanceDAO.getAllRecords();
        List<AttendanceRecord> result = new ArrayList<>();

        for (AttendanceRecord r : all) {
            if (r.getStudentId().equals(studentId)) {
                result.add(r);
            }
        }
        return result;
    }
}
