import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class BruteForce implements Runnable {
    private String password;
    public BruteForce(String password) throws IOException { this.password = password.toUpperCase(); }

    @Override
    public void run() {
        FileReader fileReader = null;
        try {
            /**
             * The block of code into which we insert the database
             */
            fileReader = new FileReader("C:\\Users\\Valdemar\\IdeaProjects\\BruteForce\\words.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line!= null) {
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            assert md != null;
            md.update(line.getBytes());
            byte[] hash = md.digest();
            String myHash = DatatypeConverter.printHexBinary(hash).toUpperCase();
            if (myHash.equals(password)) {
                System.out.println(line);
            }
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
