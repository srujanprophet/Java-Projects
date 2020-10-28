# What is an exception
* Exception are errors detected during thr program **execution** (at runtime), whereas syntax errors are those detected during **compiling** the program into byte-code.
* An exception interrupts the normal execution of a program.

## 1. ArithmeticException
* All the code **before** the exception is executed properly, and everything **after** is not.
* An example of exception is Division by zero.  The exception message is :
```
Exception in thread "main" java.lang.ArithmeticException: / by zero at ArithmeticExceptionDemo.main(ArithmeticExceptionDemo.java:11)
```
* To avoid this exception, we check the value before the division, and if the value is 0, we print a message.

## 2. NumberFormatException
* Another situation is when we are trying to convert a string into an integer number. If the string has an unsuitable format, the code will throw an exception.
* Example exception message :
```
Exception in thread "main" java.lang.NumberFormatException: For input string: "121a"
  at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
  at java.base/java.lang.Integer.parseInt(Integer.java:652)
  at java.base/java.lang.Integer.parseInt(Integer.java:770)
  at NumberFormatExceptionDemo.main(NumberFormatExceptionDemo.java:9)
```
* All the previous lines of the message show the positions inside the `parseInt` method that is part of the standard library.
* To avoid this exception, it is possible to check the input string by using a regular expression

## 3. Conclusion
* Exceptions don’t prevent a program from being compiled and run, but the program crashes as soon as the line with an exception is being executed.
* There are many types of exceptions.
* We can use control statements to avoid some kinds of exceptions (like `ArithmeticException` or `NumberFormatException`) in our programs.
* There is a general approach to handle exceptions and even throw them ourselves.
