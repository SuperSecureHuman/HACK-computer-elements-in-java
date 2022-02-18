# Logic Gates in java - Similar to Nand2Tetris

## This 'Just works'

---

I've just put together bunch of gates together and got the functionality.

Take a look at ALU file for knowing how gates are implemented

Nand2Tetris format

```java
CHIP(a=, b=, c=, out=out);
```

This repo version format

```java
int output = gate.CHIP(a,b);
int[] out = gate16.CHIP(a,b);
```

---

This additionaly has Carry Select Adder, with block size of 4. This is just supposed to be used for faster implementation of adder.

## Usage

Basic gates can be used like shown in the above example

The output of the ALU is in the following format

Its an array of array

    [ [output] , [zr] , [ng] ]

For the CPU, the output is again array of array

    [ [outM], [WriteM], [addressM], [pc] ]

---

## Known issues

Clocked chips dont work well(?)


---

This project was made for Object Oriented Programming course's term project.

## To Do stuff
Assuming that I will work on this after the course ends :sweat_smile:

---

* Get signed representation working
* Get clocked chips working
* Implement RAM and ROM chips (need clocked logic for this)
* Try making Hack computer (but without screen :rofl:)

---


## License
---

MIT (aka I dont care what you do with this)
