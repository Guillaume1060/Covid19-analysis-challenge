package becode.challenge;

//public class UserInterfaceManager {
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void startProgram(String csvFilePath, CommandsManager commandsManager) {
//        while (true) {
//            displayOptions(commandsManager.getOptions());
//            System.out.println("Please select an option:");
//            String answer = scanner.nextLine().trim().toLowerCase();
//            if (answer.equals("q")) {
//                System.out.println("Exiting the program.");
//                break;
//            }
//            try {
//                commandsManager.handleUserSelection(answer);
//            } catch (InvalidOptionException e) {
//                System.out.println("Invalid option: " + e.getMessage());
//            }
//        }
//    }
//
//    private static void displayOptions(Options options) {
//        System.out.println("Options available:");
//        for (Option opt : options.getOptions()) {
//            System.out.println(opt.getOpt() + " (" + opt.getLongOpt() + "): ");
//        }
//    }
//}
