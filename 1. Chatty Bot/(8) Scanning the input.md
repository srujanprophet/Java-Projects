# Scanning the input
* The **standard input** is a stream of data going into a program.
* By default, the standard input obtains data from the keyboard input but it’s possible to redirect it to a file.
* Actually, not all programs need to use the standard input. The typical way to solve programming problems is the following:
	1. Read data from the standard input (System.in);
	2. Process data to obtain a result;
	3. Output the result to the standard output (System.out).
	

## 1. Reading data with a scanner
* The simplest way to obtain data from the standard input is to use the standard class `Scanner`. 
* It allows a program to read values of different types (string, numbers, etc) from the standard input.
* To use this class, we should add the following import statement to the top of our file with the source code.
```java
import java.util.Scanner;
```
* Then, add the following construction after the import:
```java
Scanner scanner = new Scanner(System.in); 
```
* With this line, we create an object of `Scanner` class, that enables us to use its methods.
* `System.in` indicates that the program will read text that we type in the standard input.
* There are two ways to read strings with a `Scanner` class. If input is an integer number or a single word, we can read the data using `next()` **method**. For example,
```java
String name = scanner.next();
System.out.println("Hello, " + name + "!");
// If input is James, output will be :
// Hello, James!
```
* If the user’s input is an integer number like 123, the program will output this number. The `next()` method will store `123` or another integer number as a string, even if we know that this string consists of a number.
* But, if the user prints a compound name like Michael Scott, the program will output only the first word :
`Hello, Michael!`
* In this case, we need another method, a `nextLine()` **method**, which reads and outputs the whole line:
`Hello, Michael Scott!`
* In Java, **whitespace** includes not only space character, but mostly everything that looks empty when printed: tab, the newline character, and other non-printing characters.
* Term “whitespace” is used to refer to either of these. The more correct term to refer to what we’ve called “word” is **token** : it is a piece of text surrounded by whitespace.
* So now, the `next()` method finds and returns the next token, while `nextLine()` reads all data till the end of the current line.

## 2. Reading a multiline input
* Consider a sample input :
```
This is a sample
multiline input,
that is being read. 
```
* Sample code to read the input as  variables :
```java
import java.util.Scanner; 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        String word1 = scanner.next(); // "This"
        String line1 = scanner.nextLine(); // " is a simple" 
        String word2 = scanner.next(); // "multiline"
        String word3 = scanner.next(); // "input,"
        String line2 = scanner.nextLine(); // "" 
    }
}
```

## 3. Conclusion
* We can read data from the standard input with a special `Scanner` class. 
* `next()` and `nextLine()` methods will help us to read strings. 
* Both of them are used for getting input, but they act differently. `next()` method can read the input only till the whitespace while the `nextLine()` method reads the input till the end of the whole line.
