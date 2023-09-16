package becode.challenge.commands;

import lombok.Getter;
import org.apache.commons.cli.Option;

public class Quit implements Command {
    @Getter
    private final String commandName = "quit";
    @Getter
    private final String smallDescription = """
            quit program""";
    @Getter
    private final Option option = new Option("q", "quit", false, smallDescription);
    @Override
    public void execute() {}
}
