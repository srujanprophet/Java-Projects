# Branching statements
**Branching statements** are used to alter the standard behaviour of loops; they can terminate a loop or skip some iterations.

## 1. The break statement
* The **break** statement has two uses:
	* it terminates the current loop of any type (**for, while, do-while**);
	* it terminates a case in the **switch** statement;
* The following example demonstrates a loop that includes one `break`:
```java
int i = 10;
while (true) { // the condition to continue the loop
    if (i == 0) { // the condition to perform break that stops this loop 
        break;
    }
    i--;
} 
```
* The **break** statement terminates only the loop in which it is currently located. If this loop is performed inside another loop, the outer loop won’t be stopped. The following code prints a ladder of numbers :
```java
for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        System.out.print(j + " ");
        if (i == j) {
            break;
        }
    }
    System.out.println();
} 
// output
0 
0 1 
0 1 2 
0 1 2 3 
0 1 2 3 4 
0 1 2 3 4 5 
0 1 2 3 4 5 6 
0 1 2 3 4 5 6 7 
0 1 2 3 4 5 6 7 8 
0 1 2 3 4 5 6 7 8 9
```
To stop the outer loop we’d like to declare a Boolean variable `stopped` and use it as a special Boolean flag.
```java
boolean stopped = false;
for (int i = 0; (i < 10) && !stopped; i++) {
    for (int j = 0; j < 10; j++) {
        System.out.print(j + " ");
        if (i == j) {
            stopped = true;
            break;
        }
     }
    System.out.println();
}
// Output
0
```

* There is another way to stop the outer loop: labeled break operator. However, it’s not good practice to use it.

## 2. The continue statement
* It causes a loop to skip the current iteration and go to the next one.
* This statement can be used inside any kind of loops
	* inside **for-loop**, the continue causes control to immediately move to the increment/decrement statement;
	* inside the **while** or **do-while loop** , control immediately moves to the condition.
* In the following example, a sequence of numbers is output. Odd numbers are skipped:
```java
int n = 10;
for (int i = 0; i < n; i++) {
    if (i % 2 != 0) {
        continue;
    }
    System.out.print(i + " ");
} 
// Output
0 2 4 6 8
```
* The **continue** statement and the **break** statement only affect the loop in which they are located.
* The **continue** statement cannot skip the current iteration of the outer loop.
* Often, we can rewrite our loop without using the continue statement. E.g. :
```java
int n = 10;
for (int i = 0; i < n; i++) { 
    if (i % 2 == 0) {
        System.out.print(i + " ");
    } 
} 
```
The result is the same as above, but the code became shorter and more readable.

* The widespread use of branching statements leads to poorly-structured code because conditions in our loops are not actually what they need to do.