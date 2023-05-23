class Actions {

    /**
     * Selecting wanted action and execution selected action.<p>
     * Select from Add, Delete, Find.
     * @param  users database of Persons
     */
    public void selectAction(Database users) {

        System.out.println("1. Add");
        System.out.println("2. Delete");
        System.out.println("3. Find");

        int choice = TerminalReader.readConsoleInt("Enter number of selected action: ");

        switch (choice) {
            case 1:
                System.out.println("Selected action: Add");
                users.addPerson();
                break;
            case 2:
                System.out.println("Selected action: Delete");
                users.deletePerson();
                break;
            case 3:
                System.out.println("Selected action: Find");
                users.findInDatabase();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    /**
     * Selecting if you want to continue in program.<p>
     * Select from y/n. Other options print exception.
     * @return true when want continuing, false when want finish program
     */
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

