# This 'Just works'

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

## Known issues

Clocked chips dont work well(?)

* I am not exactly sure why PC outputs other values. I just ported the HDL code from nand2tetris into java. The output of CPU works fine. (unless it is supposed to be negative, see next issue)

This dosent follow signed bit representation (but Nand2Tetris, takes signed bit by default for multibit stuff. You effecively have only 15bits to work with, and one bit is left for sign)

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
