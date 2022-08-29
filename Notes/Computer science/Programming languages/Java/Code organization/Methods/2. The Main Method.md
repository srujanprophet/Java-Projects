# The Main Method
## 1. The declaration of the main method
* Java is primarily an object-oriented language. It means a Java program can be considered as a collection of objects that communicate via calling each other’s methods. 
* A typical Java program includes a lot of classes, interfaces, objects and other concepts from the object-oriented programming.
* Even the simplest “procedural-style” program should have at least one class and the main method inside to start the program. The main method is an entry point for any application.
* Ever since Java 7 there has been no other way to start an application without this method (excluding the case when the application is started inside a special container for applications).
* It is important to mention that a class containing the main method can have any name, but the main method should always have the name `main`
* Consider a declaration of the main method:
```java
public static void main(String[] args)
```
	* the keyword `public` indicates that the method can be invoked from everywhere;
	* the keyword `static` indicates the method can be invoked without creating an instance of the class;
	* the keyword `void` indicates the method doesn’t return any value;
	* the keyword `args` contains arguments entered at the command line, the array is empty if there are no arguments.

## 2. Invalid declarations of the main method
* If the main method has an invalid declaration, two cases are possible:
	* the program cannot be compiled
	* the program is successfully compiled but can’t be started
* **The program cannot be compiled**. It is a case when the main method declaration breaks the syntax of Java.
	* For example:
	`public static main(String[] args)`
	`pubic static void main(String[] args)`
* **A program can be compiled but cannot be run**. It is a case when the main method has the correct declaration as a regular method but doesn’t satisfy the specific requirement of the main method.
	* For example:
	`public static void main(String args)`
	`public void main(String[] args)`
	* In both cases, error happens at runtime.

## 3. Conclusion
* So, the main method is the entry point of any Java program. It has a very specific syntax that should be remembered.