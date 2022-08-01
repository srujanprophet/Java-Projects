# Ternary operator
* The **ternary operator** is an operator which evaluates a condition and chooses one of two cases to execute. It is also called the **conditional operator**.
* The operator can be considered as a form of the `if`-then-`else` statement. The ternary operator should not be confused with the conditional statement, despite their idealogical similarity. This operator can be used in places where an expression is expected.
* Sometimes, **the ternary operator** is more readable and concise than the corresponding **if statement**.
* Suppose we have to find the maximum of two int variables, `a` and `b`. It is easy to write using a conditional statement:
```java
int a = ...;
int b = ...;
int max = ...;
if (a > b) {
    max = a;
} else {
    max = b;
}
```
The equal ternary operator looks like:
```java
int max = a > b ? a : b;
```
* The general syntax of the ternary operator is the following,
```java
result = condition ? trueCase : elseCase; 
```
It includes two special symbols `?` and `:`.
* Here, the `condition` is a Boolean expression that evaluates to either `true` or `false`. If this expression is `true`, the ternary operator evaluates `trueCase`, otherwise `elseCase` is evaluated. 
* It is important that `trueCase` and `elseCase` are expressions which can be reduced to a common type. This type determines the type of the `result`.
* Another example that prints whether a number is even or odd.
```java
int num = ...;  // it's initialized by a value
System.out.println(num % 2 == 0 ? "even" : "odd"); 
```
This ternary operator consists of three operands: the value of the expression `num % 2 == 0`, and two string literals `”even"` and `”odd"`. The result type of it is `String`.
* Java allows us to nest one ternary operator into another one, but it can be less readable than the corresponding conditional statement.
