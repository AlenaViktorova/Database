import java.util.Scanner;

public class TerminalReader {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Read integer from console.<p>
     * Check if inserted value is number, else print exception.
     * @param prompt text what will be printed at console
     * @return inserted integer in console
     */
    public static int readConsoleInt(String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return input;
    }

    /**
     * Read string from console.<p>
     * Check if inserted string is not empty, else print exception.
     * @param prompt text what will be printed at console
     * @return inserted text into console
     */
    public static String readConsole(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            }
            System.out.println("Input cannot be empty. Please enter a value.");
        }
        return input;
    }

    /**
     * Read social insurance number from console. <p>
     * Check if inserted value is in correct format xxxxxx/xxxx or xxxxxxxxxx. <p>
     * Check if month part is between 1-12 (man) or 51-62 (woman). <p>
     * Check if day part is smaller than 31. <p>
     * Else printing exceptions.
     * @param prompt text what will be printed at console
     * @return inserted text into console
     */
    public static String readConsolePersonalId(String prompt) {
        String personalId = "";
        boolean validFormat = false;
        while (!validFormat) {
            try {
                personalId = TerminalReader.readConsole(prompt).replaceAll("[^0-9]", "");
                if (personalId.matches("^\\d{6}/\\d{4}$") || personalId.matches("^\\d{10}$")) {
                    String datePart = personalId.replaceAll("[^0-9]", "");
                    String dayPart = datePart.substring(4, 6);
                    String monthPart = datePart.substring(2, 4);
                    int day = Integer.parseInt(dayPart);
                    int month = Integer.parseInt(monthPart);

                    if ((day > 0 && day < 32) && ((month > 0 && month < 13) || (month > 50 && month < 63))) {
                        validFormat = true;
                    } else {
                        throw new Exception("Probably wrong month or date.");
                    }
                } else {
                    throw new Exception("Probably more or less character than expected.");
                }
            } catch (Exception e) {
                System.out.println("Invalid format: " + e.getMessage());
            }
        }
        return personalId;
    }

    /**
     * Read selected choice from console. <p>
     * Check if inserted value is y or n.
     * @param prompt text what will be printed at console
     * @return inserted choice into console
     */
    public static String readConsoleChoice(String prompt){
        String choice = "";
        boolean validChoice = false;
        while (!validChoice) {
            try {
                System.out.println(prompt);
                choice = scanner.nextLine().toLowerCase();
                if (choice.equals("y") || choice.equals("n")) {
                    validChoice = true;
                } else {
                    throw new Exception("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter 'y' or 'n'.");
            }
        }
        return choice;
    }
}
