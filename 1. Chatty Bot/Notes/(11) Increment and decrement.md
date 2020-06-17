# Increment and decrement
* One of the most famous operations in programming: **increment**.
* It is used in many programming languages including Java to increase a variable by one. 
* Fun fact: this operation is used in the name of C++, and signifies the evolutionary nature of the changes from C.

## Using ++ and — in Java
* Java has two opposite operations called increment (`++`) and decrement (`—`) to increase/decrease the value of a variable by one.
```java
int n = 10;
n++; // 11
n--; // 10 
```
* The code above is the same as below:
```java
int n = 10;
n += 1; // 11
n -= 1; // 10
```


## Prefix and postfix forms
* Both **increment** and **decrement** operators have two forms which are very important when using the result in the current statement:
	* **prefix** (`++n` or `—n`) increases/decreases the value of a variable before it is used;
	* postfix (`n++` or `n—`) increases/decreases the value of a variable after it is used.
* The following examples demonstrate both forms of increment
	* **Prefix increment**
```java
int a = 4;
int b = ++a;
 
System.out.println(a); // 5
System.out.println(b); // 5
```
	* **Postfix increment**
```java
int a = 4;
int b = a++;
 
System.out.println(a); // 5
System.out.println(b); // 4
```
	* In Java, postfix operator has higher precedence than the assignment operator. However, it returns the original value of a, not the incremented one