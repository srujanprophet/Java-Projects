# Types and Variables
## Declaring and initializing
* A **variable** is a placeholder for storing a value of a particular **type**: a string, a number, or something else. Every variable has a **name** (also known as an **identifier**) to distinguish it from others.
```java
DataType variablename = initialization; 
```

* The **type** (or **data type**) of a variable determines what possible operations can be performed on the variable and which values can be stored in it. Here we use a non-existing data type (**DataType**) to demonstrate the general form of declaration.
* The **name** (or **identifier**) distinguishes the variable from others. The name of a variable cannot start with a digit; it usually starts with a letter. Always try to choose meaningful and readable names for variables to make your code easy to understand.
* The **assignment operator** denoted as = is used to assign a single value or a result of an expression to a variable.
* The **initialization** is a value or a result of an expression that is assigned to the variable.

```java
String language = "java";
int numberOfApples = 5;
```


## Accessing the value of a variable
* Once a variable has been declared, its value can be accessed and modified using the name. In the example below, we declare a variable and then print it:
```java
String dayOfWeek = "Monday";
System.out.println(dayOfWeek); // Monday
```
* It is also possible to assign a value of one variable to another one:
```java
int one = 1;
int num = one;
System.out.println(num); // 1
```

* One important feature of variables is that they can be changed. You don’t need to declare a variable again to change its value; just assign a new value to it using the = operator.
```java
String dayOfWeek = "Monday";
System.out.println(dayOfWeek); // Monday
 
dayOfWeek = "Tuesday";
System.out.println(dayOfWeek); // Tuesday 
```

* There is one restriction for variables: you can only assign a value of the same type as the type of the initial variable. So, the following code is not correct:
```java
int number = 10;
number = 11; // ok
number = "twelve"; // it does not work! 
```

## Alternative forms of declaration
* There are several alternative forms of declaration which are less commonly used in practice. Here are several of them in particular examples.
	* Declaring several variables of the same type as a single statement
```java
String language = "java", version = "8 or newer";
```
	* Separating declaration and initialisation into statements:
```java
int age; // declaration
age = 35; // initialization 
```

## Type inference
* Since Java 11, we can write **var** instead of a specific type to force automatic type inference based on the type of assigned value:
`var variableName = initialization;`
* For example :
```java
var language = "Java"; // String
var version = 11; // int 
```
