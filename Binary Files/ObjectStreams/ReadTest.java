import java.io.*;
import java.util.Date;

public class ReadTest {

    public static void main( String[] args ) {

        try {
            ObjectInputStream in = new ObjectInputStream
                ( new FileInputStream( "matt.dat" ) );
            String sc = (String)in.readObject();
            System.out.println(sc);
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

