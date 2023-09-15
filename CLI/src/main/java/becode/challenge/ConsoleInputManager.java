package becode.challenge;

import becode.challenge.commands.Command;
import becode.challenge.commands.CommandsManager;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.nio.file.Path;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static void startProgram() {
        Path path = Path.of("C:\\Users\\guitc\\OneDrive\\Bureau\\Code\\Java\\covid19-analysis-challenge\\Core\\src\\main\\resources\\covid_and_trace.csv");
        CSVReader csvReader = new CSVReader("Core/src/main/resources/covid_and_trade.csv");

        boolean endProgram = false;
        CommandsManager commandsManager = new CommandsManager();
        List<Command> commandList = commandsManager.getCommands();
        Options options = commandsManager.getOptions();

        while (!endProgram) {

            String optionsMessage = "Options available:\n";
            for (Option opt : options.getOptions()) {
                optionsMessage += "-" + opt.getOpt() + " (" + opt.getLongOpt() + "): " + opt.getDescription() + "\n";
            }
            System.out.println(optionsMessage);

            System.out.println("Please select an option:");
            String answer = scanner.nextLine().trim().toLowerCase();

            switch (answer) {
                case "h" -> commandsManager.getHelp().execute();
                case "hc" -> commandsManager.getHelpCommand().execute();
//            case "o" -> commandsManager.getOverview().execute();
//            case "q" -> commandsManager.getQuit().execute();
                case "ma" -> {
                    String[] yearAndMonthSelection = yearAndMonthSelection();
                    commandsManager.getMonthlyAverage().execute(yearAndMonthSelection[0], yearAndMonthSelection[1]);
                }
//                case "mt" -> {
//                    String[] yearAndMonthSelection = yearAndMonthSelection();
//                    commandsManager.getMonthlyTotal().execute(yearAndMonthSelection[0], yearAndMonthSelection[1]);
//                }
//                case "ya" -> {
//                    String[] yearAndMonthSelection = yearAndMonthSelection();
//                    commandsManager.getYearlyAverage().execute(yearAndMonthSelection[0], yearAndMonthSelection[1]);
//                }
//                case "yt" -> {
//                    String[] yearAndMonthSelection = yearAndMonthSelection();
//                    commandsManager.getYearlyTotal().execute(yearAndMonthSelection[0], yearAndMonthSelection[1]);
//                }
                default -> {
                }
//                System.out.println("Do you like to add parameters ?  Y/N");
            }
        }
    }

    private static String[] yearAndMonthSelection() {
        String[] yearAndMonth = new String[6];
        System.out.println("Please select year :");
        for (Year year : CSVReader.getYearList()) {
            System.out.print(year + " ");
        }
        String year = scanner.nextLine().trim();
        yearAndMonth[0] = year;
        System.out.println("Please select month :");
        for (Month month : CSVReader.getMonthList()) {
            System.out.print(month + " ");
        }
        String month = scanner.nextLine().trim().toUpperCase();
        yearAndMonth[1] = month;

//        System.out.println("Do you want more arguments ? Y/N");
//        String moreArgs = scanner.nextLine().trim().toUpperCase();
//        if (moreArgs.equals("Y")) {
//            System.out.println("Please select country :");
//            for (String country : CSVReader.getCountryList()) {
//                System.out.println(country);
//            }
//            String country = scanner.nextLine().trim().toUpperCase();
//            yearAndMonth[3] = country;
//        }
        return yearAndMonth;
    }
}
