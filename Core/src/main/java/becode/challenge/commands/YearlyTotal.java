package becode.challenge.commands;

import lombok.Getter;
import org.apache.commons.cli.Option;

public class YearlyTotal implements Command {
    @Getter
    private final String name = "yearly_total";
    @Getter
    private final String smallDescription = """
            returns an overview of all the monthly totals for a particular year. This command returns the total of each month for both import and export. Then it gives the yearly total for both import and export.""";
    @Getter
    private final Option option = Option.builder("yt")
            .longOpt("yearly_total")
            .hasArg()
            .desc(smallDescription)
            .build();
    @Override
    public void execute() {

    }
}
