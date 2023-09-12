package becode.challenge;

import java.nio.file.Path;

public class App
{
    public static void main( String[] args )
    {
        Path path = Path.of("C:\\Users\\guitc\\OneDrive\\Bureau\\Code\\Java\\covid19-analysis-challenge\\Core\\src\\main\\resources\\covid_and_trace.csv");
//        try {
//            System.out.println(new String(Files.readAllLines(path).toString()));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        CSVReader csvReader = new CSVReader("Core/src/main/resources/covid_and_trade.csv");
        for (DataModel model : csvReader.dataModelSet) {
           System.out.println(model.toString());
        }


    }
}
