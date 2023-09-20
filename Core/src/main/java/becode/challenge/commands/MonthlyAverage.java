package becode.challenge.commands;

import becode.challenge.CSVReader;
import becode.challenge.DataModel;
import lombok.Getter;
import org.apache.commons.cli.Option;

import java.text.DecimalFormat;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class MonthlyAverage implements Command {
    private final String name = "monthly_average";
    private final String smallDescription = """
            returns the average of both the export and the import of a specified month of a specified year.""";
    private final Option option = Option.builder("ma")
            .longOpt("monthly_average")
            .hasArg()
            .desc(smallDescription)
            .build();

    @Override
    public void execute() {
        execute("July", "2021");
    }

    public void execute(String year, String month) {
        execute(year,month,"all","all","all","$");
    }

    public void execute(String year, String month, String country,String commodity,String transport_mode, String measure) {
        int dayPerMonth = Command.getDaysPerMonth(Month.valueOf(month.toUpperCase()).getValue(),Integer.parseInt(year));
        List<DataModel> dataModels = CSVReader.getDataModelSet();
        DecimalFormat decimalFormat = new DecimalFormat();

        Map<Month, Long> values = dataModels
                .stream().filter(data -> data.getYear().getValue() == Integer.parseInt(year)
                        && Objects.equals(data.getCountry(), country)
                        && Objects.equals(data.getCommodity(), commodity)
                        && Objects.equals(data.getTransportMode(), transport_mode)
                        && Objects.equals(data.getMeasure(), measure)
                        && data.getDate().getMonth() == Month.valueOf(month.toUpperCase())).collect(Collectors.groupingBy(
                        data -> data.getDate().getMonth(),
                        Collectors.summingLong(DataModel::getValue)));

        System.out.println("--->> AVERAGE " + month + ", YEAR " + year + " <<---");
        System.out.println("->> Country: " + country + ", Commodity: " + commodity+" ("+transport_mode+")"+ " <<-");
        if (values.isEmpty()) System.out.println("NO VALUES");
        values.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " -> "+measure +" "+ decimalFormat.format(entry.getValue() / dayPerMonth)));
    }
}
