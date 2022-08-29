# Overview of the Basic Program
## The Hello World Program
```java
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello, World!");
	}
}
// Hello, World! 
```

## The Basic Terminology
* **Program** - a sequence of instructions (called statements) which are executed one after another in a predictable manner. Sequential flow is the most common and straightforward sequence of statements, in which statements are executed in the order they are written - from top to bottom in a sequential manner.
* **Statement** - a single action (like print a text) terminated by semi-colon (`;`);
* **Block** - a group of zero, one or more statements enclosed by a pair of braces `{...}`; There are two such blocks in the program above.
* **Method** - a sequence of statements that represents a high-level operation (also known as subprogram or procedure).
* **Syntax** - a set of rules that define how a program needs to be written in order to be valid; Java has its own specific syntax.
* **Keyword** - a word that has a special meaning in the programming language ( `public`, `class`, and many others). These words cannot be used as variable names for your own program;
* **Identifier or name** - a word that refers to something in a program (such as a variable or a function name);
* **Comment** -  A textual explanation of what the code does. Java comments start with `//`.
* **Whitespace** - all characters that are not visible (space, tab, newline, etc.).

## The Hello World Program under a microscope
The **Hello World** program illustrates the basic elements of Java programs :

1. **The public class** : It is the basic unit of a program. Every Java program must have at least one class. The definition of a class consists of the `class` keyword followed by the class name. A class can have any name, but it must not start with a digit. A set of braces `{...} ` encloses the body of a class.
    ```java
    public class Main {
    	// ...
    }
    ```		
2.  **The main method** :  To make a program runnable, we put a method named `main` inside a class. It is the entry point for a Java program. Again, the braces `{…}` enclose the body of the method which contains programming statements.
The name of this method (`main`) is predefined and should 
always be the same. Capitalization matters.
    ```java
        public static void main(String[] args) {    
    	    // statements go here
        }
    ```
	
3. **Printing “Hello, world!”** : The body of the method consists of programming statements that determine what the program should do after starting.
		We invoke a special method `println` to display a string
	 	followed by a new line on the screen.
    ```java
    System.out.println("Hello, World!"); // each statement has to end with;
    ```
	

## Keywords
* Totally, Java provides more than 50 keywords.
* Note, `main` is not a keyword.


## Conclusion
* The simplest program in Java has a single class with a single `main` method.
* Every Java program must have a `main` method as it is the first to be executed when the program runs.
