package register;

import java.util.Arrays;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
    /**
     * register.Person array.
     */
    private Person[] persons;

    /**
     * Number of persons in this register.
     */
    private int count;

    /**
     * Constructor creates an empty register with maximum size specified.
     *
     * @param size maximum size of the register
     */
    public ArrayRegister(int size) {
        persons = new Person[size];
        count = 0;
    }

    /**
     * Returns the number of persons in this register.
     *
     * @return the number of persons in this register
     */
    @Override
    public int getCount() {
        return count;
    }

    /**
     * Returns the maximum number of persons in this register.
     *
     * @return the maximum number of persons in this register.
     */
    @Override
    public int getSize() {
        return persons.length;
    }

    /**
     * Returns the person at the specified position in this register.
     *
     * @param index index of the person to return
     * @return person the person at the specified position in this register
     */
    @Override
    public Person getPerson(int index) {
        return persons[index];
    }

    /**
     * Appends the specified person to the end of this register.
     *
     * @param person person to append to this register
     */
    @Override
    public void addPerson(Person person) {
        persons[count] = person;
        count++;
    }

    /**
     * Returns the person with specified name in this register or <code>null</code>,
     * if match can not be found.
     *
     * @param name name of a person to search for
     * @return person with specified phone number
     */
    @Override
    public Person findPersonByName(String name) {
        Person person = null;
        for (int i = 0; i < persons.length; i++) {
            if (getPerson(i).getName().equals(name)) {
                person = getPerson(i);
            }
        }
        if (person == null) {
            throw new RuntimeException("This name is not in register");
        }
        System.out.println("Person with provided name is: " + person);
        return person;

//        throw new UnsupportedOperationException("Method findPersonByName not yet implemented");
    }

    /**
     * Returns the person with specified phone number in this register or <code>null</code>,
     * if match can not be found.
     *
     * @param phoneNumber phone number of a person to search for
     * @return person with specified phone number
     */
    @Override
    public Person findPersonByPhoneNumber(String phoneNumber) {

        Person person = null;

        for (int i = 0; i < persons.length; i++) {
            if (getPerson(i).getPhoneNumber().equals(phoneNumber)) {
                person = getPerson(i);
            }
        }
        if (person == null) {
            throw new RuntimeException("This phone number is not in register");
        }
        System.out.println("Person with provided phone number is: " + person);
        return person;

//        throw new UnsupportedOperationException("Method findPersonByPhoneNumber not yet implemented");
    }

    /**
     * Removes the specified person from the register.
     *
     * @param person person to remove
     */
    @Override
    public void removePerson(Person person) {
        person = null;
        count--;
        Arrays.sort(persons);
    }
}
