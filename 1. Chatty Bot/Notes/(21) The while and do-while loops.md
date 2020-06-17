# The while and do-while loops
There are a number of approaches to repeat a fragment of code while a certain condition is true. 

## 1. The while loop
* The **while** loop consists of a block of code and a condition (a Boolean expression). If the condition is `true`, the code within the block is executed. This code repeats until the condition becomes `false`. Because this loop checks the condition before the block is executed, the control structure is often also known as a **pre-test loop**. 
* The basic syntax of the while loop is the following:
```java
while (condition) {
    // body: do something repetitive
} 
```
* A loop’s body can contain any correct Java statements including conditional statements and even other loops (nested loops).
* It is also possible to write an **infinite loop** if the condition is invariably `true`:
```java
while (true) {
    // body: do something indefinitely
} 
```
* **Example 1** : The following loop prints integer numbers while a variable is less than 5.
```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
// a next statement 
// Output
0
1
2
3
4
```
* **Example 2** : The following program displays English letters in a single line :
```java
public class WhileDemo {
    public static void main(String[] args) {
        char letter = 'A';
        while (letter <= 'Z') {
            System.out.print(letter);
            letter++;
        }
    }
} 
// ABCDEFGHIJKLMNOPQRSTUVWXYZ
```


## 2. The do-while loop
* In the **do-while** loop, the body is executed first and the condition is tested afterwards. If the condition is `true`, statements within the block are executed again. This repeats until the condition becomes `false`. 
* Because **do-while** loops check the condition after the block is executed, the control structure is often also known as a **post-test loop**. 
* In contrast to the **while** loop, which tests the condition before the code within the block is executed, the **do-while** loop is an exit-condition loop. So, the code within the block is always executed at least once.
* This loop contains three parts: the `do` keyword, a body, and `while(condition)`:
```java
do {
    // body: do something
} while (condition); 
```
* The following program reads an integer number from the standard input and displays the number. If the number 0 is entered, the program prints it and then stops. It demonstrates the **do-while** loop :
```java
public class DoWhileDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            value = scanner.nextInt();
            System.out.println(value);
        } while (value != 0);
    }
} 
// Input : 1 2 4 0 3
// Output 
1
2
4
0
```
* Like the **while** loop, the **do-while** loop can be infinite.
* In practice, the **do-while** loop is used less than the **while** loop.
* A good example of using it is a program that reads data from the standard input until a user enters a certain number or string. It is assumed that the program will be executed at least once, and repeated execution is optional.

## 3. Reading a sequence with an unknown length
* The `while` loop can be used to read a sequence of characters of an arbitrary length if it invokes `hasNext()` method of `Scanner` inside the condition. 
* The method returns `true` if the next element exists and otherwise, `false`.
* Here is code that calculates the sum of all elements from the given numbers :
```java
Scanner scanner = new Scanner(System.in);
int sum = 0;
while (scanner.hasNext()) {
	int elem = scanner.nextInt();
	sum += elem;
}
System.out.println(sum); 
```
If the input sequence is `1 2 3`, the code prints `6`, but if the input sequence is `5 18 9 23 4`, the code prints `59`.
