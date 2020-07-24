import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class BruteForce implements Runnable {
    private String password;
    private String [] array = {"123456" , "12345" , "password" , "DEFAULT" , "123456789" ,
            "qwerty" , "12345678" , "abc123" , "pussy" , "1234567" , "696969" , "ashley" ,
            "fuckme" , "football" , "baseball" , "fuckyou" , "111111" , "1234567890" , "ashleymadison" ,
            "password1" , "madison" , "asshole" , "superman" , "mustang" , "harley" , "654321" ,
            "123123" , "hello" , "monkey" , "000000" , "hockey" , "letmein" , "11111" , "soccer" ,
            "cheater" , "kazuga" , "hunter" , "shadow" , "michael" , "121212" , "666666" , "iloveyou" ,
            "qwertyuiop" , "secret" , "buster" , "horny" ,"goodforyou", "jordan" , "hosts" , "zxcvbnm" , "asdfghjkl" ,
            "affair" , "dragon" , "987654" , "liverpool" , "bigdick" , "sunshine" , "yankees" ,
            "asdfg" , "freedom" , "batman" , "whatever" , "charlie" , "fuckoff" , "money" ,
            "pepper" , "jessica" , "asdfasdf" , "1qaz2wsx" ,"$urHacker!1", "987654321" , "andrew" , "qazwsx" ,
            "dallas" , "55555" , "131313" , "abcd1234" , "anthony" , "steelers" , "asdfgh" ,
            "jennifer" , "killer" , "cowboys" , "master" , "jordan23" , "robert" , "maggie" ,
            "looking" , "thomas" , "george" , "matthew" , "7777777" , "amanda" , "summer" ,
            "qwert" , "princess" , "ranger" , "william" , "corvette" , "jackson" , "tigger" ,
            "computer","very simple", "very", "simple"};

    public BruteForce(String password) { this.password = password.toUpperCase(); }

    @Override
    public void run() {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        for (String string : array) {
            md.update(string.getBytes());
            byte[] hash = md.digest();
            String myHash = DatatypeConverter.printHexBinary(hash).toUpperCase();
            if (myHash.equals(password)) {
                System.out.println(string);
            }
        }
    }
}