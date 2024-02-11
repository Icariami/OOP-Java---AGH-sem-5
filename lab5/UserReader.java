import java.time.*;
import java.util.*;
import java.io.*;

/**
 * @author Gosia Makiela
 * Reads data from a file
 */
public class UserReader{
    /**
     * Stores Users data from file
     */
    User[] data;

    /**
     * Constructor
     * Sets the size of data as number of lines in a file
     */
    public UserReader(){
        try (BufferedReader buf = new BufferedReader(new FileReader("shop.csv"))){
            int linesCount = (int) buf.lines().count() - 1;
            data = new User[linesCount];
        } catch (Throwable e) {
            System.out.println(e);
        }
    }

    /**
     * Reads data from file, puts it in data[]
     * @param file file name
     */
    public void readFromFile( String file ) {
        try (BufferedReader buf = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            boolean isFirst = true;
            while ((line = buf.readLine()) != null) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                }
                String[] tokens = line.split(",");
                data[i] = new User(UUID.fromString(tokens[0]), tokens[1], tokens[2], new Person(tokens[3], tokens[4], LocalDate.parse(tokens[5])));
                i++;
            }
        } catch( Throwable e ){
            System.out.println(e);
        }
    }

    /**
     * Prints content od data[]
     */
    public void print() {
        for(User u : data){
            System.out.println(u);
        }
    }


}
