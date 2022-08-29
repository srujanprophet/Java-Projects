# Hexadecimal Numbers
HEX is an alternative way to represent numbers.

## 1. Where did it come from?
* For convenience, engineers working with computers tend to group bits. In the 1960s, they would group 3 bits at a time.
*  As computers got bigger, it became more convenient to cluster bits by four instead of three. This doubles the number that the symbol would represent; it then can have 16 values instead of eight.
* _**Hex**_ means 6, and _**decimal**_ is 10, so it was called hexadecimal. It is more compact than decimal and binary.

## 2. Hex and other numeral systems
* HEX is widely used in computer science. It is because we can easily translate binary numbers into HEX as 16 is 2^4.
- - - -
| 	   **Binary**		|		**Decimal**		| 	     Hexadecimal		|
- - - -
| 	       0000		|		         0			| 	    		0			|
| 	       0001		|		         1			| 	    		1			|
| 	       0010		|		         2			| 	    		2			|
| 	       0011		|		         3			| 	    		3			|
| 	       0100		|		         4			| 	    		4			|
| 	       0101		|		         5			| 	    		5			|
| 	       0110		|		         6			| 	    		6			|
| 	       0111		|		         7			| 	    		7			|
| 	       1000		|		         8			| 	    		8			|
| 	       1001		|		         9			| 	    		9			|
| 	       1010		|		         10			| 	    		A			|
| 	       1011		|		         11			| 	    		B			|
| 	       1100		|		         12			| 	    		C			|
| 	       1101		|		         13			| 	    		D			|
| 	       1110		|		         14			| 	    		E			|
| 	       1111		|		         15			| 	    		F			|
- - - -
* To avoid confusion we include writing a HEX number with `h` after it or `0x` before it.

## 3. Converting binary numbers to HEX and vice versa
* We can split a HEX number into a 4-digit sequence, starting from the end, and then check it with the table above. For example, 1110011001110001:
	1110 	0110	0111	0001 	= 	E	6	7	1 
* In case the digits of a number cannot be completely divided into groups of four, the necessary number of zeros is written in front of the first digits:
	101100	=	10	1100	=	0010	1100	=	2	C
* Converting HEX into a binary system is even simpler. Each character in a hexadecimal number record corresponds to four characters in binary writing. 
	B	E	=	1011	1110	= 	10111110

## 4. Usage of HEX
* We use the hexadecimal system to record error codes during the work of various software products. For example, operating system errors are encoded in this way.
* Besides, in URLS, character codes are written as hexadecimal pairs prefixed with `%`.  If we google, the symbol `@`, the link in the address bar is :
	`https://www.google.com/search?q=%40`
* The HEX numbers are also used for writing programs in low-level languages and in some encodings. For example, in **Unicode** ( a computer standard for symbols encoding ), every symbol is represented as a hexadecimal number.
* Even color schemes are encoded by HEX numbers. Thus, in **RGB** encoding, every color can be represented as 3 hexadecimal numbers.