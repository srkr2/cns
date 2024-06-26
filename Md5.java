import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

public class Md5 {
    public static void main(String[] args) throws Exception {
        String text;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        text = sc.nextLine();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(text.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        String md5 = no.toString(16);
        
        // Pad with 0s to ensure the hash has 32 digits
        while (md5.length() < 32) {
            md5 = "0" + md5;
        }

        System.out.println("MD5 hash of text: " + md5);
    }
}
