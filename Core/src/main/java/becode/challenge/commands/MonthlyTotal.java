package becode.challenge.commands;

import lombok.Getter;
import org.apache.commons.cli.Option;

public class MonthlyTotal implements Command {
    @Getter
    private final String name = "monthly_total";
    @Getter
    private final String smallDescription = """
            returns the sum of both the export and import for a specified month of a specified year.""";
    @Getter
    private final Option option = Option.builder("mt")
            .longOpt("monthly_total")
            .hasArg()
            .desc(smallDescription)
            .build();
    @Override
    public void execute() {

    }
}
