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

### Primitive types

* **Int**: 32-bit integers
* **Double**: 64-bit gloating point numbers
* **Boolean**

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

TODO lesson 7