# Switch statement
## 1. When conditional statement is not so good
* Suppose we need to write a program that performs different actions depending on the value of a variable. For example, choosing an action in the menu of a game.
* To do that, we can use a conditional statement with multiple branches as shown below :
```java
int action = ...; // a certain value from 1 to 4       
if (action == 1) {
    System.out.println("Starting a new game...");
} else if (action == 2) {
    System.out.println("Loading a saved game");
} else if (action == 3) {
    System.out.println("Displaying help...");
} else if (action == 4) {
    System.out.println("Exiting...");
} else {
    System.out.println("Unsuitable action, please, try again");
} 
```
Of course, this code handles the task. But if our conditional statement has a lot of branches, it can be hard to understand.

## 2. Three keywords: switch, case and default
* **The switch statement** provides a way to choose between multiple cases based on the value of a single variable (not an expression!). The variable can be an integer number, character, string, or enumeration.
* Using the switch statement, the previous code will look like this :
```java
switch (action) {
    case 1:
        System.out.println("Starting a new game...");
        break;
    case 2:
        System.out.println("Loading a saved game");
        break;
    case 3:
        System.out.println("Displaying help...");
        break;
    case 4:
        System.out.println("Exiting...");
        break;
    default:
        System.out.println("Unsuitable action, please, try again");
}  
```
The code is well-structured and easier to read than equal conditional statement.

## 3. The general form of the switch statement
```java
switch (variable) {
    case value1:
        // do something here
        break;
    case value2:
        // do something here
        break;    
    //... other cases
    case valueN:
        // do something here
        break;
    default:
        // do something by default
        break; // it can be omitted
}
```

The `switch` and `case` keywords are always required here. The keywords `break` and `default` are optional. The keyword `break` stops the execution of the whole switch statement, not just one case.
If a `case` does not have a `break` keyword, the following `case` will be evaluated as well, including the `default` case. The `default` case is also evaluated if there’s no other `case` that matches the variable value.
The `break` keyword in the `default` branch is optional and can be omitted.

## 4. An example with “zero”, “one” and “two”
* The following code outputs the names of integer numbers or a default text. This switch statement has three base cases and a single default case.
```java
int val = ...;
switch (val) {
     case 0:
         System.out.println("zero");
         break;
     case 1:
         System.out.println("one");
         break;
     case 2:
         System.out.println("two");
         break;
     default:
         System.out.println("The value is less than zero or greater than two");
} 
```
If the `val` is 0, the code prints:
	`zero`
If the `val` is 1, the code prints:
	`one`
If the val is `10`, the code prints:
	`The value is less than zero or greater than two`
* Omitting `break` keyword is not a good practice.
