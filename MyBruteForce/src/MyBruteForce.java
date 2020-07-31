import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class MyBruteForce implements Runnable {
    private int min;
    private int max;
    private int len;
    public int[] chars;
    private String  hash;

    public MyBruteForce(String hash) {
        this.hash = hash;
    }

    public MyBruteForce(int min, int max, int len) {
        this.min = min;
        this.max = max;
        this.len = len;
        chars = new int[len + 1];
        Arrays.fill(chars, 1, len + 1, min);
    }

    private void increment() {
        while (chars[0] == 0) {
            for (int i = len; i >= 0; i--) {
                if (chars[i] < max) { chars[i]++;
                return;
                } else {
                    chars[i] = min;
                }
            }
        }
    }

    public String getNextString() {
        if (chars[0] != 0) { return null; }
        String result = "";
        for (int i = 1; i <  chars.length; i++) {
            result += (char) chars[i];
        }
        increment();
        return result;
    }

    @Override
    public void run() {
        for (int i = 1; i < 15; i++) {
            MyBruteForce bruteForce = new MyBruteForce('a', 'z', i);
            String next = bruteForce.getNextString();
            while (next != null) {
                try {
                    if (decryptMD5Hash(next, hash) != null) {
                        System.out.println(decryptMD5Hash(next, hash));
                        System.out.println(i);
                        SimpleDateFormat formatDateFirst = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
                        Date date = new Date(System.currentTimeMillis());
                        System.out.println(formatDateFirst.format(date));
                        return;
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                next = bruteForce.getNextString();
            }
            System.out.println(i);
            SimpleDateFormat formatDateSecond = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatDateSecond.format(date));
        }
    }

    public static String decryptMD5Hash(String toCheck, String hash) throws NoSuchAlgorithmException {
        return (generator(toCheck, hash)) ? toCheck : null;
    }

    private static boolean generator(String wordToCheck, String hash) throws NoSuchAlgorithmException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        md.update(wordToCheck.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return (Objects.equals(hash.toUpperCase(), myHash));
    }

}
