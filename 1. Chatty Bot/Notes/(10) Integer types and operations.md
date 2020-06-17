# Integer types and operations
## 1. Basic information about integer types
* Java provides several types which represent integer numbers including positive, negative and zero.
* In practice, the most used types are `int` and `long`. The first type can store numbers from a smaller range than the second one, but it is often enough.
* We can perform all arithmetic operations (`+`,`-`, `*`, `/`, `%`) with variables of integer types.
* Some examples :
```java
int two = 2;
int ten = 10;
 
int twelve = two + ten; // 12
int eight = ten - two;  // 8
int twenty = two * ten; // 20
int five = ten / two;   // 5
int zero = ten % two;   // 0, no remainder
 
int minusTwo = -two; // -2 
```

* To improve the readability of our code, the special underscore character `_` can be used to separate groups of digits within a number.
```java
int million = 1_000_000;
```
* We can also print a value of an **int** variable:
```java
int number = 100;
System.out.println(number); // 100 
```
* All arithmetic operations work with the `long` type as well.
```java
long one = 1L;
long twentyTwo = 22L; // L or l is a literal for longs
long bigNumber = 100_000_000_000L;
 
long result = bigNumber + twentyTwo - one; 
System.out.println(result); 
```
* If a number ends with the letter `L` or `l` it is considered as long, otherwise, it is `int`. 

## The forms of the assignment operator
* Suppose we want to add some value to a variable :
```java
int n = 10;
n = n + 4; // 14 
```
* The assignment operator `=` has several forms which combine it with an operation to avoid repeating the variable twice:
```java
int n = 10;
n += 4; // 14 
```
* There are a few other possible forms `*=`, `/=`, `%=` and some others.

## Reading numbers from the standard input
* The following program reads two numbers from the standard input, adds them, and prints the sum :
```java
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = a + b;
        System.out.println(sum);
    }
} 
```
* If we know that the input numbers can be quite large, we can read `Long`’s instead of `Int`’s:
```java
long a = scanner.nextLong();
long b = scanner.nextLong();
long sum = a + b; 
```















