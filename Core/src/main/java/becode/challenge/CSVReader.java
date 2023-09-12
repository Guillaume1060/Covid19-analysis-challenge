package becode.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;



public class CSVReader {
    public List<DataModel> dataModelSet = new LinkedList<>();

    public CSVReader(String filePath) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Line below to skip first line
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                // CreatingData
                String[] words = line.split("\\n");
                for (String word : words) {
                    dataModelSet.add(createData(word));
                }
            }
        } catch (
                IOException e) {
            System.err.println("Impossible to read : " + e.getMessage());
        }
    }

    private DataModel createData(String data) {
        String[] arr = data.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)");
        return new DataModel(arr[0], Year.of(Integer.parseInt(arr[1])), LocalDate.parse(arr[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")), DayOfWeek.valueOf(arr[3].toUpperCase()), arr[4], arr[5], arr[6], arr[7], Long.parseLong(arr[8]), Long.parseLong(arr[9]));
    }


}
