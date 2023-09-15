package becode.challenge;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;


public class CSVReader {
    @Getter private static final List<DataModel> dataModelSet = new LinkedList<>();
    @Getter private static Stream<DataModel> dataModelStream;
    @Getter private static final Set<Year> yearList = new TreeSet<>();
    @Getter private static final Set<Month> monthList = new TreeSet<>();
    @Getter private static final Set<String> countryList = new TreeSet<>();
    @Getter private static final Set<String> commodityList = new TreeSet<>();
    @Getter private static final Set<String> transportModeList = new TreeSet<>();
    @Getter private static final Set<String> measureList = new TreeSet<>();

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
            dataModelStream = dataModelSet.stream()
                    .filter(data -> !Objects.equals(data.getDirection(), "Reimports"));
        } catch (
                IOException e) {
            System.err.println("Impossible to read : " + e.getMessage());
        }
    }

    private DataModel createData(String data) {
        String[] arr = data.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)");

        // list creation
        yearList.add(Year.of(Integer.parseInt(arr[1])));
        monthList.add(LocalDate.parse(arr[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")).getMonth());
        countryList.add(arr[4]);
        commodityList.add(arr[5]);
        transportModeList.add(arr[6]);
        measureList.add(arr[7]);

        return new DataModel(arr[0], Year.of(Integer.parseInt(arr[1])), LocalDate.parse(arr[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")), DayOfWeek.valueOf(arr[3].toUpperCase()), arr[4], arr[5], arr[6], arr[7], Long.parseLong(arr[8]), Long.parseLong(arr[9]));
    }


}
