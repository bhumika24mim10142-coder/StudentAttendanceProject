package dao;

import model.AttendanceRecord;
import util.CSVUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    private static final String ATTENDANCE_FILE = "attendance.csv";

    public void addRecord(AttendanceRecord record) throws IOException {
        CSVUtil.appendLine(ATTENDANCE_FILE, record.toString());
    }

    public List<AttendanceRecord> getAllRecords() throws IOException {
        List<String> lines = CSVUtil.readAllLines(ATTENDANCE_FILE);
        List<AttendanceRecord> records = new ArrayList<>();

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts.length == 3) {
                records.add(new AttendanceRecord(parts[0], parts[1], parts[2]));
            }
        }
        return records;
    }
}
