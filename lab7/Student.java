package pl.edu.agh.fis.lab7;

public class Student extends Person{
    private final int idNumber;
    private double average;

    public Student(String fn, String ln, int id, double avg) {
        super(fn, ln);
        if(fn == null || ln == null)
            throw new NullPointerException("Jeden z parametrow konstruktora jest null");
        this.idNumber = id;
        this.average = avg;
    }
    @Override
    public Person greater(Person ob) {
        if(ob instanceof Student) {
            if (this.average > ((Student) ob).average)
                return this;
            else
                return (Student)ob;
        }
        else
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
