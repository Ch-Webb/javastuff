import java.io.*;

public class WriteTest {

    public static void main( String[] args ) {

        String sc = "If this works, this program should be completely finished.\nI'm not particularly sure if i've done IT RIGHT but eh, screw it.\nHopefully this comes out all FINE.";
        System.out.println(sc);

        try {
            ObjectOutputStream out = new ObjectOutputStream
                ( new FileOutputStream( "Secret.dat" ) );
            out.writeObject(sc);
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
