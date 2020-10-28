# NPE
## 1. What is NPE
* Java provides a special type of value called `null` to indicate that no actual value is assigned to a reference variable. This value may cause one of the most frequent exceptions called `NullPointerException` (**NPE**)
* It occurs when a program attempts to use a variable with the `null` value. To avoid **NPE**, the programmer must ensure that the objects are initialized before the use.
* In 2009, Tony Hoare, a British Computer Scientist, who invented the concept of `null` reference, described it as a “**billion-dollar mistake”**.

## 2. NPE when invoking a method
* Since `String` is a regular reference type, its variable van be `null`. If we invoke a method or apply an operation to such variable, the code throws **NPE**.
* For example :
```java
String someString = null; // a reference type can be null
int size = someString.length(); // NullPointerException(NPE)
```
The same exception will occur if we will use uninitialised instances of any other reference type, not only `String`.
* To avoid the exception, we should explicitly check whether a string is `null` or not depending on the result perform different code. It’s similar to the default value.
`int size = str != null ? str,length() : 0;`

## 3. Comparing Strings
* A very common situation occurs when we try to compare a `String` variable and a string literal.
```java
if(str.equals("abc")) { // It throws NPE
	System.out.println("Same");
}
```
* To avoid **NPE** here we can call the equals method on literal rather than the object:
```java
String str = null;
if("abc".equals(str)) { // No NPE here
	System.out.println("The Same");
}
```
* What if we have two variables of the type `String`? Any of them may happen to be `null`. In this case, we can use the special auxiliary class `java.util.Objects`
```java
String s1 = null;
String s2 = null;
if ( Objects.equals(s1, s2)) { // no NPE here
	System.out.println("Strings are the same"):
}
```

## 4. Rules for avoiding NPE
Several general rules on how to avoid **NPE** in programs:
	* for reference types, use a condition statement to check whether the given variable is `null` before using it;
	* try to avoid assigning `null` to variables whenever possible;
	* use NPE-safe features from the standard library.