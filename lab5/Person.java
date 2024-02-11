import java.time.*;
import java.util.*;

/**
 * @author Gosia Makiela
 * Class representing a person's personal data.
 */
public final class Person {

    /**
     * Person's first name
     */
    private final String firstName;

    /**
     * Person's last name
     */
    private final String lastName;

     /**
     * Person's date of birth, in the format of yyyy-mm-dd
     */
     private final LocalDate dateOfBirth;

    /**
     * Creates a person, with a name and date of birth
     * @param f first name
     * @param l last name
     * @param d date of birth
     */
    public Person(String f, String l, LocalDate d) {
        this.dateOfBirth = d;
        this.firstName = f;
        this.lastName = l;
    }

    /**
     * Creates a person as a copy of other person.
     * @param other Person, to make a copy of.
     */
    public Person(Person other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.dateOfBirth = other.dateOfBirth;
    }

    /**
     * Returns person's first name
     * @return Person's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns person's date of birth
     * @return Person's date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Returns person's last name
     * @return Person's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns data about a person: first name, last name, date of birth
     *
     * @return data about Person in format of firstName,lastName,dateOfBirth
     */
    @Override
    public java.lang.String toString() {
        return firstName + "," + lastName + "," + dateOfBirth;
    }
}
