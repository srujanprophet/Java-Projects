# Comments
* Inside a Java program, we can write a special text that will be ignored by the java compiler — known as the **comment** .
* Comments allow us to exclude code from the compilation process (disable it) or clarify a piece of code to us or other developers. 
* The Java programming language supports three kinds of comments.

## 1. End-of-line comments
* The java compiler ignores any text from `//` to the end of the line.
```java
class Program {
	public static void main(String[] args) {
		// The line below will be ignored
		// System.out.println("Hello, World!");
		// It prints the string "Hello, Java"
		System.out.println("Hello, Java"); // Here, can be any comment
	}
}
```

## 2. Multi-line comments
* The compiler ignores  a text from `/*` and the nearest `*/`. It can be used as multiple and single-line comments.
```java
class Program {
	public static void main(String[] args) {
		/* This is a single-line comment */
		/* This is an example of
			a multi-line comment */
	}
}
```
* Comments can be used inside other comments :
```java
class Program {
	public static void main(String[] args) {
		/*
		System.out.println("Hello"); // print "Hello"
		Systemm.out.println("Java"); // print "Java"
		*/
	}
}
```


## 3. Java documentation comments
* The compiler ignores any text from `/**` to `*/` just like it ignores multi-line comments.
* These kinds of comments can be used to automatically generate documentation about our source code by using the **javadoc** tool. 
* Usually, these comments are placed above declarations of classes, interfaces, methods and so on.
* Some special labels such as `@param` or `@return` are often used for controlling the tool. 
* For example,
```java
class Program {
    /**
     * The main method accepts an array of string arguments
     *
     * @param args from the command line
     */
    public static void main(String[] args) {
        // do nothing
    }
} 
```

