# Running programs on your computer
## 1. Installing Java on your computer
* There is one prerequisite to run and compile the simplest **Hello World** program on our computer: we need to install **JDK** to develop Java applications.
* To check the installation has been completed, let’s check the version of Java by typing the following command in a terminal:
`java -version`
* It outputs the version of Java that is installed on our computer. If it does not work correctly, open the installation instructions and try to set the `path` variable in our OS.

## 2. Writing a program
To write a simple program and then start it on our computer we will use a terminal.

**Step 1.** Create a file named `Main.java` using any text editor (such as TextPad or NotePad++ for Windows; jEdit or gedit for Mac OS X; gedit for Ubuntu; or something else) and save it in a folder.
**Step 2.** Paste or type the following source code into this file:
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Java");
    }
}
```
The public class name must be the same as the file name.

## 3. Compiling and running a program.
To run a program, we will use a terminal installed in our OS. All the following commands need to be executed from within the same folder that the `.java` file is created.

**Step 3.** Compile the program using the following command in the terminal:
`javac Main.java`
The `javac` command asks the compiler to translate the source code into bytecode. The result of this command is a file named `Main.class`.

**Step 4.** Run the compiled program (make sure that terminal is open in the same directory as the source file):
`java -cp . Main`
The `java`  command starts a Java application. It does this by starting a JRE and invoking the main method inside the `Main` class.
The `-cp` parameter (*classpath*) specifies the location of user-defined classes and packages. The dot `.` means the current terminal directory.
We do not need to specify the `.class` extension when running a program. 

* Since Java 11 it is possible to compile and run Java source code file using a single command `java Main.java`. It will compile the file in-memory, so it does not produce a `.class` file.
