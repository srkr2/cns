#include<stdio.h>
#include<string.h>
int main(){
    char *ptr = "Hello world";
    int i=0;
    for(int i=0;i<strlen(ptr);i++){
        printf("%c",ptr[i] ^ 0);
    }
    return 0;
}