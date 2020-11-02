# Objects
* Each object is an instance of a particular class (type) that defines common properties and possible behavior for its objects.
* All classes from the standard library (`String`, `Date`) and classes defined by programmers are **reference types** which means that variables of these types store addresses where the actual objects are located.
* In this regard, the comparison and assignment operations work with objects differently than with primitive types.

## 1. Creating objects
 * The keyword **new** creates an object of a particular class. 
 `String str = new String("Hello");`
The variable `str` stores a reference to the object **”hello”** located somewhere in the heap memory.
* In the same way, we can create an object of any class we know.
```java
class Patient {
	String name;
	int age;
}
Patient patient = new Patient();
```

## 2. Immutability of objects
* Immutability means that an object always stores the same values. If we need to modify these values, we should create a new object.
* The common example is the standard `String` class. Strings are immutable objects so all string operations produce a new string. 
* Immutable types allow us to write programs with fewer errors.

## 3. Sharing references
* More than one variable can refer to the same object 
```java
Patient patient = new Patient();
patient.name = "Mary";
patient.age = 24;
System.out.println(patient.name+" "+patient.age); // Mary 24
Patient p = patient;
System.out.println(p.name+" "+p.age); // Mary 24
```
* Two variables refer to the same data in memory rather than two independent copies. Since our class is mutable, we can modify the object using both references.
`patient.age = 25;`
`System.out.println(p.age); // 25`

## 4. Nullability
* As for any reference types, a variable of a class-type can be **null** which means it is not initialized yet.
`Patient patient = null;`

## 5. Conclusion
* Classes defined by programmers are **reference types**. When objects are created by the **new** operator it returns reference in memory where the created objects are located.
* By this reference, we can get access to its fields and change them. Several variables can refer to the same object through a reference.
* It is also possible to create two independent objects with the same field’s content. Reference to such objects are different.
* However, not all objects allow changing its state after creation. Such a feature is called **immutability**.