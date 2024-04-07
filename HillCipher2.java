import java.util.Scanner;

public class HillCipher2 {
    static float[][] decrypt = new float[3][1];
    static float[][] a = { { 6, 24, 1 }, { 13, 16, 10 }, { 20, 17, 15 } };
    static float[][] b = { { 8, 5, 10 }, { 21, 8, 21 }, { 21, 12, 8 } };
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