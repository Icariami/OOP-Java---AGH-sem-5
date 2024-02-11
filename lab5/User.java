import java.time.*;
import java.util.*;

/**
 * @author  Gosia Makiela
 * Class representing a shop user.
 */
public final class User {

    /**
     * User's id, UUID format, immutable
     */
    private final UUID id;

    /**
     * User's e-mail
     */
    private String email;

    /**
     * User's password
     */
    private String password;

    /**
     * Person, to whom the account belongs to
     */
    private final Person person;

    /**
     * Creates user's account
     * @param id User's id in UUID format
     * @param e User's e-mail
     * @param p User's password
     * @param person Person creating the account
     */
    public User(UUID id, String e, String p, Person person) {
        this.id = id;
        this.email = e;
        this.password = p;
        this.person = new Person(person);
    }

    /**
     * Returns user's data as a person
     * @return user's personal data (from Person class)
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Returns user's password
     * @return user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns user's e-mail
     * @return user's e-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns user's id
     * @return user's id in UUID format
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets user's e-mail
     * @param email new user's e-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets user's password
     * @param password new user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns information about an user
     * @return User's data, format of id,email,password,firstName,lastName,dateOfBirth
     */
    @java.lang.Override
    public java.lang.String toString() {
        return id + "," + email + "," + password + "," + person.toString();
    }
}
