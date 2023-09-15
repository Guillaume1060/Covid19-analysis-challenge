package becode.challenge;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\guitc\\OneDrive\\Bureau\\Code\\Java\\covid19-analysis-challenge\\Core\\src\\main\\resources\\covid_and_trace.csv");
//        try {
//            System.out.println(new String(Files.readAllLines(path).toString()));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        CSVReader csvReader = new CSVReader("Core/src/main/resources/covid_and_trade.csv");


//        csvReader.getYearList().forEach(System.out::println);
//        System.out.println("-------------------------------------");
//        csvReader.getMonthList().forEach(System.out::println);
//        System.out.println("-------------------------------------");
//        csvReader.getCountryList().forEach(System.out::println);
//        System.out.println("-------------------------------------");
//        csvReader.getCommodityList().forEach(System.out::println);
//        System.out.println("-------------------------------------");
//        csvReader.getTransportModeList().forEach(System.out::println);
//        System.out.println("-------------------------------------");
//        csvReader.getMeasureList().forEach(System.out::println);

    }
}
