#include<stdio.h>
#include<string.h>
#include<ctype.h>
int main(){
    char plain[100],cipher[100],ch;
    int i = 0,j;
    char pt[26] = "abcdefghijklmnopqrstuvwxyz";
    char ct[26] = "utsrqpzyxwvonmlkjihgfedcba";
    printf("enter plain text: ");
    scanf("%s",plain);
    while(plain[i] != '\0'){
        ch = plain[i];
        for(j=0;j<26;j++){
            if(plain[i] == pt[j]){
                cipher[i] = ct[j];
                break;
            }
        }
        i++;
    }
    cipher[i] = '\0';
    printf("encrypted text: %s\n",cipher);
    i = 0;
    printf("decrypted text: ");
    while(cipher[i] != '\0'){
        for(j=0;j<26;j++){
            if(cipher[i] == ct[j]){
                printf("%c",pt[j]);
                break;
            }
        }
        i++;
    }
    printf("\n");
    return 0;
}