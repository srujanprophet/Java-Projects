# Sizes and ranges
## 1. Numbers
* Java provides several types for integers and fractional numbers. These types are often used in arithmetic expressions.
* **Integer numbers** (0, 1, 2, …) are represented by the following four types: `long`,`int`,`short`,`byte` (from the largest to the smallest). 
* These types have different sizes and may represent different ranges of values. The range of an integer type is calculated as −(2^(n−1)) to (2^(n−1))−1, where *n* is the number of bits. The range includes 0, which is the reason for subtracting 1 from the upper bound.
	* `byte`: size 8 bits (1 byte), range from -128 to 127
	* `short`: size 16 bits (2 bytes), range from -32768 to 32767
	* `int`: size 32 bits (4 bytes), range from −(2^31) to (2^31)−1
	* `long`: size 64 bits (8 bytes), range from −(2^63) to (2^63)−1
* The sizes of types are always the same. They do not depend on the operating system or hardware and cannot be changed.
* The most commonly used integer types are `int` and `long`.
```java
int one = 1;
long million = 1_000_000L; 
```
* **Floating-point types** represent numbers with fractional parts. Java has two such types: `double` (64 bits) and `float` (32 bits). These types can store only a limited number of significant decimal digits (~6-7 for `float` and ~14-16 for `double`).
```java
double pi = 3.1415;
float e = 2.71828f; 
```

## 2. Characters
* Java has a type named `char` to represent letters (uppercase and lowercase), digits, and other symbols.
* Each character is just a single letter enclosed in single quotes. This type has the same size as the short type (2 bytes = 16 bits).
```java
char lowerCaseLetter = 'a';
char upperCaseLetter = 'Q';
char dollar = '$'; 
```
* Characters include symbols from many alphabets including hieroglyphs, as well as some other special symbols.


## Booleans
* Java provides a type called `boolean`, which can store only two values: `true` and `false`. It represents only one bit of information, but its size is not precisely defined.
```java
boolean enabled = true;
boolean bugFound = false;  
```
