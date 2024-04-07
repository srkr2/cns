#include<stdio.h>
#include<string.h>
#include<ctype.h>

void encrypt(char plain[],int key){
    int i=0;
    while(plain[i] != '\0'){
        char ch = plain[i];
        if(islower(ch)){
            ch = ch + (key %26);
            if(ch > 'z')
            {
                ch = ch -26;
            }
        }
        else if(isupper(ch)){
            ch = ch + (key %26);
            if(ch > 'Z')
            {
                ch = ch -26;
            }
        }
        plain[i] = ch;
        i++;
    }
}

void decrypt(char encrypt[],int key){
    int i =0;
    while(encrypt[i] != '\0'){
        char ch = encrypt[i];
        if(islower(ch)){
            ch = ch - (key%26);
            if(ch <'a'){
                ch = ch + 26;
            }
        }
        else if(isupper(ch)){
            ch = ch - (key%26);
            if(ch <'A'){
                ch = ch + 26;
            }
        }
        encrypt[i] = ch;
        i++;
    }
}
int main(){
    int key,i;
    char plain[100],temp;
    printf("enter plain text: ");
    gets(plain);
    printf("Enter key: ");
    scanf("%d",&key);
    printf("Encrypted text is: ");
    encrypt(plain,key);
    puts(plain);
    printf("Decrypted text is: ");
    decrypt(plain,key);
    puts(plain);
    return 0;
}