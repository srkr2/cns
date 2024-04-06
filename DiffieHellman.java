import java.math.BigInteger;
import java.util.Scanner;
public class DiffieHellman {
    
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        BigInteger p = BigInteger.valueOf(23);
        BigInteger a = BigInteger.valueOf(5);
        System.out.println("enter private key of A: ");
        BigInteger Xa = sc.nextBigInteger();
        System.out.println("enter private key of B: ");
        BigInteger Xb = sc.nextBigInteger();

        // Compute Ya and Yb
        BigInteger Ya = a.modPow(Xa, p);
        BigInteger Yb = a.modPow(Xb, p);

        // Compute Ka and Kb
        BigInteger Ka = Yb.modPow(Xa, p);
        BigInteger Kb = Ya.modPow(Xb, p);

        System.out.println("Public Key for A is : " + Ya);
        System.out.println("Public Key for B is : " + Yb);
        System.out.println("Secret Key for A is : " + Ka);
        System.out.println("Secret Key for B is : " + Kb);
    }
}