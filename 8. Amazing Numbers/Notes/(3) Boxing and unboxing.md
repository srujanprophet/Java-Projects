# Boxing and unboxing

## 1. Wrapper classes
Each primitive type has a class dedicated to it. These classes are known as **wrappers** and they are **immutable** (just like strings). Wrapper classes can be used in different situations:

- when a variable can be `null` (absence of a value);
- when you need to store values in generic collections;
- when you want to use special methods of these classes.

The following table lists all primitive types and the corresponding wrapper classes.

![image alt](https://ucarecdn.com/547298e4-3df8-4e70-9577-41663f4c6c0f/)

As you can see, Java provides eight wrapper classes: one for each primitive type. The third column shows the type of argument you need so that you can create an object of the corresponding wrapper class.

## 2. Boxing and unboxing

**Boxing** is the conversion of primitive types to objects of corresponding wrapper classes. **Unboxing** is the reverse process. The following code illustrates both processes:
```java
int primitive = 100;
Integer reference = Integer.valueOf(primitive); // boxing
int anotherPrimitive = reference.intValue();    // unboxing
```

**Autoboxing** and **auto-unboxing** are automatic conversions performed by the Java compiler.
```java
double primitiveDouble = 10.8;
Double wrapperDouble = primitiveDouble; // autoboxing
double anotherPrimitiveDouble = wrapperDouble; // auto-unboxing
```

You can mix both automatic and manual boxing/unboxing processes in your programs.

> Autoboxing works only when the left and the right parts of an assignment have the same type. In other cases, you will get a compilation error.

```java
Long n1 = 10L; // OK, assigning long to Long
Integer n2 = 10; // OK, assigning int to Integer 

Long n3 = 10; // WRONG, assigning int to Long
Integer n4 = 10L; // WRONG assigning long to Integer
```

## 3. Constructing wrappers based on other types
The wrapper classes have constructors for creating objects from other types. For instance, an object of a wrapper class can be created from a string (except for the Character class).

```java
Integer number = new Integer("10012"); // an Integer from "10012"
Float f = new Float("0.01");           // a Float from "0.01"
Long longNumber = new Long("100000000"); // a Long from "100000000"
Boolean boolVal = new Boolean("true");   // a Boolean from "true"
```

You can also create wrapper objects using special methods:

```java
Long longVal = Long.parseLong("1000");      // a Long from "1000"
Long anotherLongVal = Long.valueOf("2000"); // a Long from "2000"
```

If the input string has an invalid argument (for instance, `"1d0o3"`), both of these methods throw the `NumberFormatException`.

> Note, since Java 9, the constructors are deprecated. You should use special methods to create objects of the wrapper classes.

## 4. Comparing wrappers

Just like for any reference type, the operator `==` checks whether two wrapper objects are actually equal, i.e. if they refer to the same object in memory. The method `equals` , on the other hand, checks whether two wrapper objects are meaningfully equal, for example, it checks if two wrappers or strings have the same value.
```java
Long i1 = Long.valueOf("2000");
Long i2 = Long.valueOf("2000");
System.out.println(i1 == i2);      // false
System.out.println(i1.equals(i2)); // true
```

Do not forget about this feature when working with wrappers. Even though they correspond to the primitive types, wrapper objects are reference types!

## 5. NPE when unboxing
There is one possible problem when unpacking. If the wrapper object is null, the unpacking throws `NullPointerException`.
```java
Long longVal = null;
long primitiveLong = longVal; // It throws NPE
```
To fix it, we can add a conditional statement that produces a default value:
```java
long unboxed = val != null ? val : 0; // No NPE here
```

This code does not throw an exception.

Another example is arithmetic operations on `Integer`, `Long`, `Double` and other numeric wrapper types. They may cause an **NPE** since there is auto-unboxing involved.

```java
Integer n1 = 50;
Integer n2 = null;
Integer result = n1 / n2; // It throws NPE
```

## 6. Primitive types vs wrapper classes
In this topic, we've taken a look at wrapper classes for primitive data types. Wrapper classes allow us to represent primitive types as objects, that are reference data types.

Here are some important points to keep in mind:

- processing values of primitive types is faster than processing wrapper objects;
- wrappers can be used when you need `null` as a no-value indicator;
- primitive types cannot be used in standard collections (like lists, sets, or others), but wrappers can.


