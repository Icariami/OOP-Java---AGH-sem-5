import java.util.Objects;

public class Student extends Person{
    private final int idNumber;
    private double average;

    public Student(String fn, String ln, int id, double avg) {
        super(fn, ln);
        this.idNumber = id;
        this.average = avg;
    }
    @Override
    public Person greater(Person ob) {
        if(ob instanceof Student s) {
            if (this.average > s.average)
                return this;
            else
                return s;
        } else
            return null;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return super.toString() + ", id number: " + idNumber + ", average: " + average;
    }
}
