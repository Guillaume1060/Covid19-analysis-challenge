package becode.challenge.commands;

import lombok.Getter;
import org.apache.commons.cli.Option;

@Getter
public class Quit implements Command {
    private final String commandName = "quit";
    private final String smallDescription = """
            quit program""";
    private final Option option = new Option("q", "quit", false, smallDescription);
    @Override
    public void execute() {}
}
