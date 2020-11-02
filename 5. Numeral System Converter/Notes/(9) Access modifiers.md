# Access modifiers
**Access modifier** is a special keyword that specifies who is allowed to use our code or a special part of it. It can be placed in front of any field, method or entire class.

## 1. OK, so why should we use them?
* There are two main reasons to take access under control: clarity and safety of code.
* **Code clarity**. Imagine our code is a complicated engine of a washing machine. There are some available functions – for example, choosing a washing program or starting a washing process. What can we do to help the user quickly figure out how to wash their clothes? We can cover the engine with the body and add some buttons for choosing a washing mode and starting the process. The user has no need to know what is going on inside the machine’s body; the buttons to get the result are more than enough.
* That’s how access control helps in code – we can **“hide” the engine from the user** by restricting access and simply provide them with the public “buttons”.
* **Code safety**. Now imagine we have developed a rather useful library that is used by other developers. One day some John Doe wants to use our code’s functionality in his project, but the problem is that he needs to change one variable in one of our classes. If it is public, nothing can stop him from doing that in his code before using method A from the library.
* What can happen if the variable is used somewhere in method B? Probably the B method would start to act unpredictably. So, protecting important parts of our code is a guarantee that it will be **used as an unmodifiable part** and its behavior will be the exact one we have developed for it.

## 2. Public and package-private classes
* In fact, when we manage the access in our code, we simply divide objects of our program into two main groups: top-level items and low-level items.
* Fields and methods that are explicitly used outside the class are called top-level fields and methods. If fields and methods are used inside the class, they are known as low-level ones. This low-level and top-level logic is also applicable to the classes.
* Usually, using low-level items helps to unload top-level classes, methods or fields in order to structurize and decompose the code. If these items are not explicitly used, it will be efficient to restrict access to them.
* A top-level class (not an inner one, not a nested one) can have one of two following modifiers:
	* **package-private (default, no explicit modifier)**: visible only for classes from the same package;
	* **public:** visible to all classes everywhere.
* Here is a class inside the package org.hyperskill.java.packages.theory.p1. with default package-private access:
```java
package org.hyperskill.java.packages.theory.p1;
class PackagePrivateClass{
}
```
This class can be used only by other classes from the same package. It’s not even visible for classes from any other package including:
```
org.hyperskill
org.hyperskill.java.packages.theory
default package
```
* If the class is package-private in package `a.b`, it is still unavailable from package `a.c` and package `a` itself. ### Here is a public class inside the package org.hyperskill.java.packages.theory.p2
```java
package org.hyperskill.java.packages.theory.p2;
public class PublicClass {
}
```
This class has no access restrictions, it is visible to all classes and can be used everywhere including:
```
org.hyperskill
org.hyperskill.java.packages.theory
org.hyperskill.java.packages.theory.p1
default package
```
* The common way of using top-level class modifiers is:
	1. make the classes, containing exact methods for the users (the “buttons”), **public**;
	2. make all other classes with low-level logic methods, used by public ones, **package-private** (cover the engine with the body).
* **Getter** and **setter** methods are used to protect and hide our data when creating classes. A getter method returns the value of a field while a setter method sets or updates the value. 
* Everything that’s not meant to be used/changed by classes from other packages, should not be public.

## 3. Private members
* A class member (a field or a method, e. g. class constructor) has more options to choose from: **private, package-private, protected** and **public**. 
* Fields are often declared **private** to control access to them from any other class. In some cases, these fields are only used internally in the class and there is no way to change and even access them from any other class. In other cases, it can be done via **accessor methods** (e.g. getters and setters).
* Private methods are used to hide the internal low-level logic implementation from the rest of the code and make public methods more brief and readable.
* Here is the class `Counter` with the private field `current`. This field can be read only with the method `getCurrent()` , a **getter-method**, and changed with the `inc()` method. The last one is not exactly a **setter-method**, because it doesn’t manually set a value to a `current` variable, just incrementing it.
```java
public class Counter {
   private long current = 0;
   public long getCurrent() {
       return current;
   }
   public long inc() {
       inc(1L);
       return current;
   }
   private void inc(long val) {
       current += val;
   }
}
```
* Sometimes, a private class constructor is required. This type of constructor can only be used inside the class, e.g. from another constructor, which can be public or private too, or from the class methods.

## 4. Package-private members
* A **package-private** access modifier does not require any keyword. If a field, a method or a constructor has this modifier then it can be read or changed from any class inside the same package.
* Here are two classes in the same package: `Salary` and `Promotion`.
The class `Salary` has a package-private field and constructor.  The instance of the `Salary` can be created inside a method of `Promotion`, and a field can also be accessed by `Promotion` and its members because they have the same package.
```java
public class Salary {
    long income;
    Salary(long income) {
        this.income = income;
    }
}

public class Promotion {
    Salary salary;
    Promotion(Salary salary) {
        this.salary = salary;
    }
    public void promote() {
        salary.income += 1500;
    }
}
```

## 5. Protected and public members
* If a class member has the **protected** access modifier, it can be accessed from classes inside the same package and all subclasses of this class (including the ones in other packages). 
* Protected option is less restricting than package-private as it allows some classes from other packages access to the code member.
* **Public** access modifier means that there is no restriction on using field, method or class. It’s often used for constructors, methods representing the class API but not commonly used with fields.
Here are common ways to understand which access modifier to choose. 
<a href='(9)%20Access%20modifiers/picaccess_modifiers.svg'>picaccess_modifiers.svg</a>

## 6. Summary
* **private** — available only inside a class;
* **package-private** (also known as **default**, implicit) — available for all classes in the same package;
* **protected** — available for classes in the same package and for subclasses;
* **public** — available for all classes everywhere.
- - - -
Modifier	   	       |	   Class	   |	 Package	 | 	Subclass    |       Global		|
- - - -
Public	   	       |	   Yes	   |	 Yes	 		 | 	  Yes    	    |   	       Yes		|
Protected	       |	   Yes.         |	 Yes	 		 | 	  Yes    	    |   	       No		|
Default  	       	       |	   Yes	   |	 Yes	 		 |  	  No    	    |    	No	        |
Private	   	       |	   Yes	   |	 Yes			 | 	  No    	    |   	        No		|
- - - -
* Only **public** or default (no keywords) modifiers may be used when declaring classes. All four of them can be applied to class members: fields, methods, etc.
* Use the most restrictive access level that makes sense for a particular member. Don’t make all members public.