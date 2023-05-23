class Person {
    private String firstName;
    private String lastName;
    private String idNumber;

    /**
     * Creating Person object contains firstName, lastName and social insurance number.<p>
     * IdNumber is social insurance number in string form xxxxxx/xxxx or xxxxxxxxxx.
     * @param  firstName
     * @param  lastName
     * @param  idNumber social insurance number
     */
    public Person(String firstName, String lastName, String idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    /**
     * Returning firstName of object Person.
     * @return  firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returning lastName of object Person.
     * @return  lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returning social insurance number of object Person.
     * @return  social insurance number
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Returning formatted string containing firstName, lastName and social insurance number.
     * @return  formatted string
     */
    public String toString() {
        return firstName + " " + lastName + ", personal ID is: " + idNumber;
    }
}