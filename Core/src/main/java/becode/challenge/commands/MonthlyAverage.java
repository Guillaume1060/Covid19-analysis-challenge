package becode.challenge.commands;

import becode.challenge.CSVReader;
import becode.challenge.DataModel;
import lombok.Getter;
import org.apache.commons.cli.Option;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MonthlyAverage implements Command {
    @Getter
    private final String name = "monthly_average";
    @Getter
    private final String smallDescription = """
            returns the average of both the export and the import of a specified month of a specified year.""";
    @Getter
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
        List<DataModel> dataModels = CSVReader.getDataModelSet();

        Map<Month, Long> values = dataModels
                .stream().filter(data -> data.getYear().getValue() == Integer.parseInt(year)
                        && data.getDate().getMonth() == Month.valueOf(month.toUpperCase())).collect(Collectors.groupingBy(
                        data -> data.getDate().getMonth(),
                        Collectors.summingLong(DataModel::getValue)));

        System.out.println("--->> AVERAGE " + month + ", YEAR " + year + " <<---");
        values.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + "-> " + entry.getValue() / 31));
    }
}
