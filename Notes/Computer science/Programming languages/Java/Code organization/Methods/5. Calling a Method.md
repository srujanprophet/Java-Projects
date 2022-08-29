# Calling a method
## 1. Name of the method
* Each method has a name that is used to call it. Generally, it reflects what method does – prints, finds, calculates, provides you with some information.
* The Java compiler requires a method name to be a **legal identifier**. The rules for legal identifiers are the following:
	* identifiers are case-sensitive;
	* an identifier can include Unicode letters, digits, underscore _ or currency characters, such as `$`;
	* an identifier can’t start with a digit;
	* identifiers must not be a keyword.
* In addition, there is a naming convention that restricts possible method names. It’s optional but desired for developers. By convention, the one-word name should be a verb in lowercase: `sum`, `multiply`, or `round`.
* If a method has a multi-word name, the first letter of the second and the following words should be capitalized: `getValue`, `calculateNumberOfOranges`, or `findLetter`

## 2. Calling a method
* If we want to call (or invoke) a method in your program, we should write its name and pass the values of its parameters in parentheses.
`findUserbyName("Kate");`
Here we pass a String value with a name to make the `findUserByName` do its job.
* To call a method from the outside of the class it belongs to we need to indicate a class as a prefix. Check these methods:
`Math.round(79.378);`
`Caracter.isLetter('a');`
* Some methods are called in a slightly different way :
`String name = new String(“Anya”);`
`name = name.toLowerCase(); `
Methods like this require an object of a certain class to be invoked. Before we called `toLowerCase()` method, we created an object of a `String` class called `name`, since the method in question deals with strings. Now we can call the method for this particular **instance (2)**,which results in decapitalizing all the letters from our string.
* This method requires an instance to be created before it can be called, that’s why it is known as an **instance method.**

## 3. Built-in methods
* It is more efficient to use pre-defined methods that are always available to the user. That is why there are two types of methods in Java: **built-in** and **user-defined** methods.
* Built-in methods belong to the Standard Java library. Now there are a lot of built-in methods that convert or compare the values, round doubles, find the maximum or the minimum value, and do a lot of useful operations.
* We’ve already dealt with `round()`, `isLetter(),` `compareTo()`, `hasNext()` methods, but the number of built-in methods is huge and constantly growing. 
* We can find the method we need in Oracle documentation. For example,  check the link to the  [Math library](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html) .
* By contrast with built-in methods, user-defined methods are created by the programmer. It is a common practice to create a customized subprogram for a specific purpose.

## 4. Conclusion
* Generally, a method is a necessary tool for a programmer who is aimed at a neat and reusable code style. With the help of methods, we can perform any specific task we need. 
* They make the program look more readable, and we don’t need to repeat routine code lines over and over. Some tasks are wrapped in special built-in methods that are parts of the standard Java library. 