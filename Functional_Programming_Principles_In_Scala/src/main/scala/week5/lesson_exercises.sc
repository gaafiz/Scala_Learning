// Lesson 5.4

var expected: Object = null
var result: Object = null

// Exercise 1: Write a function "pack"
/*
 * Given:
 *    pack(List("a", "a", "a", "b", "c", "c", "a"))
 * Returns:
 *    List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
 */
var sampleArg = List("a", "a", "a", "b", "c", "c", "a")
expected = List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (ys, tail) = xs.span( y => y == x)
    ys :: pack(tail)
}

result = pack(sampleArg)
assert(expected == result)
println("Lesson 5.4 - Exercise 1: passed")


// Exercise 2: Write a function "encode"
/*
 * Given:
 *    encode(List("a", "a", "a", "b", "c", "c", "a"))
 * Returns:
 *    List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
 */

sampleArg = List("a", "a", "a", "b", "c", "c", "a")
expected = List(("a", 3), ("b", 1), ("c", 2), ("a", 1))

def encode[T](xs: List[T]): List[(T, Int)] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (ys, tail) = xs.span( y => y == x)
    (x, ys.length) :: encode(tail)
}

def encodeWithPack[T](xs: List[T]): List[(T, Int)] = pack(xs) map (l => (l.head, l.length))

result = encode(sampleArg)
assert(expected == result)
result = encodeWithPack(sampleArg)
assert(expected == result)
println("Lesson 5.4 - Exercise 2: passed")