#include <stdio.h> 
 
void swap(int *a, int *b) { 
    int temp = *a;   /* save the value at a */ 
    *a = *b;         /* put b's value into a's location */ 
    *b = temp;       /* put saved value into b's location */ 
}

//follows the same logic as swap() but without pointers
void broken_swap(int a, int b)
{
    int temp = a;
    a = b;
    b = temp;
}
 
int main() { 
    int x = 10; 
    int y = 20;
    int a = 1;
    int b = 4; 
 
    printf("Before actual swap: x = %d, y = %d\n", x, y); 
 
    swap(&x, &y); 
 
    printf("After actual swap: x = %d, y = %d\n\n", x, y);
    
    printf("Before broken swap: a = %d, y = %d\n", a, b);

    broken_swap(a, b);

    //swap not expected because function receives a copy and modifies only the copy. original variables remain unchanged
    printf("After broken swap: a = %d, y = %d", a, b);
 
    return 0;
} 