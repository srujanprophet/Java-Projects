# Coding style conventions

- In real life, programming is a process that involves a lot of people that work together. In fact, you often spend more time reading code than writing it.
- That is why you need to follow common best practices concerning programming style. This way, other programmers and yourself can read your code easily. Writing good code may help you get your first job and make a good impression on your colleagues.

:::info
Good coding style is like correct punctuation: you can manage without it, butitsuremakesthingseasiertoread. – The Tidyverse Style Guide by Hadley Wickham
:::

## 1. Java Conventions
- A list of recommendations on how to write code for some particular language is usually called a **coding style guide** or **style conventions**. The conventions help developers standardize and support well-readable code.
- They are more like recommendations than strict rules, but by following them a programmer creates code that is clean and consistent so that other developers will be happy to work with it.
- In most cases, companies and individual developers do not create their own style conventions. There are two generally accepted Java conventions that are used all over the world:
    - [Oracle Code Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf)
    - [Google Style Guide](https://google.github.io/styleguide/javaguide.html)
    
    Sometimes they could be modified or extended by a particular company to meet their needs.
    

## 2. The number of spaces
The first convention is to use 4 spaces as the unit of indentation in the whole program code.

Good:
```java
public class NumberOfSpacesExample {

    public static void main(String[] args) {
        System.out.println("Hi!");
        System.out.println("I'm a Java program.");
    }
}
```
Very bad:
```java
public class NumberOfSpacesExample {

  public static void main(String[] args) {
     System.out.println("Hi!");
   System.out.println("I'm a Java program.");
 }
}
```

As you can see, the second code example – with its irregular indentation – looks ugly and requires some effort to be read

## 3. The location of curly braces
Some time ago, developers were arguing a lot about where to put opening and closing curly braces in C-like programming languages. The next convention describes what to do in Java:

1. Put the **opening curly brace** at the **end of the line** where the block begins.
2. Put the **closing curly brace** at the **beginning of the next line**.

There are two examples below which illustrate these rules.

Good:
```java
public class NumberOfSpacesExample {

    public static void main(String[] args) {
        System.out.println("Hi!");
        System.out.println("I'm a Java program.");
    }
}
```

Not that bad, but not Java-way:

```java
public class NumberOfSpacesExample 
{
    public static void main(String[] args) 
    {
        System.out.println("Hi!");
        System.out.println("I'm a Java program.");
    }
}
```

Here, the second code example doesn't look ugly, but it is just not how it is generally done in Java. Most of the common conventions follow the first example.

## 4. Avoid extra spaces
Sometimes you may add some spaces even if you don't really need them. This will reduce the readability of your code.
    
* **Avoid extra spaces within parentheses.**

Good:

    System.out.println("Hello!");

Bad:

    System.out.println( "Hello!" );

- **Avoid an extra space before an open parenthesis.**

Good:

    System.out.println("OK");

Bad:

    System.out.println ("Shifted braces");
    
* **Avoid extra spaces before a semicolon:**

Good:

    System.out.println("No extra spaces");

Bad:

    System.out.println("It has an extra space") ;

# 5. The length of a line
- The last recommendation concerns the maximum length of a line. The Oracle Code Conventions propose avoiding lines longer than 80 characters. 
- Plenty of developers consider this restriction as outdated since modern monitors can easily display longer lines, whereas others would go on following this rule, which is handy, for example, if laptops are used.
- Other popular limit values are 100, 120, and sometimes even 140 characters.

# 6. Conclusion
- Style guides provide the conventions to help create well-readable and consistent code. For Java, the two most popular ones are the Oracle Code Conventions and Google style guide.
- One of their main objectives is to provide an effective way for developers to work together on code. Because of that, it is not as important to strictly follow one of the existing style guides as to stay consistent within the project.
