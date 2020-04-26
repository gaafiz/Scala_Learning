abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  override def isZero = true

  override def predecessor = throw new Error("Negative Number")

  override def successor = new Succ(this)

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if (that.isZero) that else throw new Error("Negative Number")
}

class Succ(n: Nat) extends Nat {
  override def isZero = false

  override def predecessor = n

  override def successor = new Succ(this)

//  override def +(that: Nat): Nat = {
//    if (that.isZero)
//      this
//    else this.successor + that.predecessor
//  }

  override def +(that: Nat): Nat = new Succ(n + that)

  override def -(that: Nat) = if (that.isZero) this else n - that.predecessor
}