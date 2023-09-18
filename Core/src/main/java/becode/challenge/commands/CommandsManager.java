package becode.challenge.commands;

import lombok.Getter;
import org.apache.commons.cli.Options;

import java.util.ArrayList;
import java.util.List;

public class CommandsManager {
    static List<Command> commandList = new ArrayList<>();
    // Here instantiation of commands
    @Getter
    private final Help help = new Help();
    @Getter
    private final HelpCommand helpCommand = new HelpCommand();
    @Getter
    private final MonthlyTotal monthlyTotal = new MonthlyTotal();
    @Getter
    private final MonthlyAverage monthlyAverage = new MonthlyAverage();
    @Getter
    private final YearlyTotal yearlyTotal = new YearlyTotal();
    @Getter
    private final YearlyAverage yearlyAverage = new YearlyAverage();
    @Getter
    private final Overview overview = new Overview();

    private void registerCommand (Command command) {
        commandList.add(command);
    }
    public List<Command> getCommands() {
        // Adding Commands to the Map
        registerCommand(help);
        registerCommand(helpCommand);
        registerCommand(monthlyTotal);
        registerCommand(monthlyAverage);
        registerCommand(yearlyAverage);
        registerCommand(yearlyTotal);
        registerCommand(overview);
        return commandList;
    }

    public Options getOptions () {
        Options options = new Options();
        // Adding Options
        options.addOption(help.getOption());
        options.addOption(helpCommand.getOption());
        options.addOption(monthlyTotal.getOption());
        options.addOption(monthlyAverage.getOption());
        options.addOption(yearlyAverage.getOption());
        options.addOption(yearlyTotal.getOption());
        options.addOption(overview.getOption());
        return options;
    }
}
