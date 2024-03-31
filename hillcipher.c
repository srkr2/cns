#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

// Function to calculate the modulo inverse of a number
int modInverse(int a, int m) {
    for (int x = 1; x < m; x++) {
        if (((a % m) * (x % m)) % m == 1) {
            return x;
        }
    }
    return -1;
}

// Function to encrypt the plaintext using Hill cipher
void encrypt(char *plaintext, int keyMatrix[][3], int len) {
    int ciphertext[len];
    for (int i = 0; i < len; i += 3) {
        for (int j = 0; j < 3; j++) {
            ciphertext[i + j] = 0;
            for (int k = 0; k < 3; k++) {
                ciphertext[i + j] += (keyMatrix[j][k] * (plaintext[i + k] - 'A'));
            }
            ciphertext[i + j] %= 26;
        }
    }

    printf("Encrypted Text: ");
    for (int i = 0; i < len; i++) {
        printf("%c", ciphertext[i] + 'A');
    }
    printf("\n");
}

// Function to decrypt the ciphertext using Hill cipher
void decrypt(int *ciphertext, int keyMatrix[][3], int len) {
    int invKeyMatrix[3][3];
    int determinant = 0;

    // Calculating determinant of the key matrix
    for (int i = 0; i < 3; i++) {
        determinant += (keyMatrix[0][i] * (keyMatrix[1][(i + 1) % 3] * keyMatrix[2][(i + 2) % 3] - keyMatrix[1][(i + 2) % 3] * keyMatrix[2][(i + 1) % 3]));
    }

    // Calculating modulo inverse of the determinant
    int invDet = modInverse(determinant, 26);

    // Calculating adjoint of the key matrix
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            invKeyMatrix[i][j] = (((keyMatrix[(j + 1) % 3][(i + 1) % 3] * keyMatrix[(j + 2) % 3][(i + 2) % 3]) - (keyMatrix[(j + 1) % 3][(i + 2) % 3] * keyMatrix[(j + 2) % 3][(i + 1) % 3])) * invDet) % 26;
            if (invKeyMatrix[i][j] < 0) {
                invKeyMatrix[i][j] += 26;
            }
        }
    }

    int plaintext[len];
    for (int i = 0; i < len; i += 3) {
        for (int j = 0; j < 3; j++) {
            plaintext[i + j] = 0;
            for (int k = 0; k < 3; k++) {
                plaintext[i + j] += (invKeyMatrix[j][k] * ciphertext[i + k]);
            }
            plaintext[i + j] %= 26;
        }
    }

    printf("Decrypted Text: ");
    for (int i = 0; i < len; i++) {
        printf("%c", plaintext[i] + 'A');
    }
    printf("\n");
}

int main() {
    int keyMatrix[3][3] = {{6, 24, 1}, {13, 16, 10}, {20, 17, 15}};
    char plaintext[100];
    int ciphertext[100];

    printf("Enter the plaintext (in uppercase): ");
    scanf("%s", plaintext);

    int len = strlen(plaintext);

    printf("Plaintext: %s\n", plaintext);

    // Padding the plaintext with 'X' if its length is not a multiple of 3
    int padding = len % 3;
    if (padding != 0) {
        for (int i = 0; i < (3 - padding); i++) {
            plaintext[len + i] = 'X';
        }
        plaintext[len + 3 - padding] = '\0';
    }

    len = strlen(plaintext);

    // Converting plaintext to uppercase
    for (int i = 0; i < len; i++) {
        plaintext[i] = toupper(plaintext[i]);
    }

    // Converting plaintext to numerical values ('A' = 0, 'B' = 1, ...)
    for (int i = 0; i < len; i++) {
        ciphertext[i] = plaintext[i] - 'A';
    }

    encrypt(plaintext, keyMatrix, len);

    decrypt(ciphertext, keyMatrix, len);

    return 0;
}