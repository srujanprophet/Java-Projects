# Multiple constructors

Sometimes we need to initialize all fields of an object when creating it, but there are cases in which it might be appropriate to initialize only one or several fields. Fortunately, for this purpose, a class can have several constructors that assign values to the fields in different ways.

## 1. Constructor overloading
You can define as many constructors as you need. Each constructor should have a name that matches the class name but the parameters should be different. The situation when a class contains multiple constructors is known as **constructor overloading.**

Here is an example:

```java
public class Robot {
    String name;
    String model;

    public Robot() {
        this.name = "Anonymous";
        this.model = "Unknown";
    }

    public Robot(String name, String model) {
        this.name = name;
        this.model = model;
    }
}
```

The class `Robot` has two constructors:

- `Robot()` is a no-argument constructor that initializes fields with default values;
- `Robot(String name, String model)` takes two parameters and assigns them to the corresponding fields.

To create an instance of the class `Robot` we can use either of the two constructors:

```java
Robot anonymous = new Robot(); // name is "Anonymous", model is "Unknown"
Robot andrew = new Robot("Andrew", "NDR-114"); // name is "Andrew", model is "NDR-114"
```

> Bear in mind that you cannot define two constructors with the same number, types, and order of the parameters!

## 2. Invoking constructors from other constructors
We can also invoke a constructor from another one. It allows you to initialize one part of an object by one constructor and another part by another constructor.

Calling a constructor inside another one is done using `this`. For example:

    this(); // calls a no-argument constructor

If you called a constructor that has parameters you can pass some arguments:

    this("arg1", "arg2"); // calls a constructor with two string arguments

> Remember, the statement for invoking a constructor should be the first statement in the body of a caller constructor.

Here is an extended example of the `Robot` class:

```java
public class Robot {
    String name;
    String model;
    int lifetime;

    public Robot() {
        this.name = "Anonymous";
        this.model = "Unknown";
    }

    public Robot(String name, String model) {
        this(name, model, 20);
    }

    public Robot(String name, String model, int lifetime) {
        this.name = name;
        this.model = model;
        this.lifetime = lifetime;
    }
}
```

Now, the class has three constructors:

- `Robot()` is a no-argument constructor;
- `Robot(String name, String model)`` is a two-argument constructor that invokes another constructor;
- `Robot(String name, String model, int lifetime)` is a three-argument constructor that fills all fields.

The second constructor invokes the third one and passes `name`, `model`, and `lifetime = 20` to it. The third constructor, in its turn, initializes all fields of the created object.

Let's add an output to the third constructor and see the result:

```java
public Robot(String name, String model, int lifetime) {
    this.name = name;
    this.model = model;
    this.lifetime = lifetime;
    System.out.println("The third constructor is invoked");
}
```

Let's now create an instance using the two-argument constructor.

    Robot andrew = new Robot("Andrew", "NDR-114");

The program outputs:

    The third constructor is invoked
    
## 3. Conclusion
In this topic, we've covered constructor overloading — creating multiple constructors for the class. Constructor overloading allows us to create an object of the class in different ways depending on the circumstances.

We can also invoke constructors inside other constructors. All in all, Java provides many useful features for writing constructors and defining interactions between them.
