package becode.challenge.commands;

import lombok.Getter;
import org.apache.commons.cli.Option;

public class HelpCommand implements Command {
    public final String commandName = "help <Command>";
    //    private final String commandCall;
    //    private final Map<String, String> commandDescriptions;
    @Getter
    private final String smallDescription = """
            returns a full explanation of what the "" does and what parameters it needs.""";
    @Getter
    private final Option option = Option.builder("hc")
            .longOpt("help_command")
            .hasArg()
            .desc(smallDescription)
            .build();


//    public HelpCommand(String commandCall, Map<String, String> commandDescriptions) {
//        this.commandCall = commandCall;
//        this.commandDescriptions = commandDescriptions;
//    }

    @Override
    public void execute() {
        // Vérifiez si la commande spécifiée existe dans la carte
        //        if (commandDescriptions.containsKey(commandCall)) {
        //            String description = commandDescriptions.get(commandName);
        //            System.out.println(description);
        //        } else {
        //            System.out.println("Command not found: " + commandCall);
        //        }
    }
}
