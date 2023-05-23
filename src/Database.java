import java.util.ArrayList;

class Database {
    private String name;
    private ArrayList<Person> persons = new ArrayList<>();

    /**
     * Creating database.
     * @param  name name of database
     */
    public Database(String name) {
        this.name = name;
    }

    /**
     * Adding person to database by entering firstName, lastName and social insurance number.<p>
     * If person is already in database, exception will be printed.
     */
    public void addPerson() {
        String firstName = TerminalReader.readConsole("Enter first name: ");
        String lastName = TerminalReader.readConsole("Enter last name: ");
        String personalId = TerminalReader.readConsolePersonalId("Enter social insurance number (in format xxxxxx/xxxx or xxxxxxxxxx): ").replaceAll("[^0-9]", "");

        // Check if a person with the same personal ID already exists
        Person existingPerson = this.findByIdNumber(personalId);
    	

        if (existingPerson != null) {
            System.err.println("Error: A person with the same personal ID already exists in the database. Press y to continue or n to finish the program.");
        }
        else{
            persons.add(new Person(firstName, lastName, personalId));
            System.out.println("Person added to database.");
        }
    }

    /**
     * Deleting person from database found by social insurance number.<p>
     * If person isn't in database, exception will be printed.
     */
    public void deletePerson() {
        String personalId = TerminalReader.readConsolePersonalId("Enter social insurance number (in format xxxxxx/xxxx or xxxxxxxxxx): ");

        // Check if a person with the specified ID exists in the database
        Person existingPerson = this.findByIdNumber(personalId);
        if (existingPerson == null) {
            System.err.println("Error: A person with the specified ID does not exist in the database. Press y to continue or n to finish the program.");
        }
        else{
            persons.remove(existingPerson);

            System.out.println("Person deleted from database.");
        }
    }

    /**
     * Finding person in database. If person isn't in database, exception will be printed.<p>
     * If person is in database firstName, lastName and calculated age of person will be printed.
     */
    public void findInDatabase() {
        String personalId = TerminalReader.readConsolePersonalId("Enter social insurance number (in format xxxxxx/xxxx or xxxxxxxxxx): ");

        Person foundPerson = this.findByIdNumber(personalId);

        // Check if a person with the specified ID exists in the database
        if (foundPerson == null) {
            System.err.println("Error: A person with the specified ID does not exist in the database. Press y to continue or n to finish the program.");
        }
        else{
            long age = PersonalIdCalculator.calculateAge(personalId);
            System.out.println("Found person: " + foundPerson.getFirstName() + " " + foundPerson.getLastName() +
                    ", age: " + age);
        }
    }

    /**
     * Finding person from database by firstName. <p>
     * Never use - just for case<p>
     * Returning null if the person is not in database.
     * @param  firstName firstName of wanted person
     * @return	object Person from database, where Person.firstName is same as wanted firstName or null
     */
    private Person findByFirstName(String firstName) {
        for (Person person : persons) {
            if (person.getFirstName().equals(firstName)) {
                return person;
            }
        }
        return null;
    }

    /**
     * Finding person from database by lastName. <p>
     * Never use - just for case<p>
     * Returning null if the person is not in database.
     * @param  lastName firstName of wanted person
     * @return	object Person from database, where Person.lastName is same as wanted lastName or null
     */
    private Person findByLastName(String lastName) {
        for (Person person : persons) {
            if (person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    /**
     * Finding person from database by social insurance number. <p>
     * Returning null if the person is not in database.
     * @param  number social insurance number of wanted person
     * @return	Person from database, where Person.idNumber is same as wanted number or null
     */
    private Person findByIdNumber(String number) {

        for (Person person : persons) {
            if (person.getIdNumber().equals(number)) {
                return person;
            }
        }
        return null;
    }


    /**
     * Return formated database <p>
     * @return	formated database
     *
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        for (Person person : persons) {
            sb.append("\n  ").append(person);
        }
        return sb.toString();
    }
}


