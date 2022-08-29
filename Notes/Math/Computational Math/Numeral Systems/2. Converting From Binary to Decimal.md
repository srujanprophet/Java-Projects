# Converting from binary to decimal
## 1. Binary Post Office
Binary Number = 1 0 0 1 1 0 0 0
- - - -
1   		|	0		|	0	|	1	|	1	|	0	|	0	| 	0	|
- - - -
128 		|	64		|	32	|	16	|	8	|	4	|	2	|	1	|

## 2. The formal method
* To choose the correct powers of two, we can multiply the binary digits to the corresponding powers:
1 * 128 + 0 * 64 + 0 * 32 + 1 * 16 + 1 * 8 + 0 * 4 + 0 * 2 + 0 * 1 = 152
* The steps are as follows :
	* write down the binary number
	* list the powers of 2 from right to left
	* highlight the powers that correspond to the “1” in the initial binary number;
	* add the highlighted values.
	