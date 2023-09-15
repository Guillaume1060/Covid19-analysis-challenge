package becode.challenge;

import java.text.ParseException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws ParseException, org.apache.commons.cli.ParseException {
        ConsoleInputManager.startProgram();
//        CommandsManager commandsManager = new CommandsManager();
//        Options options = commandsManager.getOptions();

//        Options options = new Options();
//        Option test = new Option("h", "help", false, "returns a list of available commands with a small description.");
//        Option config = Option.builder("c")
//                .longOpt("config")
//                .argName("configName")
//                .hasArg()
//                .required(false) // Mark it as non-required
//                .desc("set config file")
//                .build();
//        options.addOption(test);
//        options.addOption(config);

        // Define parser
//        CommandLine cmd;
//        CommandLineParser parser = new DefaultParser(); // Use DefaultParser instead of BasicParser
//        HelpFormatter helper = new HelpFormatter();
//
//        String optionsMessage = "Options available:\n";
//        for (Option opt : options.getOptions()) {
//            optionsMessage += "-" + opt.getOpt() + " (" + opt.getLongOpt() + "): " + opt.getDescription() + "\n";
//        }
//        System.out.println(optionsMessage);
//
//        System.out.println("Please select an option:");
//        String answer = scanner.nextLine().trim().toLowerCase();
//
//        // SwitchCase ?
//        if (answer.equals("h")) {
//            commandsManager.executeCommand(new Help());
////            cmd = parser.parse(options, new String[]{"-a"});
////            System.out.println("Alpha activated");
//        } else if (answer.equals("c")) {
//            System.out.println("Enter the config name:");
//            String configName = scanner.nextLine();
//            cmd = parser.parse(options, new String[]{"-c", configName});
//            if (cmd.hasOption("config")) {
//                String opt_config = cmd.getOptionValue("config");
//                System.out.println("Config set to " + opt_config);
//            } else {
//                System.out.println("Config option was not specified.");
//            }
//        } else {
//            System.out.println("Invalid choice. Please choose 'a' or 'c'.");
//            System.exit(1);
//        }
    }
}
