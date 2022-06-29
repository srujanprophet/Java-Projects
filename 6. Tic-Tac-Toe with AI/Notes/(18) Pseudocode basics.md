# Pseudocode basics
As you already know, pseudocode is the way to show the structure of the algorithm without any pictures or explanations. Now, it is important to find out how our custom pseudocode looks like.

## 1. Variables and assigning
Note that every line in our algorithm is one action. Actions are performed sequentially.

Let's start learning our language with basic constructions such as **variables** and **assigning**. Look at the example below:

    a = 93

Here, we create a variable named `a` and assign an integer number `93` to it. The syntax is pretty simple: the name of the variable is on the left, the value is on the right, the assignment operator is in between. Let's look at some other examples:
```
b = 3.14
s = "Hello"
```
Here, we assign a floating-point number `3.14` to the variable `b` and the string `Hello` to the variable `s`. For simplicity, we don't use types: we don't declare that the variable `s` is a string or the variable `b` is a floating-point number.

Sometimes, there is a need to initialize several variables together. To do that, we will use the following syntax:
```
a = 3
b = "text"
c = 5.5
```
Here, the variable `a` is equal to `3`, the variable `b` is the string `text`, and the variable `c` is `5.5`.

If you need to change the value of a variable, you can assign a different value to it:
```
a = 3
a = 5
```
First, you assign `3` to the variable `a`. The next action assigns `5` to `a`. Hence, after this snippet `a` is equal to `5`.

Also, you can assign a value of one variable to another variable:
```
a = 1.5
b = a
```
First, you assign `1.5` to the variable `a`. The next action assigns the value of `a` to the variable `b`. After this snippet, `a` is equal to `1.5`, and `b` is also `1.5`.

## 2. Input and output data
In our algorithms, we will typically avoid input and output. When you describe how an algorithm works, it is irrelevant how you get the data and what happens next. However, if we need some external data, we will use this:
```
a = input() // a is a number
b = input() // b is a string
```
Note that we don't care about the input format. Besides, `a` and `b` can be not only numbers or strings. You can also read a table or a sequence of values. However, make sure to add a comment for the reader.

Some algorithms require sending data to the screen. We will use the following syntax for this task:
```
s = "Hello"
print(s)
```
Here, we assign a string `Hello` to the variable `s`. Then, in order to print it, we use the `print` keyword with the variable `s` in parentheses. Quite simple and natural.

## 3. Comments
Another important thing is how to write **comments**. A comment is not a part of a program, it's just a text you leave for yourself or other readers. We indicate comments with the `//`. For example:
```
// this is a comment
a = 10  // assigning 10 to the variable a
b = 42  // another assignment
```
You can write comments either on a separate line or right after statements.

## 4. Arithmetic operations
Almost any program requires processing **numerical data**. For that, we use arithmetic operations. In our pseudocode, they look like this:
```
a = 7
b = 2

sum = a + b   // addition, sum is equal to 9
dif = a - b   // subtraction, dif is equal to 5
 
prod = a * b  // multiplication, prod is equal to 14
quot = a / b  // division, quot is equal to 3.5
rem = a mod b   // modulo division, rem is equal to 1
quot_int = a div b // integer division, quot_int is equal to 3
```

To perform an arithmetic operation with two numbers, we write the first one on the left, the second one on the right, and the operator in between. If we want to assign the result to one of the variables, we use the following syntax:
```
a = 3
b = 5

a = a + b
a = a - b  
```
The same goes for multiplication and division.


## 5. Relational and logical operators
You can also use these relational operators in your pseudocode:
```
a == b // a equal to b
a != b // a is not equal to b
a < b  // a is less than b
a <= b // a is less or equal to b
a > b  // a is more than b
a >= b // a is more or equal to b
```

All these operations return `true` or `false`.

In case of a complex condition, you can use logical operators. The `and` returns `true` only if both conditions are true. The `or` returns `false` only if both conditions are false. The `not` just reverses a value. It works this way:
```
true and true == true
true and false == false
false and true == false
false and false == false

true or true == true
true or false == true
false or true == true
false or false == false

not true == false
not false == true
```

## 6. Conditional operators
Another commonly used type of construction is conditional operators. Let's have a look at an example:
```
a = 3

if a < 5 then
    print(a)
```

Here, we create a variable `a` and initialize it with a number `3`. Then, we check if `a` is less than `5` and if it is true, we print it to the screen. The syntax is clear: the `if` keyword is followed by a condition, and the next line gets executed only if the condition is true. If you need to combine several conditions, you can use `and`, `or`, and `not` operators:
```
a = 10 
b = 20

if (a == 10 and b == 20) or not (a == 20 and b == 10) then
    print(a)
    print(b) 
```
To avoid ambiguity, we may need to wrap the conditions into parentheses, like in the example above.

Now, you can put an `else` branch after the `if` condition. This branch gets executed if the condition is `false`. Below you can see an example with the `if-else` construction:
```
a = -3

if a > 0 then
    print("positive")
else:
    print("negative or zero") // prints this
```

Besides, you can use an `elif` branch. The operator `elif` is just an abbreviation for `else if`. The program checks this condition if the first one is false:
```
a = -5

if a > 0 then            // false
    print("positive")
elif a == 0 then        // checks this 
    print("zero")
else:
    print("negative")  // output
```
Here, we check whether `a` is more than 0, then we check whether it equals 0 using the `elif` branch, and finally we execute the last `else` branch. Below you can see the same code without the `elif` branch:
```
a = -5

if a > 0 then              
    print("positive")
else:
    if a == 0 then          
        print("zero")
    else:
        print("negative") 
```

## 7. Summary
In this topic, we started introducing one possible version of pseudocode. We considered such constructions as variables, assigning, arithmetic operations, and others. These basics are already enough to express some algorithmic ideas. However, they don't cover all the necessary concepts that some sophisticated algorithms might require.
