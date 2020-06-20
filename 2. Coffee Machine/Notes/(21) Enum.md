# Enum
* Sometimes it is a good idea to use constants in a programs. These constants are often grouped based on their content: seasons, colors, states, etc.
* To store a bunch of constants in one place and handle them in Java we can use an **enum**.
*  Basically, an enum represents a consistent set of named constants. By using enums we make our code more readable and clear.

## 1. Basics
* There’s a special keyword `enum` that is short for *enumeration* and allows us to create our own enumeration in the same way we normally declare a class:
```java
public enum Season {
	SPRING, SUMMER, AUTUMN, WINTER;
} 
```
* In general, an enum can be considered as a class with predefined instances. In the example above the four instances of Season are defined: `SPRING`, `SUMMER`, `AUTUMN`, `WINTER`. All of these instances are created by JVM in the same way as a static field of a class. 
* This is a reason why an enum cannot contain a public constructor. This means we *cannot* create enum objects by invoking enum constructor by the `new` keyword but have to choose one of the predefined instances instead.
* As we can see from the example above, there is an enum for all four seasons. This is how we create our own storage for all these seasons.
* If needed, technically we are able to list any number of “seasons” we want in here (mid-winter, Australian winter, etc.) in real life they have to make sense. Each of them represents a separate instance of the enum.
* According to the Java Code Convention, constants in an enum are written in uppercase letters.

## 2. Sample enum
* Consider a program that displays the battery level of a smartphone, power bank or any device with a discrete scale.
* First of all, let’s create an enum with several threshold levels that represent a battery level of charge:
```java
public enum ChargeLevel {
	FULL, HIGH, MEDIUM, LOW 
}
```
* Ans now we initialize a variable of the type `ChargeLevel` from the previous example :
`ChargeLevel high = ChargeLevel.HIGH;`
* Each enum value has a name that can be accessed by using the method `name()`:
`System.out.println(high.name()); //HIGH`
* Sometimes, we may need to access an enumeration instance by its name. This can be done with the `valueOf()` method. Here’s another way to initialize a variable:
`ChargeLevel medium = ChargeLevel.valueOf("MEDIUM"); // MEDIUM`
* An important thing to remember about this method is that it is case sensitive. That means that if the given string doesn’t exactly match any constant, we will get the **IllegalArgumentException**.
`ChargeLevel medium = ChargeLevel.valueOf("medium"); // IllegalArgumentException, valueOf is case-sensitive`
* If we want to look at all enumeration’s constants, we can get them in an array by using the `values()` method:
`ChargeLevel[] levels = ChargeLevel.values(); // [FULL, HIGH, MEDIUM, LOW]`
* Another method `ordinal()` returns the ordinal position of instance among **enum**s:
```java
System.out.println(high.ordinal()); // 1, (starting with 0)
System.out.println(ChargeLevel.LOW.ordinal()); // 3
```
* Although an enum is a reference type, two variables can be correctly compared by using both the `equals` method and the operator `==`.
```java
System.out.println(high.equals(ChargeLevel.HIGH)); // true
System.out.println(high == ChargeLevel.HIGH); // true
```

## 3. Fields and methods
* Suppose that we need to display the level of battery charge visually. We want it to be divided into several segments and have a color indication as well.
* To do this, we will add the corresponding fields and values to our enum:
```java
public enum ChargeLevel {
    FULL(4, "green"),
    HIGH(3, "green"),
    MEDIUM(2, "yellow"),
    LOW(1, "red");
    int sections;
    String color;
    ChargeLevel(int sections, String color) {
        this.sections = sections;
        this.color = color;
    }
    public int getSections() {
        return sections;
    }
    public String getColor() {
        return color;
    }
} 
```
* Java requires specific order within the enum declaration containing other fields and methods: constants should be defined first, their list must end with a semicolon.
* Now we have a class with additional info gathered in one place: the number of sections to highlight and color.
```java
System.out.println(ChargeLevel.LOW.sections); // 1
System.out.println(ChargeLevel.LOW.color); // red
```
* It is possible to extend enum by adding custom static methods. For example, adding a method that finds `ChargeLevel` instance by the given color:
```java
public enum ChargeLevel {
    FULL(4, "green"),
    HIGH(3, "green"),
    MEDIUM(2, "yellow"),
    LOW(1, "red");
    int sections;
    String color;
    ChargeLevel(int sections, String color) {
        this.sections = sections;
        this.color = color;
    }
    public int getSections() {
        return sections;
    }
    public String getColor() {
        return color;
    }
    public static ChargeLevel findByColor(String color) {
        for (ChargeLevel value: values()) {
            if (color.equals(value.color)) {
                return value;
            }
        }
        return null;
    }
}
```
* Here’s an example of our method’s output:
`System.out.println(ChargeLevel.findByColor("yellow")); // MEDIUM`

## 4. Enumerations in the switch statement
* An **enum** can be successfully used in the `switch` statement. For example, here is an enum with three possible user statuses:
```java
public enum UserStatus {
    PENDING, ACTIVE, BLOCKED
}
```
* Depending on the status, our program can perform different actions indicated by the `switch` statement. In this case, it prints out different responses:
```java
UserStatus status = ... // some status
switch (status) {
    case PENDING:
        System.out.println("You need to wait a little.");
        break;
    case ACTIVE:
        System.out.println("No problems, you may pass here.");
        break;
    case BLOCKED:
        System.out.println("Stop! You can't pass here.");
        break;
    default:
        System.out.println("Unsupported enum constant.");
}
```
The message that our code outputs depends on the value of the variable `status`.

## 5. Conclusion
* Enum is a container for a collection of constants. It has some embedded properties and methods for our convenience.
* They allow us to get the *name* and *position* of the constant, and make our life easier by enabling us to get all the instances of an enum or just one of them.
* In the first line of our enum declaration, we list our constants. After that, methods, variables, and the constructor may go.
* We can extend our enum whenever we want. We can read about enum in more detail in the  [Java documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) .
