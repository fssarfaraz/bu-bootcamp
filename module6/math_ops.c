#include <stdio.h> 

//function to add and multiply the input integers
void print_math(int a, int b)
{
    int sum = a + b;
    int product = a * b;
    printf("Sum: %d", sum);
    printf("\nProduct: %d", product);
}

int main() {
  //declare variables empty  
  int a;
  int b;

  //input a from keyboard
  printf("Enter first number: ");
  scanf("%d", &a);

  //input b from keyboard
  printf("Enter second number: ");
  scanf("%d", &b);

  //function call
  print_math(a, b);

  return 0; 
} 