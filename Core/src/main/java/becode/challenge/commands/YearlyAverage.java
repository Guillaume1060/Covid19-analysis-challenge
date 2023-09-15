package becode.challenge.commands;

import lombok.Getter;
import org.apache.commons.cli.Option;

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

    }
}
