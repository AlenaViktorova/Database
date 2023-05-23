class Actions {
    public void selectAction(Database users) {

        System.out.println("1. Add");
        System.out.println("2. Delete");
        System.out.println("3. Find");

        int choice = TerminalReader.readConsoleInt("Enter number of selected action: ");

        switch (choice) {
            case 1:
                System.out.println("Selected action: Add");
                addPerson(users);

                break;
            case 2:
                System.out.println("Selected action: Delete");
                delete(users);
                break;
            case 3:
                System.out.println("Selected action: Find");
                find(users);
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
        }
    }

    public void addPerson(Database users) {
        try {
            String firstName = TerminalReader.readConsole("Enter first name: ");
            String lastName = TerminalReader.readConsole("Enter last name: ");
            String personalId = TerminalReader.readConsolePersonalId("Enter social insurance number (in format xxxxxx/xxxx or xxxxxxxxxx): ").replaceAll("[^0-9]", "");

            // Check if a person with the same personal ID already exists
            Person existingPerson = users.findByIdNumber(personalId);
            if (existingPerson != null) {
                throw new IllegalArgumentException("A person with the same personal ID already exists in the database.");
            }

            users.addPerson(new Person(firstName, lastName, personalId));
            System.out.println("Person added to database.");

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage()+ ". Press y to continue or n to finish the program.");
            // Handle the exception gracefully, e.g., display an error message or perform alternative actions
        }
    }


    private void delete(Database users) {
        try {
            String personalId = TerminalReader.readConsolePersonalId("Enter social insurance number (in format xxxxxx/xxxx or xxxxxxxxxx): ");

            // Check if a person with the specified ID exists in the database
            Person existingPerson = users.findByIdNumber(personalId);
            if (existingPerson == null) {
                throw new IllegalArgumentException("A person with the specified ID does not exist in the database.");
            }

            users.deletePerson(personalId);
            System.out.println("Person deleted from database.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage() + ". Press y to continue or n to finish the program.");
            // Handle the exception gracefully, e.g., display an error message or perform alternative actions
        }
    }

    private void find(Database users) {
        try {
            String personalId = TerminalReader.readConsolePersonalId("Enter social insurance number (in format xxxxxx/xxxx or xxxxxxxxxx): ");
            Person foundPerson = users.findByIdNumber(personalId);
            if (foundPerson == null) {
                throw new IllegalArgumentException("A person with the specified ID does not exist in the database.");
            }

            long age = PersonalIdCalculator.calculateAge(personalId);
            System.out.println("Found person: " + foundPerson.getFirstName() + " " + foundPerson.getLastName() +
                    ", age: " + age);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage() + ". Press y to continue or n to finish the program.");
            // Handle the exception gracefully, e.g., display an error message or perform alternative actions
        }
    }


    public boolean wantContinue() {

        String choice = TerminalReader.readConsoleChoice("Do you want to continue? (y/n): ");

        switch (choice) {
            case "y":
                System.out.println("Ok, program continuing.");
                return true;
            case "n":
                System.out.println("Ok, finishing program.");
                return false;
            default:
                System.out.println("Invalid choice. Exiting program.");
                return false;
        }
    }
}
