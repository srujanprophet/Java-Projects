# Floating-point types
* Java has two basic types to represent decimal numbers : `float` and `double`. They are called **floating-point types**.  In fact, these types cannot represent an arbitrary decimal number, because they support only a limited number of significant decimal digits (6-7 for `float`, and 14-16 for `double`).
* In addition, `double` can represent a wider range of numbers than `float`.

## 1. Declaring variables and assigning values
* Initializing double values:
```java
double zero = 0.0;
double one = 1.0;
double negNumber = -1.75;
double pi = 3.1415;
```
* If we want to declare and initialize a `float` variable, we should mark the assigned value with the special letter `f` (float literal):
`float pi = 3.1415f;`
`float negValue = -0.15f;`
* Both types can store only a limited number of significant decimal digits:
`float f = 0.888888888888888888f;`
`System.out.println(f); // 0.8888889`
* Floating-point types have a peculiar way to mark values with a mantissa:
`double eps = 5e-3;`
`double n = 0.01e2;`

## 2. Arithmetic Operations
* We can perform all types of arithmetic operations with floating-point types.
* For `double` and `float` operands, the operator `/` performs a division, not an integer division.
`double d1 = 5 / 4; // 1.0`
`double d2 = 5.0 / 4; // 1.25`

## 3. Errors during computations
* Operations with floating-point numbers can produce an inaccurate result :
`System.out.println(3.3 / 3); // 1.09999999999999999999999`
* Errors can accumulate during computation. In the following example we calculate the sum of ten decimals **0.1**:
`double d = 0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1;`
`System.out.println(d); // it prints 0.999999999999999999`

## 4. Reading floating-point numbers
* Using Scanner:
`float f = scanner.nextFloat();`
`double d = scanner.nextDouble();`
* The output of a program may have a lot of zeros because an operation with floating-point numbers can produce inaccurate results.

## 5. The decimal separator
* If there are different locale setting, the **Scanner** cannot read floating-point numbers with the dot character (**3.1415**). We can input numbers written with the comma separator (**3,1415**).
* If we want to use the dot character without modifying local setting, we can use the following code to create a scanner:
`Scanner sc = new Scanner(System.in).useLocale(Locale.US);`