// Covariance for arrays not present in scala
//val a: Array[Int] = Array[Int](1, 2)
//val b: Array[Object] = a


def insertionSort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y, insertionSort(ys))
}

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)
}