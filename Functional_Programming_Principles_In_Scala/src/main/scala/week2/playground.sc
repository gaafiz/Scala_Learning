import week2.Rational

// Base functions
def id(x: Int): Int = x

def cube(x: Int): Int = x * x * x

def fact(n: Int): Int = if (n == 0) 1 else n * fact(n - 1)

// FROM:
def sumInts(a: Int, b: Int): Int =
  if (a > b) 0 else a + sumInts(a + 1, b)

def sumCubes(a: Int, b: Int): Int =
  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

def sumFactorials(a: Int, b: Int): Int =
  if (a > b) 0 else fact(a) + sumFactorials(a + 1, b)

// TO:
def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b)

def sumIntsv2(a: Int, b: Int) = sum(id, a, b)

def sumCubesv2(a: Int, b: Int) = sum(cube, a, b)

def sumFactorialsv2(a: Int, b: Int) = sum(fact, a, b)


def applyOperation(op: (Int, Int) => Int)(x: Int, y: Int): Int =
  op(x, y)

applyOperation((x, y) => x + y)(1, 2)

applyOperation((x, y) => x - y)(1, 2)

def products(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 1
  else f(a) * products(f, a + 1, b)

// ________________________________________

val a = new Rational(4, 12)
a.g
a.sign
a.add(a).add(a)
a.neg()
-a
a.sub(a)

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3,2)

x - y - z
x.isLessThan(y)
x.max(y)

