package week2_assignment

object Main extends App {
  import FunSets._
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)

  val s = union(s1, s2)
  printSet(s)
  val double = (x: Int) => 2 * x
  val doubleS = map(s, double)
  printSet(doubleS)
  val fourTimesS = map(doubleS, double)
  printSet(fourTimesS)
}
