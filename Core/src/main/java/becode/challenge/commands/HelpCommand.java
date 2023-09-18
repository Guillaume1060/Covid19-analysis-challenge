package becode.challenge.commands;

import lombok.Getter;
import org.apache.commons.cli.Option;

import java.util.Objects;

public class HelpCommand implements Command {
    public final String commandName = "help <Command>";
    @Getter
    private final String smallDescription = """
            returns a full explanation of what the command does and what parameters it needs.Please call it like 'hc commandName'""";
    @Getter
    private final Option option = Option.builder("hc")
            .longOpt("help_command")
            .hasArg()
            .desc(smallDescription)
            .build();

    @Override
    public void execute() {

    }

    public void execute(String option) {
        CommandsManager commandsManager = new CommandsManager();
        for (Option opt : commandsManager.getOptions().getOptions()) {
            if (Objects.equals(option, opt.getLongOpt())) {
                System.out.println(opt.getLongOpt() + ": " + opt.getDescription());
            }
        }
    }
}
