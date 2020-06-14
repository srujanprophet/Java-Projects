# Naming variables
## 1. Why is naming important ?
* Every variable has a name that uniquely identifies it among other variables.
* Giving a good name to a variable may not be as simple as it seems.
* Experienced programmers put a lot of care into naming to make their programs easy to understand. 
* It is important because programmers spend much time on reading and understanding code written by other programmers. 
* If variables have bad names, even your own code will seem unclear to you in a few months.
* There are two sets of rules that restrict the possible names for variables.

## 2. Rules for naming variables
Java has some rules for naming variables:
	* names are case-sensitive;
	* a name can include  [Unicode](https://en.wikipedia.org/wiki/Unicode)  letters, digits, and two special characters (`$`,   `_`);
	* a name cannot start with a digit;
	* a name must not be a keyword (`class`, `static`, `int` are illegal names).
	* Some valid names of variables are:
```java
number, $ident, bigValue, _val, abc, k, var 
```
	* Here are some invalid ones:
```java
@ab, 1c, !ab, class
```

## 3. Naming conventions for variables
Also, there are the following conventions for naming variables : 
	* if a variable name is a single word it should be in lowercase (for instance: `number`, `price`);
	* if a variable name includes multiple words it should be in `lowerCamelCase`, i.e. the first word should be in lowercase and each word after the first should have its first letter written in uppercase (for instance: `numberOfCoins`);
	* variable names should not start with `_` and `$` characters, although they are allowed;
	* choose a name that makes sense, e.g. `score` makes more sense than `s`, although they are both valid.

