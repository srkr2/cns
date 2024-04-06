import java.io.*;
import java.util.*;


public class HillCipher {
    static float[][] decrypt = new float[3][1];
    static float[][] a = {{1,2,3}, {0, 1, 4}, {5, 6, 0}};
    static float[][] b = {{-24, 18, 5}, {20, -15, -4}, {-5, 4, 1}};
    static float[][] mes = new float[3][1];
    static float[][] res = new float[3][1];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        getkeymes();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 1; j++)
                for (int k = 0; k < 3; k++) {
                    res[i][j] = res[i][j] + a[i][k] * mes[k][j];
                }
        System.out.print("\nEncrypted string is : ");
        for (int i = 0; i < 3; i++) {
            System.out.print((char) (res[i][0] % 26 + 97));
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 1; j++)
                for (int k = 0; k < 3; k++) {
                    decrypt[i][j] = decrypt[i][j] + b[i][k] * res[k][j];
                }
        System.out.print("\nDecrypted string is : ");
        for (int i = 0; i < 3; i++) {
            System.out.print((char) (decrypt[i][0] % 26 + 97));
        }
        System.out.print("\n");
    }

    public static void getkeymes() {
        System.out.print("\nEnter a 3 letter string: ");
        String msg = sc.next();
        for (int i = 0; i < 3; i++)
            mes[i][0] = msg.charAt(i) - 97;
    }
}