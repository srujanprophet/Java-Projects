# Defining methods
## 1. The program decomposition
* A method is a sequence of statements grouped together to perform an operation. In Java, a method is always located inside a class.
* The main reason to write methods is to decompose a program into small reusable subroutines. These subroutines can be used many times instead of always rewriting the code.
* A decomposed program has a modular structure and it is much easier to modify and maintain it than a program consisting of one single big main method. It is an important idea of procedural programming.

## 2. The base syntax of methods
In general case, a method has the following six components:
1. **a set of modifiers** (`public`, `static`, etc);
2. A type of the return value;
3. **a name**;
4. A list of parameters (as well known as formal parameters) in parenthesis `()`;
5. A list of exceptions;
6. A **body** containing statements to perform the operation.

The components listed above are in the correct order for the method declaration in Java. Some of these components are always required (marked as bold) and others are optional.
Pair of parentheses `()` is also required, as well as `{}` for enclosing the method’s body.

## 3. Defining a simple method
* Here is an example of a simple method that calculates the sum of two given numbers :
```java
public static int sum(int a, int b) {
	return a + b;
}
```
The `sum` is a typical method written in Java. The parameters are written in the parenthesis `"(...)"`. To return the integer result the keyword `return` is written
* In the general case, returning value and parameters can have any type, including non-primitive types.
* Also, the method has two modifiers : `public` and `static`. There is a recommended order for the modifiers that can be found in  [Java Language Specification](https://rules.sonarsource.com/java/tag/convention/RSPEC-1124) .
* Although, it is technically possible to write `static public`  instead, not following the suggested order will reduce the readability of our code and considered as bad practice.

## 4. Signatures
* The combination of the name of a method and its parameters is called the **signature**. It doesn’t include the returning type, modifiers, and names of parameters.
* The considered method `sum` has the following signature `sum(int, int)`.
* Here are some examples of other signatures:
	* `sum(double, double)`
	* `min(long, long, long)`
	* `getValue()`

## 5. Naming methods
* There are two kinds gf restrictions for the name of a method : the compiler (required) and the naming convention (optional, but desired)
* The Java compiler requires that a method name can be a **legal identifier**. The rules for legal identifiers are the following :
	* identifiers are case-sensitive;
	* an identifier can include Unicode letters, digits, and two special characters (`$`, `_`);
	* an identifier can’t start with a digit;
	* identifiers must not be a keyword.
* In addition, there is a naming convention that restricts possible method names. It’s optional but desired for developers.
* By the convention, method names should be a verb in lowercase or a multi-word name that begins with a verb in lowercase, followed by adjectives, nouns, etc. 
* In multi-word names, the first letter of the second and the following words should be capitalised. Here are some correct examples:
```
sum
getValue
calculateNumberOfOranges
findUserByName
printArray  
```

## 6. The type of a returning value and parameters
* A method can return a single value or nothing. To declare a method that returns nothing, we should write the special keyword **void** as the type of a result value.
* The following method prints the sum of two given numbers and returns no value:
```java
public static void printSum(int a, int b) {
    System.out.println(a + b);
}
```
* A method can take one or multiple parameters of the same or different types. Also, it’s possible to declare a method without any parameters, but “**()**” are still required.
```java
/**
 * The method has an int parameter
 */
public static void method1(int a) {
    // do something
}
    
/**
 * The method has long and double parameters
 */
public static void method2(long a, double b) {
    // do something
}
    
/**
 * The method has no parameters and returns a value
 */ 
public static int method3() {
    return 3;
}
    
/**
 * The method has an int parameter and returns an array of Strings
 */
public static String[] createArray(int lengthOfArray) {
    return new String[lengthOfArray];
} 
```
* When we call a method with a value of a primitive type then a copy of the value is created. Inside a method, we can process this copy, if we change it, the passed argument is not changed.
```java
public static void main(String[] args) {
    int val = 100; // 100
    change(val); // try to change val
    System.out.println(val); // it prints "100", because the method changed a copy of the val
}
 
/**
 * The method changes a given value
 */ 
public static void change(int val) {
    val = 400; // now, the copy is 400
} 
```

## 7. Method’s body
* In a method’s body, we can write any statements including the conditional statement, any loops, invoking methods and declaring local variables. The declared variables are visible only in this method.
* If a method returns a value, the method’s body must contain the `return` keyword. Moreover, a method may have multiple returns. But each state can return only a single value.
* The following method performs the integer division on a given value the specified number of times :
```java
public static int divideBy2(int number, int times) {
    if (times <= 0) {
        return number;
    } 
    for (int i = 0; i < times; i++) {
        number /= 2;
    }   
    return number;
} 
```
* If a method doesn’t return a value (it has the keyword `void`), the method body may contain the `return` keyword without returning value. It allows finishing the method ahead of schedule, for example, depending on a condition.
* For example, the following method prints its arguments if given numbers are positive, otherwise, it performs the return statement.
```java
public static void returnNothingOrPrintNumbers(int a, int b) {
    if (a <= 0 || b <= 0) {
        return;
    }
    System.out.println(a + " " + b);
} 
```

## 8. Conclusion
Methods allow us to decompose a program into some well-understood subroutines and manage them conveniently.
