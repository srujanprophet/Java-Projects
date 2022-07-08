# Fixed-size array

In programs, data is represented in the form of numbers, characters, strings, or other more complex objects. Often, some of these objects can be naturally grouped together. For example, assume that you conducted an experiment and got some measurements. They might correspond to temperature, distance, time, or something else. In such a case, it would be convenient not to store each measurement as a separate variable, but to process all of them together as a single unit. This will neatly organize our experimental observations, allowing us to analyze them quickly.

To efficiently deal with such cases, most programming languages provide a structure called a **fixed-size array**. The structure allows us to sequentially store a collection of elements of the same type and process them as a single unit.


## 1. Fixed-size array
A fixed-size array is a structure for storing a collection of elements of the same type. As you can guess from its name, the size of such an array is a constant: once an array is created, you can't change its size. While creating a fixed-size array, we declare its size. The computer then reserves necessary memory resources for the array. After that, the elements of a fixed-size array are stored sequentially into those memory addresses. Given below is an example of a fixed-size array that stores five floating-point numbers:

![image alt](https://ucarecdn.com/d6e5ef24-16b9-400e-a72a-69bd4cf72562/)

An array isn't limited to storing numeric values only. We can also store a list of strings in it. Like this one containing some flower names:

![image alt](https://ucarecdn.com/eb53a334-128d-4ffc-89d2-dde54150707f/)

Arrays have some technical characteristics. To begin with, the **size** of an array indicates how many elements the array contains. It is also referred to as the **length** of an array. The length of both of our previous arrays is 5.

The **index** of an element is a number that tells us where the element resides within the array. For most programming languages, the counting starts at $0$. The first element of the first array is $10.8$ and its index is $0$, the second one is $14.3$ with the index of $1$. The last element is $9.7$ with the index of $4$. The same rule applies to the second array as well.

Using pseudocode, we can represent the first array as follows:

    measurements = [10.8, 14.3, 13.5, 12.1, 9.7]

A variable named $measurements$ combines the numbers in a single unit.


## 2. Accessing elements
Programming languages provide a set of standard methods for array processing. There is one of them used most frequently. It is a method for accessing an element by its index. Let's try and access the third element of the *measurement* array and store it in a new variable *value*.

![image alt](https://ucarecdn.com/e014e735-c890-4285-bcce-f82607576c4c/)

The $value$ now contains $13.5$.

Take notice that we can not only read, but also modify elements of an array:

    measurements[2] = 3.7

Now, the array looks like this:

![image alt](https://ucarecdn.com/af7d5a02-ccba-487a-9fe1-d5ca800987de/)

Both reading and modifying operations require $O(1)$ time complexity. It's so efficient, because by knowing the index number, the computer can jump directly to the required memory address and fetch or modify the data.


## 3. Inserting and deleting elements

In short, inserting an element into a fixed-size array or deleting an element from the array is not possible. This is mainly because those operations would change the length of the array and it would no longer be a fixed-size array.

Still, you may want to add one more flower named $Daisy$ to the array of flowers mentioned earlier. There's a way to do so! After inserting, the length of our new array will be $6$. Thus, you need to create another array with the length $6$, and copy all the five elements from the first array to the new array. There will be a spot left in your new array. Fill it up with the new flower name. You can do the same trick for deleting an element as well.

![image alt](https://ucarecdn.com/8665d7c9-d947-43e6-83d6-0b50feb61506/)

This operation requires $O(n)$ time complexity, where $n$ is the number of elements of the array, since we have to copy all $n$ elements to our new array. In sense of performance, inserting and deleting are very slow operations for a fixed-size array. To overcome this limitation, programmers have introduced **dynamic arrays**.

On the flip side, the inability to modify the size is a strong characteristic of a fixed-size array. Nothing can affect our array's length. In the example above, we've added a new flower name to the array, but still, our old array remains as it is. Thus, it is wise to use a fixed-size array when changing the array length may negatively affect your program.

Along with these operations, there are some other more sophisticated methods for array processing, such as sorting, reversing, searching elements, and others. When you use a particular programming language, check the documentation of the standard library to see what methods the language provides.


## 4. Example
Let's consider a simple example of how to process arrays. Given an array of numbers, our task will be to calculate the mean value of the elements in the array. The mean of the array elements is the sum of all array elements divided by their number. We will consider how it can be done for our array of measurements:

    measurements = [10.8, 14.3, 13.5, 12.1, 9.7]

The procedure is the following:

We initialize the variable $sum$ with the value $0$. Then, we sequentially read the elements of the $measurement$ array using the index numbers from zero up to the array length minus one, which is the index of the last element, and add them to the $sum$ variable. After that, we divide the obtained sum by the length of the array and thus get the mean value for the elements. The length of the array of measurements is known in advance.

Here is the pseudocode of the process:
```
sum = 0

for i from 0 to (len(measurements)- 1):
    sum = sum + measurements[i]

mean = sum / len(measurements) # 12.08
```

Here, $len(measurements)$ will return the length of the measurements array. 

## 5. Conclusion
The array data structure is widely used in programming. A fixed-size array allows us to store a collection of elements of the same type. The most frequently used method of array processing is accessing an element by its index. Not all array methods are efficient for a fixed-size array, but still, we can use them to our advantage. Since an array is a collection of data of the same type, processing it is easy and intuitive. Without this data structure, we would have to declare a new variable for every value in a list, which would result in a complex program and require much more storage.

To get information about other array methods, check the standard library of a programming language you use. Use a fixed-size array if you need to process a collection of data of a similar type and you know the number of values in advance.
