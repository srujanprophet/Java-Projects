# Stack

## 1. Stack essentials
A **stack** is an abstract data type where elements are inserted and removed according to the **last-in-first-out (LIFO)** principle. The **push** operation inserts an item at the top of the stack, the **pop** operation removes the top item from the stack. Access to arbitrary elements is restricted. As a rule, a stack also supports the **peek** operation that just returns the current top element. In some cases, it may also be useful to check whether the stack is empty or what is its size, so these operations should also be supported.

The following image demonstrates the basic mechanism:

![stack](https://ucarecdn.com/7a995b9c-41db-4e90-abed-86897e1d98f0/)

Here, element **1** was added first and will be removed last, while element **5** was added last and it's the first to be removed.

The underlying data structure to implement a stack can be an array or a linked list with restricted access to its elements.

## 2. Stacks in real-life and programming

The simplest real-life example is a stack of books. Only a book placed at the top can be removed, and a new book is always added to the top of the stack.

![stack](https://ucarecdn.com/d4e6eb22-3e97-4f9e-ad40-f6f8a8738223/)

You can also imagine it as a stack of plates or a pistol magazine. Also, you might have seen the [StackOverflow](https://s3.amazonaws.com/media.eremedia.com/uploads/2012/08/24111405/stackoverflow-logo-700x467.png) logo before.

In programming, stacks are used to:

- evaluate arithmetic expressions;
- store arguments of functions and result of the functions' calls;
- reverse the order of elements.

## 3. The efficiency of stacks
If you use a linked list or a classic array (non-resizable) as an internal structure, both **push** and **pop** operations always take constant O(1) time. It does not depend on how many elements there are in the stack, so the operations are very quick.
