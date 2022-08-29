# Errors in programs
There are different errors that may occur during compiling or executing a Java program. We can divide all possible errors into two groups: **compile-time errors** and **run-time errors**.

## 1. Compile-time errors
Compile-time errors is a class of errors which prevent a java program to compile:
	* a syntax error: incorrect keyword, a forgotten symbol `;` at the end of a statement;
	* a bad source code file name;
	* invoking a non-existing method;
	* and many others.
Consider an example of compile-time errors. The following program should output the string “Hello!” but it does not compile.
```java
public class MyClass {
    public ztatic void main(String args[]) {
        System.out.printn("Hello!");
    }
}
```
There are two errors in this program:
	* a typo in the keyword `static`;
	* incorrect name of the method `println`.

To avoid such errors, programmers use modern IDE (Integrated Development Environment) with a static code analyzer. This tool allows programmers to identify compile-time errors before the compilation. In addition, it is able to highlight warning about more complex errors and weak places in our code, as well as tips on how to improve the code.

## 2. Run-time errors
Run-time errors (also known as “bugs”) are errors that occur when the program is running. Run-time errors will cause your program to behave unexpectedly or may even stop the execution.
There are two subtypes of run-time errors:
	* **logic errors** – when a program produces a wrong result because the code is not correct (for example, instead of **“Hello!”**, the program outputs **“Hi!”**);
	* **unhandled exceptional events** like division by zero, not found files and other unexpected cases.

Avoiding such run-time errors is a more difficult task than avoiding compile-time errors. If a program compiles successfully, there are no guarantees that it does not have bugs. There are different strategies to find such errors:
	* to **debug** the program;
	* to write **﻿automatic tests** for the program;
	* to use **code review** practice as part of ﻿the development process. In general, this practice stands for a case, when﻿ one or more developers visually inspect the source code of a program.
