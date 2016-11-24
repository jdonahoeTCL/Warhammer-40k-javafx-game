###Design Patterns


The Unit class uses the proxy design pattern. It uses a circle object to represent a unit, and that unit's current status. The reason it's proxy is because the circle can be moved on the screen - but the actual unit that the circle represents has no reference to a position.


Turn manager has a memento pattern - becaue turn and phase data members remain encapsulated. The design pattern for our classes can be described by looking at Memento's specific classifications. Relative to our classes, 'caretaker' would be the window class, the originator would be the turn manager class, and  memento would be the methods that handle turns, phases, etc.