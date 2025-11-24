package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public static void appendLine(String fileName, String line) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(line);
        bw.newLine();
        bw.close();
    }

    public static List<String> readAllLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();

        File file = new File(fileName);
        if (!file.exists()) {
            return lines; // return empty list if file doesn't exist
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        br.close();
        return lines;
    }
}
