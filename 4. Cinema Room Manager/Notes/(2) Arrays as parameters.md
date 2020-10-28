# Arrays as parameters
## 1. Passing arrays to methods
* A method can have parameters of any types including arrays, strings, primitive types and so on. For example, the method `processArray` has a single parameter of the type `int[]`:
`public static void processArray(int[] array) { /* do stuff */}`
* In the body of the method, we can process the input array in any way. 
* A parameter of an array type looks like a primitive type parameter. But there is one important difference related to the fact that an array is a reference type.
* When we pass a value of a primitive type to a method, copy of the value is created. When we pass an array to a method, a copy of the reference is created but the value is the same.
* It means, if we change the actual value (elements of an array) in the body of a method, we will see these changes outside the method.
* The following method swaps the first and the last elements of its parameter(array).
```java
public static void swapFirstAndLastElements(int[] nums) {
	if (nums.length < 1) {
		return; // it returns nothing, just exits
	}
	int temp = nums[nums.length-1];
	nums[nums.length-1] = nums[0];
	nums[0] = temp;
}
```
Calling the method from the main method:
```java
public static void main(String[] args) {
	int[] numbers = { 1,2,3,4,5};
	System.out.println(Arrays.toString(numbers));
	swapFirstandLastElements(numbers);
	System.out.println(Arrays.toString(numbers));
}
// The output is
// [1,2,3,4,5]
// [5,2,3,4,1]
```
So, in the body of the main method, an array is visible as modified.

## 2. Varargs
* It’s possible to pass an arbitrary number of the same type arguments to a method using the special syntax named **varargs (variable-length arguments)**. 
* These arguments are specified by three dots after the type. In the body of the method, we can process this parameter as a regular array of the specified type.
* The following method takes an integer **vararg** parameter and outputs the number of arguments in the standard output.
```java
public static void printNumberOfArguments(int... numbers) {
	System.out.println(numbers.length);
}

printNumberofArguments(1);
printNumberofArguments(1, 2);
printNumberofArguments(1, 2, 3);
printNumberofArguments(new int[] { });
printNumberofArguments(new int[] {1, 2});
// 1
// 2
// 3
// 0
// 2
```
This example also demonstrates the difference between the arguments and parameters of a method. The method has only a single parameter but it can be called with several arguments.

## 3. Varargs and other parameters
* If a method has more than one parameter, a `vararg` parameter must be the last parameter in the declaration of the method.
* Here is an incorrect example:
`public static void method(double... varargs, int a) { ### }`
The correct version of the method is:
`public static void method(int a, double... varargs) { ### }`
