# Boolean and logical operations
## 1. Boolean type
* The `boolean` is a data type that has only 2 possible values: `false` and `true`. This is also known as the **logical type**.
* This type is a common way in programming languages to represent something that has only two opposite states like *on* to *off*, *yes* or *no*, etc.
* We cannot assign an integer value to a `boolean` variable. In Java, 0 is not the same as `false`.
* Example, an application that keeps track of door’s openings:
```java
boolean open = true;
boolean closed = false;
System.out.println(open);   // true
System.out.println(closed); // false 
```

## 2. Logical operators
* Variables of the `boolean` type are often used to build logical expressions using logical operators.
* Java has four logical operators **NOT**, **AND**, **OR** and **XOR**.
	* **NOT** is a unary operator that reverses the boolean value. It is denoted as `!`.
```java
	boolean f = false; // f is false
	boolean t = !f;    // t is true 
```
	* **AND** is a binary operator that return `true`if both operands are `true`, otherwise it is `false`. It is denoted as `&&`.
```java
	boolean b1 = false && false; // false
	boolean b2 = false && true;  // false
	boolean b3 = true && false;  // false
	boolean b4 = true && true;   // true 
```
	* **OR** is a binary operator that returns `true` if at least one operand is `true`, otherwise, it returns `false`. It is denoted as `||`.
```java
	boolean b1 = false || false; // false
	boolean b2 = false || true;  // true
	boolean b3 = true || false;  // true
	boolean b4 = true || true;   // true
```
	* **XOR (exclusive OR)** is a binary operator that returns `true` if boolean operands have different values, otherwise, it is `false`.
```java
	boolean b1 = false ^ false; // false
	boolean b2 = false ^ true;  // true
	boolean b3 = true ^ false;  // true
	boolean b4 = true ^ true;   // false
```

## 3. The precedence of logical operators
* Below are the logical operations sorted in order of decreasing their priorities in expressions : `!` (NOT), `^` (XOR), `&&` (AND), `||` (OR).
* So, the following variable is `true`:
```java
boolean b = true && !false; // true, because !false is evaluated first 
```

## 4. An example: trekking
```java
boolean cold = false;
boolean dry = true;
boolean summer = false; // suppose now is autumn
 
boolean trekking = dry && (!cold || summer); // true, let's go to trek!
```

## 5. Short-circuiting evaluation
* An interesting thing, that the `&&` and `||` operators don’t evaluate the second argument if necessary. When the first argument of the `&&` operator evaluates to `false`, the overall value must be `false`; and when the first argument of the `||` operator evaluates to `true`, the overall value must be `true`.
* So :
	* `false && ...` -> `false`, since it is not necessary to know what the RHS is;
	* `true || …` -> `true`, since it is not necessary to know what the RHS is;
* This behaviour is known as **short-circuit evaluation**. It reduces the computation time, but can also be used to avoid some errors in programs.
