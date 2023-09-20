package becode.challenge;

import becode.challenge.commands.CommandsManager;
import becode.challenge.commands.OtherOptions;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.time.Month;
import java.time.Year;
import java.util.Scanner;
import java.util.Set;

public class ConsoleInputManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Set<Year> yearList = CSVReader.getYearList();
    private static final Set<Month> monthList = CSVReader.getMonthList();

    public static void startProgram(String csvFilePath) {
        CSVReader csvReader = new CSVReader(csvFilePath);
        CommandsManager commandsManager = new CommandsManager();
        while (true) {
            displayOptions(commandsManager.getOptions(),false);
            System.out.println("Please select an option:");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("q")) {
                System.out.println("Exiting the program.");
                break;
            }
            handleUserSelection(answer, commandsManager);
        }
    }

    private static void handleUserSelection(String selection, CommandsManager commandsManager) {
        String option = "";
        if (selection.startsWith("hc")) {
            String[] splitResult = selection.split(" ");
            if (splitResult.length >= 2) {
                option = splitResult[1];
                selection = splitResult[0];
            } else {
                System.out.println("Add the command after hc (ex: hc monthly_average)");
                selection = "badCommand";
            }
        }
        switch (selection) {
            case "h" -> commandsManager.getHelp().execute();
            case "hc" -> commandsManager.getHelpCommand().execute(option);
            case "o" -> commandsManager.getOverview().execute();
            case "ma" -> {
                String[] paramsArr = paramsSelection(true);
                commandsManager.getMonthlyAverage().execute(paramsArr[0], paramsArr[1], paramsArr[2], paramsArr[3], paramsArr[4], paramsArr[5]);
            }
            case "mt" -> {
                String[] paramsArr = paramsSelection(true);
                commandsManager.getMonthlyTotal().execute(paramsArr[0], paramsArr[1], paramsArr[2], paramsArr[3], paramsArr[4], paramsArr[5]);
            }
            case "ya" -> {
                String[] paramsArr = paramsSelection(false);
                commandsManager.getYearlyAverage().execute(paramsArr[0], paramsArr[1], paramsArr[2], paramsArr[3], paramsArr[4], paramsArr[5]);
            }
            case "yt" -> {
                String[] paramsArr = paramsSelection(false);
                commandsManager.getYearlyTotal().execute(paramsArr[0], paramsArr[1], paramsArr[2], paramsArr[3], paramsArr[4], paramsArr[5]);
            }
            default -> {
                System.out.println("Please select an available command (ex: mt)");
            }
        }
    }

    private static void displayOptions(Options options, boolean withDescription) {
        System.out.println("Options available:");
        for (Option opt : options.getOptions()) {
            System.out.println(opt.getOpt() + " (" + opt.getLongOpt() + "): "+ (withDescription ? opt.getDescription():""));
        }
    }

    private static String[] paramsSelection(Boolean includeMonth) {
        String yearChoice = selectYear();
        String monthChoice = includeMonth ? selectMonth() : "All";

        System.out.println("Do you want to add parameters ? Y/N");
        String moreParamsAnswer = scanner.nextLine().trim().toUpperCase();

        if (moreParamsAnswer.equals("Y")) {
            String[] otherOpts = otherOptionsSelection();
            return new String[]{yearChoice, monthChoice, otherOpts[0], otherOpts[1], otherOpts[2], otherOpts[3]};
        }

        return new String[]{yearChoice, monthChoice, "All", "All", "All", "$"};
    }

    private static String selectYear() {
        while (true) {
            System.out.println("Please select a year :");
            for (Year year : yearList) {
                System.out.print(year + " ");
            }
            String yearChoice = scanner.nextLine().trim();

            try {
                int yearValue = Integer.parseInt(yearChoice);

                if (yearList.contains(Year.of(yearValue))) {
                    return yearChoice;
                } else {
                    System.out.print("Please write a correct year. ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid value, try again. ");
            }
        }
    }

    private static String selectMonth() {
        while (true) {
            System.out.println("Please select a month :");
            for (Month month : monthList) {
                System.out.print(month + " ");
            }
            String monthChoice = scanner.nextLine().trim().toUpperCase();

            try {
                Month selectedMonth = Month.valueOf(monthChoice);

                if (monthList.contains(selectedMonth)) {
                    return monthChoice;
                } else {
                    System.out.print("Please write a correct month. ");
                }
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid value, try again. ");
            }
        }
    }

    private static String[] otherOptionsSelection() {
        String[] otherOptions = new String[4];
        otherOptions[0] = otherOptionSelection(CSVReader.getCountryList());
        otherOptions[1] = otherOptionSelection(CSVReader.getCommodityList());
        otherOptions[2] = otherOptionSelection(CSVReader.getTransportModeList());
        otherOptions[3] = otherOptionSelection(CSVReader.getMeasureList());
        return otherOptions;
    }

    private static String otherOptionSelection(Set<String> list) {
        Options options = OtherOptions.getOpt(list);
        String selectedOption;
        while (true) {
            displayOptions(options, true);
            String userInput = scanner.nextLine().trim();

            if (options.hasOption(userInput)) {
                selectedOption = options.getOption(userInput).getDescription();
                break;
            } else {
                System.out.println("Please select a valid number.");
            }
        }
        return selectedOption;
    }
}
