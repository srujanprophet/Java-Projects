# Array Exceptions
## 1. NullPointerException
* An array is a reference type, which means its variable can be `null`, and that may lead to NPE.
`int[] numbers = null;`
`int size = numbers.length; // It throws NPE`
* Can be solved using additional checks in the code:
`int size = numbers == null ? 0 : numbers.length`

## 2. NegativeArraySizeException
* If we try to create an array with a negative size, our code will compile successfully, but the line will throw `NegativeArraySizeException` while executing
`int negSize = -1;`
`int[] numbers = new int[negSize]; // an exception here`
* To avoid it, simply do not use variables that can have a negative size when setting the size of an array.

## 3. ArrayIndexOutOfBoundsException
* It is caused by attempting to access a non-existent element of the array.
```java
int[] array = {1,2,3}; 
int n1 = array[2]; // n1 is 3
int n2 = array[3]; // Exception
```
* The code will throw the same exception if we try to access an element with a negative index.
* Since a string can be considered as a sequence of characters, a similar exception may occur when accessing a non-existing element of a string. It is called `StringIndexOutOfBoundsException`.
* To avoid `ArrayIndexOutOfBoundsException`, we may check if the given index belongs to the interval [0, length - 1].