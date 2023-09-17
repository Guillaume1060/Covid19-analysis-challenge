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

public class YearlyAverage implements Command {
    @Getter
    private final String name = "yearly_average";
    @Getter
    private final String smallDescription = """
            returns an overview of all the monthly averages for a particular year, for both import and export. Then it gives the yearly average for both import and export.""";
    @Getter
    private final Option option = Option.builder("ya")
            .longOpt("yearly_average")
            .hasArg()
            .desc(smallDescription)
            .build();

    @Override
    public void execute() {
        execute("2021");
    }

    public void execute(String year) {
        execute(year, "All", "All", "All", "All", "$");
    }

    public void execute(String year, String month, String country, String commodity, String transport_mode, String measure) {

        List<DataModel> dataModels = CSVReader.getDataModelSet();
        DecimalFormat decimalFormat = new DecimalFormat();

        Map<Month, Long> valuesPerMonth = dataModels.stream()
                .filter(data -> data.getYear().getValue() == Integer.parseInt(year)
                        && Objects.equals(data.getCountry(), country)
                        && Objects.equals(data.getCommodity(), commodity)
                        && Objects.equals(data.getTransportMode(), transport_mode)
                        && Objects.equals(data.getMeasure(), measure))
                .collect(Collectors.groupingBy(
                        data -> data.getDate().getMonth(),
                        Collectors.summingLong(DataModel::getValue)
                ));

        System.out.println("--->> Average per month, YEAR " + year + " <<---");
        System.out.println("->> Country: " + country + ", Commodity: " + commodity+" ("+transport_mode+")"+ " <<-");
        if (valuesPerMonth.isEmpty()) System.out.println("NO VALUES");
        valuesPerMonth.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + "-> " +measure +" "+ decimalFormat.format(entry.getValue() / Command.getDaysPerMonth(entry.getKey().getValue(), Integer.parseInt(year)))));

    }
}
