package week2

object LessonsExercises extends App {

  // Lesson 2.1
  {
    // Make a tail-recursive version of this function
    def sum(f: Int => Int, a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sum(f, a + 1, b)

    // Solution
    def sum_tailrec(f: Int => Int, a: Int, b: Int): Int = {
      def loop(a: Int, acc: Int): Int = {
        if (a > b) acc
        else loop(a+1, acc + f(a))
      }
      loop(a, 0)
    }
  }


  // Lesson 2.3
  {
    // Find a fixed point for a function by iterative approximations.
    // A fixed point is that x that makes true the following: f(x) = x

    def abs(x: Double) = if (x < 0) -x else x

    val tolerance = 0.0001

    def isCloseEnough(x: Double, y: Double) =
      abs((x - y) / x) / x < tolerance

    def fixedPoint(f: Double => Double)(firstGuess: Double) = {
      def iterate(guess: Double): Double = {
        val next = f(guess)
        if (isCloseEnough(guess, next)) next
        else iterate(next)
      }

      iterate(firstGuess)
    }

    // fixed point for f(x) = 1 + x/2; should be x == 2
    fixedPoint(x => 1 + x / 2)(1)

    // Let's now define the sqrt(x) using the fixed point strategy
    // sqrt(x) = y -> y * y = x -> y = x / y
    // Considering x a given constant, the y we want to find will now be fixed point of the function f(y) = x/y

    def sqrt(x: Double): Double =
      fixedPoint(y => x / y)(1.0)

    // sqrt as it is, doesn't converge. So, let's apply avg to reduce oscillation
    def averageDamp(f: Double => Double)(x: Double) =
      (x + f(x))/2

    def converging_sqrt(x: Double): Double =
      fixedPoint(averageDamp(y => x / y))(1.0)


    println(converging_sqrt(16))
  }




}
