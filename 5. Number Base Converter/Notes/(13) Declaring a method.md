# Declaring a method
By contrast with built-in methods, **user-defined** methods are created by the programmer. It is a common practice to create a customized subprogram for a specific purpose.

## 1. The syntax of the method
* Technically, a method is just a structured part of the code with a few components. In Java, a method is always located inside a **class.**
```java
public static int countSeeds(int parrotWeight, int parrotAge){
	return parrotWeight / 5 + parrotAge;
}
```
* A method contains a **set of modifiers**, a **type of the return value**, a **name**, a list of **parameters** in parentheses `()` , and a **body** in curly brackets `{}`. 
* The combination of the name of the method and the list of its parameters is known as a method **signature**. In our example, the signature is `countSeeds(int, int)`.
* Some methods also have a list of exceptions – they define its behavior in case of some mistake in the program. 

## 2. Modifiers
* There are two types of modifiers in Java: **access modifiers** and **non-access modifiers**.
* Access modifiers define the visibility of the method. For now, we’re using a `public` access modifier, which means there are no restrictions for invoking the method even from other classes.
* Non-access modifiers provide information about their behavior to JVM. The modifier `static` means that the method belongs to the class and it can be accessed without creating any object. This type of method is called a **static method**.
* If the method is declared without `static` modifier, it means that the method can be invoked only through or with an object of this class, or its instance. Such methods are called **instance methods**.
* There is a recommended order for the modifiers that we can find in  [Java Language Specification](https://rules.sonarsource.com/java/tag/convention/RSPEC-1124) . In our case, it is `public static`.

## 3. Method parameters
* In parentheses after the method name, we define the type, number, and order of the parameters. This reflects how they will be passed to the method when it is invoked.
```java
convertEuroToDollars(double dlrRate, long eur);
countMonthlySpendings(long food, long rent, long fun); 
replace(char a, char b);
```
* There are also methods that don’t have values passed to them. These methods are known as *non-parameterized*.

## 4. Body and return statement
* Before a method completes its execution and exits, it returns a value known as a **return value**. The result of our method execution can be a value of primitive types like `int`, `float`, `double`, `boolean`, or the reference types like `String`.
* What we see inside the curly brackets is known as the **body** of the method. The body holds the logic we want to implement by our method: a set of statements to perform with the passed values to obtain the result.
* Methods do not necessarily have to return a value. If we want a method not to return a value but to perform operations only, the keyword void is used as a return type.
* Though methods with void return type return nothing, we still may use a `return` word to exit the method. Usually, it’s applicable to the methods with conditions.

## 5. What happens when we invoke a method
* When invoking a method, we can write the returned value to some variable, print it out, or pass on to another method. That’s how it looks like in a program:
```java
int myParrotWeight = 100;
int myParrotAge = 3;
int myParrotPortion = countSeeds(myParrotWeight, myParrotAge); 
// now myParrotPortion equals 23
```
* When we pass a variable of a primitive type to a method, a copy of this variable is created with the same value. Inside a method, only this copy is processed. Any changes to this copy will not affect the variable that was passed.

## 6. Conclusion
* A method from the inside is a block of code that contains a set of modifiers, a return type, a name of a method, a list of its parameters, and a body of a method. 
* A method may return a value or return nothing, which is indicated with the `void` keyword.
