package becode.challenge;

public class App {
    public static void main(String[] args)  {
//        String csvFilePath = "Core/src/main/resources/covid_and_trade.csv"
//        CSVReader csvReader = new CSVReader(csvFilePath);
//        CommandsManager commandsManager = new CommandsManager();
//        UserInterfaceManager.startProgram(csvFilePath, commandsManager);
        ConsoleInputManager.startProgram("Core/src/main/resources/covid_and_trade.csv");
    }
}
