public class Dean extends Person{
    private final int startYear;
    private int endYear;
    private String degree;

    public Dean(String deg, String fn, String ln, int sy, int ey) {
        super(fn, ln);
        if (deg == null || fn == null || ln == null)
            throw new NullPointerException("Jeden z parametrow konstruktora jest rowny null");
        degree = deg;
        startYear = sy;
        endYear = ey;
    }

    @Override
    public Person greater(Person ob) {
        if(ob instanceof Dean) {
            if( (this.endYear - this.startYear) > (((Dean)ob).endYear - ((Dean)ob).startYear))
                return this;
            else
                return (Dean)ob;
        }
        else
            return null;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public void setDegree(String degree) {
        if (degree == null)
            throw new NullPointerException("degree nie moze byc null");
        this.degree = degree;
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
