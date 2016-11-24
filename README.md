## Synopsis

A warhammer40k based turn-based Game, where the objective is to destroy all enemy units.


## Installation

To install the game all you need is the files within this git repository, just clone and run the startgame.bat file… to install this way you must have your path environment ready: please follow this handy guide- http://docs.oracle.com/javase/7/docs/webnotes/install/windows/jdk-installation-windows.html .  Alternatively, a .jar file is provided.

## API Reference

Please use I-D-40K/Docs/javadoc/Index.html to view auto generated documentation. 

## Tests

Please see testing.md in the docs section

## License

Copyright (c) 2016 Joshua Donahoe, Ryan Silver, Aliasghar Amiri	

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE 
OR OTHER DEALINGS IN THE SOFTWARE.

## How To Play

To start a game run the start game.bat file it will compile and launch the game.

To move a unit, click on it during the movement phase during your turn, a yellow circle should appear.
click within the yellow circle to move the unit.

to shoot, click on a friendly unit in range of an enemy unit during the shooting phase, then click on the enemy unit (during the same phase) and the friendly will automatically shoot if it is in range. 

To charge, click on a friendly unit during the assault phase of your turn, then click on an enemy unit during the same phase. Some calculations will be made. Beware though that your enemy can shoot at your charging units during your turn! And what’s more they can fight back in close combat!

Click the next phase button to change phases from movement to shooting to assault.

the pass turn button changes the turn over to the opponent.

