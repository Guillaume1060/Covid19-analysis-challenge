package becode.challenge.commands;

import lombok.Getter;
import org.apache.commons.cli.Option;

@Getter
public class Help implements Command {
    private final String commandName = "help";
    private final String smallDescription = """
            returns a list of available commands with a small description.""";
    private final Option option = new Option("h", "help", false, smallDescription);

    @Override
    public void execute() {
        CommandsManager commandsManager= new CommandsManager();
        for (Option opt : commandsManager.getOptions().getOptions()) {
            System.out.println(opt.getLongOpt() + ": " + opt.getDescription());
        }
    }

}



