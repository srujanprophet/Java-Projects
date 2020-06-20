# Constructor
**Constructors** are special methods that initialize a **new object** of the class. A constructor of a class is invoked when an instance is created using the keyword `new`.
A constructor is different from other methods in that:
	* it has the same name as the class that contains it;
	* it has no return type (not even void).
Constructors initialize **instances** (objects) of the class. They set values to the fields when the object is created. Also, constructors can take parameters for initializing fields by the given values.

## 1. Using constructors
Here is a class named `Patient`. An object of the class has a name, an age, and a height. The class has a three-argument constructor to initialize objects with specific values.
```java
class Patient {
    String name;
    int age;
    float height;
    public Patient(String name, int age, float height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
```
The `Patient` constructor takes three parameters. To initialize the fields, the keyword `this` is used. It’s a reference to the current instance of the class. This keyword is required only if the parameters of the constructor have the same name as the fields of the class (to separate them).
Creating some instances of the class using the constructor above:
```java
Patient patient1 = new Patient("Heinrich", 40, 182.0f);
Patient patient2 = new Patient("Mary", 33, 171.5f);
```
Now we have two patients, Heinrich and Mary, with the same fields, but the values of those fields are different.

## 2. Default and no-argument constructor
* The compiler automatically provides a **default no-argument constructor** for any class without constructors.
```java
class Patient {
    String name;
    int age;
    float height;
}
```
* We can create an instance of the class Patient using the no-argument default constructor:
`Patient patient = new Patient();`
In this case, all fields will be filled with the default values of their types.
* If we define a specific constructor, the default constructor will not be created.
* We can also define a constructor without any arguments, but use it to set default values for fields of a class. For example, we can initialize name with “Unknown”:
```java
class Patient {
    String name;
    int age;
    float height;
    public Patient() {
        this.name = "Unknown";
    }
}
```
Such no-argument constructors are useful in cases when any default value is better than `null`.

## 3. To sum up
* Any Java class has a constructor to initialize objects;
* A constructor has the same name as the class containing it;
* A constructor has no return type, not even `void`;
* If a class has no explicit constructors, the Java compiler automatically provides a default no-argument constructor.