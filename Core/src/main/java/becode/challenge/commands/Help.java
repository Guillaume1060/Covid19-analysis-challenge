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
        // @TODO
        System.out.println("Help!");
//        CommandManager commandManager = new CommandManager();
//        Map<String, Command> commands = commandManager.getCommands();
//        for (var command : commands.entrySet()) {
//            System.out.println(command.getKey()+" : "+command.getValue().getSmallDescription());
    }

}



