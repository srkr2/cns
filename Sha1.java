import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

public class Sha1 {
    public static void main(String[] args) throws Exception {
        String text;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        text = sc.nextLine();
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] messageDigest = md.digest(text.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        String sha1 = no.toString(16);
        
        //Pad with 0s to ensure the hash has 40 digits
        while (sha1.length() < 40) {
            sha1 = "0" + sha1;
        }

        System.out.println("SHA1 hash of text: " + sha1);
    }
}
