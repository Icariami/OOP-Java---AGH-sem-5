public abstract class Person {
    private String firstName;
    private String lastName;
    public Person(String fn, String ln) {
        if(fn == null || ln == null)
            throw new NullPointerException("Jeden z parametrow konstruktora jest null");
        firstName = fn;
        lastName = ln;
    }
    abstract public Person greater(Person ob);

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String fn){
        if(fn == null)
            throw new NullPointerException("imie jest null");
        firstName = fn;
    }

    public void setLastName(String ln){
        if(ln == null)
            throw new NullPointerException("nazwisko jest null");
        lastName = ln;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
