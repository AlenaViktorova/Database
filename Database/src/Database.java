import java.util.ArrayList;

class Database {
    private String name;
    private ArrayList<Person> persons = new ArrayList<>();

    public Database(String name) {
        this.name = name;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void deletePerson(String id) {
        Person person = findByIdNumber(id);
        persons.remove(person);
    }

    public Person findByName(String name) {
        for (Person person : persons) {
            if (person.getFirstName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person findByEmail(String email) {
        for (Person person : persons) {
            if (person.getLastName().equals(email)) {
                return person;
            }
        }
        return null;
    }

    public Person findByIdNumber(String number) {
        for (Person person : persons) {
            if (person.getIdNumber().equals(number)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        for (Person person : persons) {
            sb.append("\n  ").append(person);
        }
        return sb.toString();
    }
}

class Person {
    private String firstName;
    private String lastName;
    private String idNumber;

    public Person(String firstName, String lastName, String idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", personal ID is: " + idNumber;
    }
}
