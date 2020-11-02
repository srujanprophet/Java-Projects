# Hierarchy of exceptions
## 1. Exceptions and OOP
Java is primarily an object-oriented language. In such a paradigm, all exceptions are considered objects of special classes organized into a class hierarchy.

## 2. Hierarchy of exceptions
* The following picture illustrates the simplified hierarchy of exceptions:
<a href='(14)%20Hierarchy%20of%20exceptions/picexceptions-hierarchy.svg'>picexceptions-hierarchy.svg</a>
* The base class for all exceptions is `java.lang.Throwable`. This class provides a set of common methods for all exceptions:
	* `String getMessage()` returns the detailed string message of this exception object;
	* `Throwable getCause()` returns the cause of this exception or null if the cause is nonexistent or unknown;
	* `printStackTrace()` prints the stack trace on the standard error stream.
* The Throwable class has two direct subclasses: `java.lang.Error` and `java.lang.Exception`.
	* subclasses of the `Error` class represents low-level exceptions in JVM, for example: `OutOfMemoryError`, `StackOverflowError`;
	* subclasses of the `Exception` class deal with exceptional events inside applications, such as: `RuntimeException`, `IOException`;
	* the `RuntimeException` class is rather a special subclass of `Exception`. It represents so-called **unchecked** exceptions, including: `ArithmeticException`, `NumberFormatException`, `NullPointerException`.
* The four basic classes of exceptions (`Throwable`, `Exception`, `RuntimeException` and `Error`) are located in the `java.lang` package. They do not need to be imported. Yet their subclasses might be placed in different packages.

## 3. Checked and unchecked exceptions
* All exceptions can be divided into two groups: checked and unchecked. They are functionally equivalent but there is a difference from the compiler’s point of view.
1. **Checked exceptions** are represented by the `Exception` class, excluding `RuntimeException` subclass. The compiler checks whether the programmer expects their occurrence in a program or not.
If a method throws a checked exception, this must be marked in the declaration using the special `throws` keyword. Otherwise, the program will not compile.
Let’s take a look at the example. We use `Scanner` class, which is used as a means to read from standard input, to read from a file:
```java
public static String readLineFromFile() throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("file.txt")); // java.io.FileNotFoundException
    return scanner.nextLine();
}
```
Here,` FileNotFoundException` is a standard checked exception. This constructor of `Scanner` declares `FileNotFoundException` exception, because we assume that the specified file may not exist. Most importantly, there is a single line in the method that may throw an exception, so we put the throws keyword in the method declaration.
2. **Unchecked exceptions** are represented by the `RuntimeException` class and all its subclasses. The compiler does not check whether the programmer expects their occurrence in a program or not.
Here is a method that throws `NumberFormatException` when input string has an invalid format (e.g. `“abc”`).
```java
public static Long convertStringToLong(String str) {
    return Long.parseLong(str); // It may throw NumberFormatException
}
```
This code always successfully compiles without the `throws` keyword in the declaration.
	* Note, runtime exceptions may occur anywhere in a program. Adding them to each method’s declaration would reduce the clarity of a program. Thus, the compiler doesn’t require that we specify runtime exceptions in declarations.
	* The `Error` class and its subclasses are also considered as unchecked exceptions. However, they form a separate class.
