import java.time.LocalDate;
import java.util.Objects;

public class Graduate extends Student{
    private final LocalDate graduationDate;

    public Graduate(String fn, String ln, int id, double avg, LocalDate gd) {
        super(fn, ln, id, avg);
        graduationDate = Objects.requireNonNull(gd, "gd is null");
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
