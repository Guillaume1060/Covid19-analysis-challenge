package becode.challenge.commands;

import lombok.Getter;
import org.apache.commons.cli.Option;

public class Help implements Command {
    @Getter
    private final String commandName = "help";
    @Getter
    private final String smallDescription = """
            returns a list of available commands with a small description.""";
    @Getter
    private final Option option = new Option("h", "help", false, smallDescription);

    @Override
    public void execute() {
        CommandsManager commandsManager= new CommandsManager();
        for (Option opt : commandsManager.getOptions().getOptions()) {
            System.out.println(opt.getLongOpt() + ": " + opt.getDescription());
        }
    }

}



