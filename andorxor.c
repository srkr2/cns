#include<stdio.h>
#include<string.h>

int main(){
    int i;
    char *ptr = "Hello world";
    printf("And result: \n");
    for(i=0;i<strlen(ptr);i++){
        printf("%c",ptr[i] & 127);
    }
    printf("\nOR result:\n");
    for(i=0;i<strlen(ptr);i++){
        printf("%c",ptr[i] | 127);
    }
    printf("\nXOR result:\n");
    for(i=0;i<strlen(ptr);i++){
        printf("%c",ptr[i] ^ 127);
    }

}