import java.util.Objects;

public class Dean extends Person{
    private final int startYear;
    private int endYear;
    private String degree;

    public Dean(String deg, String fn, String ln, int sy, int ey) {
        super(fn, ln);
        degree = Objects.requireNonNull(deg, "deg is null");
        startYear = sy;
        endYear = ey;
    }

    @Override
    public Person greater(Person ob) {
        if(ob instanceof Dean d) {
            if( (this.endYear - this.startYear) > (d.endYear - (d.startYear)))
                return this;
            else
                return d;
        } else
            return null;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public void setDegree(String degree) {
        this.degree = Objects.requireNonNull(degree, "deg is null");
    }

    public String getDegree() {
        return degree;
    }

    public int getEndYear() {
        return endYear;
    }

    public int getStartYear() {
        return startYear;
    }

    @Override
    public String toString() {
        return degree + " " + super.toString() + ", Dean of the Faculty since " + startYear + " to " + endYear;
    }
}
