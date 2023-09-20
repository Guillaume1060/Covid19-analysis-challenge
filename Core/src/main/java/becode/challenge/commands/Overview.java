package becode.challenge.commands;

import becode.challenge.CSVReader;
import lombok.Getter;
import org.apache.commons.cli.Option;

@Getter
public class Overview implements Command {
    private final String name = "overview";
    private final String smallDescription = """
            returns all the unique values that span the data set: years, countries, commodities, transportation modes and measures.""";
    private final Option option = Option.builder("o")
            .longOpt("overview")
            .hasArg()
            .desc(smallDescription)
            .build();

    @Override
    public void execute() {
        CSVReader.printOverview();
    }
}


