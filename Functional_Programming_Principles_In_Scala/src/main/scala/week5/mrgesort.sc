// List to order
val nums = List(2, -4, 5, 7, 1)

// Merge sort specific for int list
def msortIntList(xs: List[Int]): List[Int] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xsTail, y :: ysTail) =>
        if (x < y) x :: merge(xsTail, ys)
        else y :: merge(xs, ysTail)
    }

    val (fst, snd) = xs splitAt n
    merge(msortIntList(fst), msortIntList(snd))
  }
}

msortIntList(nums)


// mergesort for generic lists
def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xsTail, y :: ysTail) =>
        if (lt(x, y)) x :: merge(xsTail, ys)
        else y :: merge(xs, ysTail)
    }

    val (fst, snd) = xs splitAt n
    merge(msort(fst)(lt), msort(snd)(lt))
  }
}

msort(nums)((x, y) => x < y)
