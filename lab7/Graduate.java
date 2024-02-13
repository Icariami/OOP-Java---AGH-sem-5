package pl.edu.agh.fis.lab7;

import java.time.LocalDate;

public class Graduate extends Student{
    private final LocalDate graduationDate;

    public Graduate(String fn, String ln, int id, double avg, LocalDate gd) {
        super(fn, ln, id, avg);
        if(fn == null || ln == null || gd == null)
            throw new NullPointerException("Jeden z parametrow konstruktora jest null");
        graduationDate = gd;
    }
    public Person greater(Person ob) {
        return super.greater(ob);
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", graduation date: " + graduationDate.toString();
    }
}
