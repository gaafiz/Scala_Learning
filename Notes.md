## Programming Paradigms

### Impreative Programming

Focus on the flow of instructions to execute

Main characteristics:
* Modifying mutable cariables,
* Using assignments
* and control structures (e.g. if, else, loops, break, return)

Strong correspondence between programming logic and how the PC "works"
* mutable variables ~= memory cells
* Variable dereferences ~= load instructions
* Variable assignments ~= store instructions
* Control structures ~= jumps


### Functional Programming

Focus on functions, how functions can  be abstracted, produced, consumed and composed.

Main characteristics:
* Functions considered as values
* Enables construction of elegant programs that focus on functions
* No mutable variables.
* No usage or reduced usage of assignments, loops and other imperative control structures
* Functions can be defined anywhere (including inside other functions) 
* There exist sets of oprators to compose functions

Getting popular because
- Provide better modularity
- Parallel-programming-friendly


#  Scala

Born in 2003


#### For parallelism

* Collections: Parallel Collections and Distributed Collections
* Parallel DSLs

```scala
class Person(val name: String, val age: Int)
val people: Array[Person]

// To partition an array of people in 2 arrays of minors and adults
val (minors, adults) = people partition(_.age < 18)

// To do the same in parallel
val (minors, adults) = people.par partition(_.age < 18)
```

#### For Concurrency

* Actors:
	* message-oriebted programming for multi-threading
	* Serialize accss to shared resources using queues and function passing.
* Software transational memory
* Futures


#### Expression Resolution

aritmetic order + lazy naming resolution + function arguments resolution

aka substitution mode: the idea behind this model is that all evalutaion dows is reduce an expression to a value. This model is formalized in the lambda-calculus

```scala
// Expressions resolution example, step by step
(2 * pi) * radius
(2 * 3.14159) * radius
6.28318 * radius
6.28318 * 10
62.8318
```

Function arguments resolution can be done with 2 strategy call-by-value (default) and call-by-name.
See an example of resolution for both cases

```scala
// Default call-by-value resolution
def square(x: Double) = x * x
def sumOfSquares(x: Double, y: Double) = square(x) + square(y)

sumOfSquares(3, 2+2)
sumOfSquares(3, 4)
square(3) + square(4)
3 * 3 + square(4)
9 + square(4)
9 + 4 * 4
9 + 16
25

// Forced call-by-name resolution (=> symbol)
def square(x: => Double) = x * x
def sumOfSquares(x: => Double, y: => Double) = square(x) + square(y)

sumOfSquares(3, 2+2)
square(3) + square(2+2)
3 * 3 + square(2+2)
9 + square(2+2)
9 + (2 + 2) * (2 + 2)
9 + 4 * (2 + 2)
9 + 4 * 4
9 + 16
25
```

### Primitive types and Built-in types

* **Int**: 32-bit integers
* **Double**: 64-bit gloating point numbers
* **Boolean**
* **Byte**
* **Short**
* **Long**
* **Float**
* **String**


#### Conditional expression if-else

syntax similar to Java but in scala is an expression and not a statement with a logic similar to the Java ternary operator

```scala
def abs(x: Int) = if (x >= 0) x else -x
```

#### Functions

Return value is not rquired to be explicit, except in the case you are defining a recursive function

#### Blocks

A block is delimited by braces `{ }`  that can contains a set of instructions.
If the last instruction is an expression, that expression result would be the return value.
Everything defined inside, is not available outside

#### Tail recursion

Recursive functions are the key to write algorithms very in line with the Functional Programming paradingm.

Said that, there is a particular kind of recursion called Tail recusion that - in practice - is equally to a classic iterative loop in imperative programming in terms of performances and memory usage.

In general, if the last action of a function consists of calling a function (which may be the same), one stack frame would be sufficient for both functions. Such calls are called tail-calls.
In "normal" recusive functions, one additional stack frame needs to be used for each recursive step.

```scala
/*
 * This is an example of tail recursive function because
 * its last and only instruction is calling itself (gcd(b, a % b))
 */
def gcd(a: Int, b: Int): Int =
	if (b == 0) a else gcd(b, a % b)

/*
 * This is NOT a tail recursive function becaus, as last instruction,
 * it call itself AND make a multiplication stays pending
 * and can be resolved only afer the reslut of nested call is also resolved.
 */
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

/*
 * This is an example of how we can refactor the previous non tail recusive factorial
 * into a tail recusive version
 */
def tail_recursive_factorial(n: Int): Int = {
  // loop is tail recursive because its only last step is calling itself
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc else loop(acc * n, n - 1)

  loop(0, n)
}
```

There is one annotation to force defininf a function as a tail recursive one `@@tailrec`.
If this annotation is applied to a non tail recursive function, the compilation will fail.

#### Currying //TODO

When you need to define a function that uses some of his arguments to define an retrurn another function, you have 2 possible syntaxes you can use.

```scala
def applyOperation(x: Int, y: Int, op: (Int, Int) => Int) = op(x, y)

def sum(x, y) = applyOperation((x, y) => x + y, x, y)
def division(x, y) = sum((x, y) => x / y, x, y)

def applyOperation(op: (Int, Int) => Int): (Int, Int) => Int =
	def _applyOperation op(x, y) = op(x,y)
    _applyOperations

def sum = sum((x, y) => x + y)
def division = sum((x, y) => x / y)

def applyOperation(op: (Int, Int) => Int)(x: Int, y: Int) : Int =
	op(x, y)

def sum = sum((x, y) => x + y)
def division = sum((x, y) => x / y)
```

#### Function precedence

The rule of thumb is that function are evauluated from left to right.
However this is not true if the identifier (name) of a function starts with symbols.

The precedence of an operator is determined by its first character.
The following table lists the characters in increasing order of priority
precedence:
(all letters) -> lowest precedence
|
^
&
< >
= !
:
+ -
* / %
(all other special characters) -> highest precdence

### Class

```scala
class Rational(x: Int, y: Int) {
	def numer = x
    def dnom = y
}
```

This definition introducs 2 entities:
- A new type, named Rational
- A constructor Rational to create elements of this type

Class instantiation

```sscala
new Rational(3, 4)
```

