# Instance methods
## 1. Writing instance methods
* **Instance methods** represent a common behavior for a whole set of objects belonging to the same class. For example, in the following code, we declared a class `MyClass` with one instance method `print`:
```java
class MyClass {
    public void print() {
        System.out.println("method");
    }
}  
```
* The method is called an instance method because it doesn’t have the keyword `static` in its declaration. Instance methods correspond to a particular object of a class and can access its fields. For example :
```java
class MyClass {
    int field;
    public void print() {
        System.out.println(this.field);
    }
} 
```
* The keyword `this` represents a particular instance of the class `MyClass`. This keyword is optional, but very useful when it comes to managing objects of the class.
* What is important about instance methods is that they can take arguments and return values of any type including the same type as the defined class.

## 2. Calling instance methods
To call an instance method, we need to create an **object** of the class. For example, creating an instance of the class `MyClass` and calling the `print` method to:
```java
public static void main(String[] args) {
   MyClass object = new MyClass();
   object.field = 10;
   object.print(); // prints "10"
}
```
We defined the `print` method so that it prints the value of `field` of the object that called this method. The keyword `this` allows us to access the value of that particular object we’ve just created. Since we’ve defined the value of `field` for our object as 10, the code prints out 10 as well.

## 3. Cats
Considering a more difficult example of a class `Cat`.
	* Any cat has a name and a state (sleeping or not). A cat can say one of two phrases, **“meow”** or **“zzz**”, depending on its state. Sometimes, after saying **”meow”**, a cat falls asleep. However, it can be awakened by invoking the method `wakeUp`.
	* Here’s the code that corresponds to the class of cats that behave in this way. :
```java
/**
 * The class is a "blueprint" for cats
 */
class Cat {
    String name; // the cat's name
    boolean sleeping; // the current state of the cat (by default - false)
    /**
     * The cat says "meow" if it is not sleeping, otherwise it says "zzz".
     * After saying "meow" the cat can sometimes fall asleep.
     */
    public void say() {
        if (sleeping) {
            System.out.println("zzz");
        } else {
            System.out.println("meow");
            if (Math.random() > 0.5) {
                sleeping = true;
            }
        }
    }
    /**
     * This method wakes the cat up.
     */
    public void wakeUp() {
        sleeping = false;
    }
} 
```
	* Now, we can create an instance of this class and invoke its methods.
```java
public class CatsDemo {
    public static void main(String[] args) {
        Cat pharaoh = new Cat(); // an instance named "pharaoh"
        pharaoh.name = "pharaoh";
        for (int i = 0; i < 5; i++) {
            pharaoh.say(); // it says "meow" or "zzz"
        }
        pharaoh.wakeUp(); // invoking the instance method
        pharaoh.say();
    }
} 
```
	* The program’s output can be different because we use `Math.random()` inside the `say` method. Here is an example of the output:
```
meow
meow
meow
zzz
zzz
meow 
```

To sum it all up, instance methods allow programmers to manipulate particular objects of a class. They can access the fields of the class with this keyword, but it is optional. Instance methods are a great way to work with many objects of our classes!
