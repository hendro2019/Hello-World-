# MultiGreeter
Description:
The classic “HelloWorld” program is a simple program used to illustrate the basic syntax of a programming language. In its simplest form,
the program displays the text “Hello, World!” to the user. It can serve as a great starting point to explore and learn more
complex concepts.

Assignment:
Create a MultiGreeter class with the following capabilities:

MultiGreeter()
No-argument constructor; creates a MultiGreeter with maxGreetings = 1

MultiGreeter(int maxGreetings)
Creates a greeter that can hold up to maxGreetings greeting strings.
Precondition: 0 < maxGreetings <= 255

Methods

getMaxGreetings() : int
Returns the value maxGreetings, the maximum number of greetings this Greeter can hold

getNumGreetings(): int
Returns the number of greetings added to this MultiGreeter.

add(String greeting) : boolean
If Greeter already has maxGreetings added, the greeting will not be added and the method will return false; otherwise the method will add the given greeting to its collection of greetings and return true.

getGreetings(): String []
Returns an array containing the greeting strings added to this Greeter in no particular order whose length is equal to the number of greetings added.

greet(String name) : String
Returns a salutation in the form “greetingString, name!”, where greetingString is one of the greeting strings added to the Greeter picked at random
If no greetings were added to this MultiGreeter, uses the default greeting of “Hello”
name – a provided name.

greet() : String
Returns a salutation in the form “greetingString, World!”, where greetingString is one of the greeting strings added to the Greeter picked at random
If no greetings were added to this MultiGreeter, uses the default greeting of “Hello”.

