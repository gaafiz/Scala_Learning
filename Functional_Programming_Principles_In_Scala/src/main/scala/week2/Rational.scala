package week2

class Rational(x: Int, y: Int) {
  require(y !=0, "denominator must be non zero")

  def this(x: Int) = this(x, 1)

  def abs(x: Int): Int = if (x < 0) -x else x
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val g: Int = abs(gcd(x, y))
  val sign = if (y < 0) -1 else 1
  val numer: Int = x / g * sign
  val denom: Int = y / g * sign

  def neg() = new Rational(-numer, denom)

  def add(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def sub(that: Rational): Rational = this + -that

  def isLessThan(that: Rational): Boolean = numer * that.denom < that.numer * denom

  def max(that: Rational): Rational = if (this < that) that else this

  override def toString: String = numer + (if (denom != 1) "/" + denom else "")

  // Aliases
  def unary_- (): Rational = neg()
  def + (that: Rational): Rational = add(that: Rational)
  def - (that: Rational): Rational = sub(that: Rational)
  def < (that: Rational): Boolean = isLessThan(that: Rational)

}
