# Converting from decimal to binary
* There are two ways of doing this : **division** and **subtraction**

## 1. Division
* The only thing we need to be able to do is divide by 2 with a **remainder**
* For example : the number 42
- - - -
|			Quotient			|			   Remainder				|
- - - -
|				42				|				0					|
|				21				|				1					|
|				10				|				0					|
|				5				|				1					|
|				2				|				0					|
|				1				|				1					|
- - - -
Read the answer from the bottom
* The steps are as follows :
	* divide the number by 2
	* get the quotient for the next iteration
	* remember the remainder for the binary digit
	* repeat the steps until the quotient is equal to 0
	* write the remainders in the reverse order.

## 2. Subtraction
* Here’s the algorithm step-by-step:
	* make the list of all the powers of 2 that are smaller or equal to the number
	* subtract the biggest power from the number if it is possible
	* get the result for the next iteration
	* remember the 1 if you did the subtraction. If not, remember the 0
	* repeat the steps until the end of the list.
