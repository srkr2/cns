import java.math.*;
import java.util.Random;
import java.util.Scanner;

public class Rsa {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a Prime number: ");
        BigInteger p = sc.nextBigInteger(); // Here's one prime number..
        System.out.print("Enter another prime number: ");
        BigInteger q = sc.nextBigInteger(); // ..and another.
        BigInteger n = p.multiply(q);
        BigInteger pi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = generateE(pi);
        BigInteger d = e.modInverse(pi); // Here's the multiplicative inverse
        System.out.println("Encryption keys are: " + e + ", " + n);
        System.out.println("Decryption keys are: " + d + ", " + n);

        System.out.println("enter plain text: ");
        String plainText = sc.next();
        BigInteger message = new BigInteger(plainText);
        BigInteger encrypted = message.modPow(e, n);
        BigInteger decrypted = encrypted.modPow(d, n);
        System.out.println("encrypted: " + encrypted);

        System.out.println("decrypted: " + decrypted);
    }

    public static BigInteger generateE(BigInteger pi) {
        BigInteger e;
        Random random = new Random();
        do {
            e = new BigInteger(pi.bitLength(), random);
        } while (e.compareTo(pi) >= 0 || !e.gcd(pi).equals(BigInteger.ONE));
        return e;
    }
}