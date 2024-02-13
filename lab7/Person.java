import java.util.Objects;
public abstract class Person {
    private String firstName;
    private String lastName;
    public Person(String fn, String ln) {
        firstName = Objects.requireNonNull(fn, "fn is null");
        lastName = Objects.requireNonNull(ln, "ln is null");
    }
    abstract public Person greater(Person ob);

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String fn){
        firstName = Objects.requireNonNull(fn, "fn is null");
    }

    public void setLastName(String ln){
        lastName = Objects.requireNonNull(ln, "ln jest null");
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
