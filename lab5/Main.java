/**
 * @author Gosia Makiela
 * Main class, contains only main method
 */
public class Main{

    /**
     * Main method
     * @param args input arguments
     */
    public static void main(String[] args) {
        UserReader ur = new UserReader();
        ur.readFromFile("shop.csv");
        ur.print();
    }
}
