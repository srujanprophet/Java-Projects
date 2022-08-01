# Units of information
Each measurement requires an instrument and its own **unit of measurement**. For example, bodyweight is measured with scales in kilograms (or pounds), time is measured with clocks in seconds, etc. But how does one measure information?

## 1. Bit: the smallest unit of information
* The information entered into the computer should be specific and unambiguous. For a long time, people have used ciphers.
* The simplest and most convenient of them were digital. Any information from the name of the flowers to the days of the week can be presented in the form of numbers. When processed with a conventional computer, the data is encoded by numbers.
* They are represented by the electrical signals that the computer works with. For the convenience of distinguishing, signals of two levels are used in classic electronic computers.
* One of them corresponds to the number `1`, and the other to `0`. Any letter, sound, or image in the computer is represented by a set of numbers. 
* The numbers `1` and `0` are called **binary**. These are the symbols that make up the language understood and used by the computer. Any information in the computer is represented by binary digits: `1`, meaning, “**there is a signal**” and `0`, meaning “**no signal**”.
* Each digit of the machine binary code carries the amount of information equal to one bit. It can only take one of two values : either `1` or `0`. It is very inconvenient to measure information in bits because the numbers come out too big.

## 2. Byte: a sequence of eight bits
* The processing of the information takes place in the processor. This is a device that can work with several bits at once (8,16,32,64,…). The more bits of information are processed simultaneously, the faster the computer operation is.
* The first computers processed 8 bits of information simultaneously, so we needed a new unit of measurement, which was called a **byte (B)** that means **8 bits**.
* Bit marks are easily confused with byte marks. The abbreviations for bit numbers use the lowercase letter “**b**” while the bytes are capital “**B**”.

## 3. Large units of information
* The computer industry has historically used the units **kilobyte, megabyte** and **gigabyte** in at least two slightly different measurement systems which are slightly contradictory to each other.
	* The first one is a decimal-based system, which uses bytes in the powers of ten: **kilobyte**(10^3 bytes), **megabyte**(10^6 bytes), **gigabyte**(10^9 bytes) and so on. This units are used by the  [International System of Units](https://en.wikipedia.org/wiki/International_System_of_Units)  (SI).
	* The second one is a binary-based system which uses bytes in the powers of two: **kilobyte** (2^10 bytes), **megabyte** (2^20 bytes), **gigabyte** (2^30 bytes) and so on. This system was actively used to describe computer memory.
* To resolve this confusion, the  [International Electrotechnical Commission](https://en.wikipedia.org/wiki/International_Electrotechnical_Commission)  (IEC) suggested to use prefixes **kilo**, **mega** and **giga** only for the decimal-based system and to use new prefixes **kibi**, **mebi**, **gibi** for the binary-based system. Here **bi** means **bi**nary: **kibibyte** is **ki**lo **bi**nary **byte**.
* Here are two tables with commonly used units of information according to modern international standards.

~| **SI metric** | **Symbol** | **Powers of ten** |~
~| Kilobyte  	      | 	kB 	    	      | 10^3 B (1000 B)      |~
~| Megabyte	      | 	MB 	    	      | 10^6 B (1000 kB)    |~
~| Gigabyte  	      | 	GB 	    	      | 10^3 B (1000 MB)   |~
~| Terabyte  	      | 	TB 	    	      | 10^3 B (1000 GB)   |~
~| Petabyte  	      | 	PB 	    	      | 10^3 B (1000 TB)    |~ 
 
~| **IEC metric** | **Symbol** | **Powers of two**    |~
~| Kibibyte  	        | 	KiB 	    	 | 2^10 B (1024 B)          |~
~| Mebibyte	        | 	MiB 	 | 2^20 B (1024 kiB)       |~
~| Gibibyte  	        | 	GiB 	    	 | 2^30 B (1024 MiB)      |~
~| Tebibyte  	        | 	TiB 	    	 | 2^40 B (1024 GiB)      |~
~| Pebibyte  	        | 	PiB 	    	 | 2^50 B (1024 TiB)       |~ 

## 4. Measurement units conversion
* When we convert bigger units into smaller ones, we need to resort to an arithmetic operation called multiplication:
`1 GiB = 1 * 1024 * 1024 = 1048576 KiB`
* Accordingly, when we need to convert small units into big ones, we use the division.Converting 16384 bits to KiB:
`16384 bits = (16384 / 8) / 1024 = 2 KiB`
* To convert **1GB** to **kB**, multiply the number by a thousand twice :
`1 GB = 1 * 1000 * 1000 = 1000000 kB`
