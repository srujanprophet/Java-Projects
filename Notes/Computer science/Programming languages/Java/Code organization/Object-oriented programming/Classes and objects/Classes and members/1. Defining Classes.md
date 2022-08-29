# Defining classes
* When programmers are writing a real program, they use standard classes as building blocks. However, they often need to declare new program-specific classes to better represent the domain area. 

## 1. Declaring new classes
* A new class is declared with the `class` keyword followed by the name of the class. For example, this is how we would create a class named Nothing:
```java
	class Nothing {
		// empty body
	} 
```
* A class body can include fields, methods, and constructors. **Fields** store data, **methods** define behavior and **constructors** allow us to create and initialize new objects of the class. 
* Fields and methods are considered to be class members. Not all Java classes have fields and methods so sometimes we will see classes without them.
* The source code of a class is placed in a `.java` file. Usually, a source code file contains only one class and has the same name as that class, but sometimes a file can contain more classes.

## 2. Writing fields
* A **field** is a variable that stores data. It may have any type, including primitive types (int, float, boolean and so on) and classes (even the same class). A class can have as many fields as we need.
E.g. declaring a class Patient:
```java
/**
 * The class is a "blueprint" patients
 */
class Patient {
    String name;
    int age;
    float height;
    String[] complaints;
}
```
This class represents a patient in a hospital information system. It has four fields for storing important information about the patient: `name`, `age`, `height`, and `complaints`. All objects of the class Patient have the same fields, but their values are different for each object.

## 3. Creating objects
* For creating an **instance** of the class `Patient` using the keyword **new** :
`Patient patient = new Patient();`
* When we create a new object, each field is initialized with the default value of the corresponding type.
```java
System.out.println(patient.name); // it prints null
System.out.println(patient.age); // it prints 0
```

## 4. Creating multiple objects of the same class
The following program creates two objects of the class `Patient` and prints the information about them. Both classes are placed in the same file named `PatientDemo.java`.
```java
public class PatientDemo {    
    public static void main(String args[]) {        
        Patient john = new Patient();        
        john.name = "John";
        john.age = 30;
        john.height = 180;        
        System.out.println(john.name + " " + john.age + " " + john.height);            
        Patient alice = new Patient(); 
        alice.name = "Alice";
        alice.age = 22;
        alice.height = 165;        
        System.out.println(alice.name + " " + alice.age + " " + alice.height);
    }
}
 
class Patient { 
    String name;
    int age;
    float height;
}
```
In the code above, we’ve created two patients, John and Alice, defined the values of their fields and then printed out the information about them. So, the output of the code above is:
`John 30 180`
`Alice 22 165`

## 5. Summary
* Custom classes can be very useful because they allow us to define fields and methods that work best for our purposes.
* Fields keep the current state (data) of the instances of the class and their values can be different for different instances. 
* We can create objects of the class, assign values to their fields and use those objects in our programs. 
* All in all, classes are a very powerful tool.