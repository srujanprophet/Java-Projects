# 1. Introduction

You are already familiar with the `System.out.print()` and `System.out.println()` methods to print output to the console. But when you need **complex** formatting of output, these two methods are not really helpful. There are two methods that you can use in such cases, namely, `System.out.printf()` and `String.format()`.

## 2. Introducing the printf() method
The `printf()` method usually has two parts. First, you give the string you want to format as the first attribute. This string itself includes rules to format it via **format specifiers**. Some examples of format specifiers are `%d`, `%s`, etc. In the second part, you give the argument list that Java can use to format the string according to the format-specifiers.

See the following example to understand the different parts of the `printf()` function.

    System.out.printf("My Name is %s. I was born in %d", "Mike", 1998);

- The first part is `"My Name is %s. I was born in %d"`, where `%s` and `%d` are the format specifiers.
- The second part is the argument list: `"Mike", 1998`.


## 3. Different use cases of printf()

You can display an integer with the `%d` format specifier.
```java
public static void main(String[] args){
    System.out.printf("Display a Number %d", 15000);
}
```
Java will replace `%d` with 15000. The output of the above code is `Display a Number 15000`.

If you want several integers to be displayed in the output, use several `%d` specifiers.

```java
public static void main(String[] args){
    System.out.printf("The sum of %d and %d is %d", 15, 40, 55);
}
```

Java will put each argument in place of `%d`, starting from left. The output of the above code is `The sum of 15 and 40 is 55`.

If you want to display a floating-point value, use the `%f` specifier.
```java
public static void main(String[] args){
    System.out.printf("Display a Number %f", 15.23);
}
```

Similar to the above cases, Java will put 15.23 in place of `%f`. The above code will produce the following output. `Display a Number 15.230000` Although it's technically correct, it looks ugly. You don't want so many trailing zeros. You can set **precision** with the `printf()` method.
```java
public static void main(String[] args){
    System.out.printf("Display a Number %.2f", 15.23);
}
```
`.2f` decides that the number of digits that should appear after the **decimal** place is two. The code given above will output `Display a Number 15.23`

Similarly, you can display Characters and Strings with the `printf()` method. Take a look at the following code. If you want to print a character, use `%c`, and if you want to print a String, use `%s`.

```java
public static void main(String[] args){
    char abbr = 'H';
    String element = "Hydrogen";
    System.out.printf("%c stands for %s", abbr, element);
}
```

When this code runs, the value of the `abbr` variable will replace `%c` and the value of the `element` variable will replace `%s`. The output of the above code is `H stands for Hydrogen`.


## 4. The String.format() Method

The `format()` method in the String class works very much like the `printf()` method. The main difference here is that you return a string instead of printing it. Let's see several examples.

The following code formats an integer using it.
```java
public static void main(String[] args){
    int age = 22;
    String str = String.format("My age is %d", age);
    System.out.println(str);
}
```
When you execute this code, Java will create a String called `str` by concatenating `My age is` with the value of the `age` variable. Then it will print the value of `str`. The output is:

    My age is 22

Similarly, you can format other data types as well. See the following code.
```java
public static void main(String[] args){
    int age = 22;
    char initial = 'M';
    String surname = "Anderson";
    double height = 1.72;

    String details = String.format(
            "My name is %c. %s.%nMy age is %d.%nMy height is %.2f.",
            initial, surname, age, height);
    System.out.println(details);
}
```

You can see that we have used four data types in this example. Java will replace `%c`, `%s`, `%d`, `%f` with `initial`, `surname`, `age`, and `height` respectively. `%n` is the **newline** character that breaks the line every time it is used. The output of our code is:
```
My name is M. Anderson.
My age is 22.
My height is 1.72.
```

The `String` class also has a newer and slightly simpler method `formatted(Object... args)` that you can use instead of the static `String.format` method. Both of them have the same method body, so they are completely interchangeable. Here's how it looks in the program:
```java
public static void main(String[] args) {
    int age = 22;
    char initial = 'M';
    String surname = "Anderson";
    double height = 1.72;

    String details = "My name is %c. %s.%nMy age is %d.%nMy height is %.2f."
            .formatted(initial, surname, age, height);

    System.out.println(details);
}
```
The result is exactly the same as with the `String.format` method:
```
My name is M. Anderson.
My age is 22.
My height is 1.72.
```
Keep in mind that `formatted` is an instance method whereas the `String.format` method is a static one.


## 5. Summary


| **Format-Specifier** | **datatype**           | **Format printing**                                | **Formatting a string**                       |
| -------------------- | ---------------------- | -------------------------------------------------- | --------------------------------------------- |
| %d                   | int, short, byte, long | System.out.printf("Display an Integer %d", 15000); | String.format("Display an Integer %d", 15000) |
| %c                     | char                        |        	System.out.printf("Display a Character %c",'c');                                              |       String.format("Display a Character %c",'c')                                        |
|  %f                   | double, float                        |             	System.out.printf("Display a Floating-point Number %f",123.45);                                         |          String.format("Display a Floating-point Number %f",123.45)                                     |
|        %s              | String                        |          	System.out.printf("Display a String %s","String");                                            |              String.format("Display a String %s","String")                                 |

## 6. Conclusion

When you are writing complex applications, combining strings and variables with a `+` sign is not recommended. The `printf()` and `format()` methods are specifically created for that. Both these methods work exactly the same way except that the `printf()` method prints the output, while the `format()` method returns a `String`.
