# YASEL
Yet Another Stack-Based Eso-Lang

## Introduction
YASEL is an Esoteric Stack-Based Programming Language. It is untyped
and instructions are always a singular character. Any Character which
is not in the instruction set is regarded as a Comment.

### Hello World in YASEL
```
*     Create new Entry in Stack for operation
++++  Start with 4
'     Stash
"     Copy Stash
&     Merge      8
'     Stash
"     Copy Stash
&     Merge      16
'     Stash
"     Copy Stash
&     Merge      32
'     Stash
*     New Stack Entry (We want to keep the 32, as it is the SPACE character)
"     Copy Stash
&     Merge      64
++++++++         72 (H)
%
---              69 (E)
%
+++++++          76 (L)
%%
+++
%                79 (O)
"%#              32 (Space)
++++++++         87 (W)
%
--------         79 (O)
%
+++              82 (R)
%
------           76 (L)
%
--------         68 (D)
%
"+%              33 (Exclamation)
#* ++++++++++ %  10 (LineFeed)
```

## Statements
### Conditionals
-  `>` Value larger than
-  `<` Value smaller than
-  `=` Value equal to <br>
   If the Conditional is true, the program continues
   to the next instruction, if not it jumps to the
   last "Jump" Point (if none exists it goes to the start).
   Comparisons are always made with the top two values of
   the stack, where the top value is placed to the left 
   of the operator and the second to the right.

### Jumps:
-  `:` Jump Point
-  `!` Jump to last Jump Point
  
### Data/IO:
- `&` Add top of stack with buffer
- `+` Increment top of stack
- `-` Decrement top of stack
- `#` Void value on top of stack
- `'` Stash top value to temporary buffer
- `"` Push value from temporary buffer to Stack
- `*` New value on top of stack (is 0)
- `~` User Input (Written as multiple bytes to stack)
- `%` Prints top of stack to console (ASCII encoded, Value remains)

## License
Copyright (c) 2022, Felix Eckert 

Permission to use, copy, modify, and/or distribute this software for any 
purpose with or without fee is hereby granted, provided that the above 
copyright notice and this permission notice appear in all copies.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
