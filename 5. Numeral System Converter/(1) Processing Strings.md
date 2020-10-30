# Processing Strings
## 1. Strings and arrays
* It’s possible to convert between strings and character arrays using special methods like `valueOf()` or `toCharArray()`:
```java
char[] chars = {'A','B','C','D','E','F'};
String stringFromChars = String.valueOf(chars); // "ABCDEF"
char[] charsFromString = stringFromChars.toCharArray(); 
// {'A','B','C','D','E','F'}
String theSameString = new String(charsFromString); // "ABCDEF"
```
* There’s another way to turn a string into an array:
```java
String text = "Hello";
String[] parts = text.split(""); // {"H","e","l","l","o"}
```
Here, we used a much more concise method that _**splits**_ a string into parts.

## 2. Splitting the string
* A string can be separated by delimiters to an array of strings. To perform this, we call the method `split`, it divides a string into substrings by a **separator**. 
* If the delimiter is specified, the method returns an array of all the substrings and, notably, the delimiter itself is not included in any of the substrings:
```java
String sentence = "a long text";
String[] words = sentence.split(" "); 
// {"a", "long", "text"}
```
* Splitting an American phone number into country code, area code, central office code, and other remaining digits :
```java
String number = "+1-213-345-6789";
String[] parts = number.split("-"); 
// {"+1", "213", "345", "6789"}
```
* The `split` method is also good to get rid of something we don’t need or don’t want to use.

## 3. Iterating over a string
* It’s possible to iterate over characters of a string using a loop (**while, do- while, for-loop).** For example.
```java
String scientistName = "Albert Einstein";
for(int i=0; i < scientitsName.length(); i++) {
	System.out.println(scientistName.charAt(i) + " "); 
}
// A l b e r t  E i n s t e i n
```

## 4. Conclusion
* There are various methods to convert a string like `valueOf()`. `toCharArray()`. `split()`.
* We may also iterate over characters of a string in a loop.