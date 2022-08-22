# Decimal to binary: fractions

You already know how to convert integer decimal numbers to the binary number system. Now it's time to learn how to convert **decimal fractions** to the binary!

## 1. Fractions

But first, let's remember what a **fraction** is. A **fraction** is a number that represents any number of equal parts of a whole – for example, $\frac{1}{2}$, $\frac{3}{7}, $\frac{9}{5}$, $\frac{20}{13}$... Here, the number above the horizontal line (the **numerator**) tells us how many equal parts are there, and the number below (the **denominator**) represents how many parts make up a whole. In the example below, the number $\frac{3}{4}$ represents three fourths of a cake.

![dasd](https://ucarecdn.com/642a6027-a854-4f41-bfb2-7e3d0da7f987/)

Let's remember how fractions are written in the decimal number system. A **decimal fraction** is a fraction whose denominator is not written explicitly, but is implied to be a power of ten. The exact power is determined by the number of digits to the right of the **decimal point**.

For example, $\frac{3}{4}$ can be written in the decimal number system as $0.75$ (two digits after the decimal point), which is $\frac{75}{100}$, or $\frac{75}{10^2}$, or $75\cdot10^{-2}$,

$1$ (zero digits after the decimal point) is $\frac{1}{1}$, or $\frac{1}{10^0}$,

$0.5$ (one digit after the decimal point) is $\frac{5}{10}$, or $\frac{5}{10^1}$, or $5\cdot10^{-1}$,

$0.375$ (three digits after the decimal point) is $\frac{375}{1000}$, or $\frac{375}{10^3}$, or $375\cdot10^{-3}$, and so on...

Any decimal number consists of two parts – the **integer** part, which represents how many "whole" numbers are there and is written before the decimal point, and the **fractional** part, which is written after the decimal point. For example, for the number $15.375$ the integer part is $15$ and $0.375$ is the fractional.

Now, let's look at this big long decimal fraction more closely and we'll see that in the decimal number system, the fractional part of a number behaves exactly like its decimal part!

$15.375=1\cdot10^{1}+5\cdot10^{0}+3\cdot10^{-1}+7\cdot10^{-2}+5\cdot10^{-3}$

(Don't worry if you don't know what $10^{-1}$ is. **Negative exponents** are just a convenient way of writing: it means that the **base number** – in our case, $10$ – is on the different side of the fraction line. So, $10^{-1}$ means $\frac{1}{10^1}=\frac{1}{10}=0.1$, $10^{-2}$ is $\frac{1}{10^2}=\frac{1}{100}=0.01$, $10^{-3}$ is $\frac{1}{10^3}=\frac{1}{1000}=0.001$, and so on.)

The binary number system works exactly the same, except here, we use $2$ instead of 10 as a basе. Which part of a number is the integer part and which is the fractional part does not depend on a number system – you can count cakes in different ways, but the whole cake won't turn into a part of the cake if you change your way of counting.

And now, you almost know how to convert decimal fractions to the binary system! First, we convert the integer part of a decimal number to the binary (which you already know how to do), then we convert to the binary its fractional part (which is a little bit trickier, but similar), and finally, we combine both parts into one.

Let's try with our big long decimal fraction: $15.375$

## 2. Converting the integer part

The integer part is $15$. Let's divide $15$ by $2$ (using **integer division**) and store the **remainders** until the result is zero like we did previously.

| Quotient | 	Remainder |
| ----- | ----- |
| 15 // 2 = 7 ($15 = 2 ⋅\cdot⋅ 7 + 1$) | 	1 |
| 7 // 2 = 3 ($7 = 2 ⋅\cdot⋅ 3 + 1)$  |	1 |
| 3 // 2 = 1 ($3 = 2 ⋅\cdot⋅ 1 + 1)$  |	1 |
| 1 // 2 = 0 ($1 = 2 ⋅\cdot⋅ 0 + 1)$ | 	1 |

The resulting remainders array in **reverse order** will be our integer binary number. In our case, it's $1111$.

Or let's subtract the highest power of $2$ from $15$ until the result is zero. We start from the highest power of $2$ less than or equal to our number (in our case, it's $2^{3} = 8$). For each power of $2$, we write down $1$, if we can subtract it from our resulting number, and $0$ otherwise.

|8| 	4| 	2| 	1|
| -- | -- | -- | -- |
| 1  |	1 | 	1 | 	1 |

$15−8=7$

$7−4=3$

$3−2=1$

$1−1=0$

$15 = 8 + 4 + 2 + 1 = 1\cdot2^3+1\cdot2^2+1\cdot2^1+1\cdot2^0$

So, $15$ is $1111$ in the binary number system.

## 3. Converting the fractional part

But how to convert 0.3750.3750.375 to the binary system since we are dealing with fractions? The algorithm is almost the same. We **divide the fractional part of our number by** $2^{-1}$ (in other words, we **multiply it by $2$**) and store **integer** remainders until the fractional part of our resulting number is zero. Those remainders (**not** in the reverse order!) will be our binary fractional part, written after the decimal point. Let's try.

| Fractional part | 	Integer remainder |
| --------------- | --------------------- |
| $0.375 ⋅\cdot⋅ 2 = 0.75 	| 0.75 |
| $0.75 ⋅\cdot⋅ 2 = 1.5 | 1.5 |
| $1.5 - 1 = 0.5 <br> $0.5 ⋅\cdot⋅ 2 = 1$ |	1 |

- First, we multiply $0.375$ by $2$. $0.375\cdot2=0.75$, the integer part of the result is $0$, so we write down $0$;
- Then, we multiply $0.75$ by $2$. $0.75\cdot2=1.5$, the integer part of the result is $1$, so we write down $1$. For the next iteration, we will need only the fractional part of our resulting number, which is $1.5-1=0.5$;
- And last, we multiply $0.5$ by $2$. $0.5\cdot2=1$ – in other words, there is no fractional part left, so the algorithm stops here. The integer part of the result is $1$, which we write down.

So, $0.375$ in the binary number system is $0.011$. Here is the algorithm step-by-step:

- multiply the number by $2$;
- get the fractional part for the next iteration;
- remember the integer remainder for the binary digit;
- repeat the steps until the fractional part is equal to $0$;
- write the remainders in the non-reverse order.

Let's confirm our result with the second algorithm – **subtraction of powers of** $2$. But now we start from $2^{-1}$, and not from the highest power of $2$ less than or equal to our number.

| $2^{-1}=\frac{1}{2}=0.5$ | 	$2^{-2}=\frac{1}{4}=0.25$ | 	$2^{-3}=\frac{1}{8}=0.125$ |
| ---------------------------------------------- | ------------------------------------------------ | ------------ |
| 0 	| 1  | 	1 |

$0.375=0.25+0.125=0\cdot2^{-1}+1\cdot2^{-2}+1\cdot2^{-3}$

And our result $0.011$ is still correct. The second algorithm is identical to that for the integer part of a number, except now we must start subtraction from $2^{-1}$.

And finally, **we combine both parts of our resulting binary number**. $15.375$ in decimal is $1111+0.011=1111.011$ in binary.

## 4. Conclusion

Today we've learned how to convert decimal fractions to the binary number system. Turns out, converting fractions is not much more complicated than converting regular integer numbers. You just need to convert both decimal and fractional parts of a number separately and then combine them into a new binary number!
