// Pairs syntax example
val pair = (1, 2)
val (first, second) = pair
pair match {
  case (first, second) => print(first + " - " + second)
}


// List Functions examples
val nums = List(2, -4, 5, 7, 1)

// Basic Functions
nums.length                   // Length of the list

// Transformations
nums filter (x => x > 0)        // Keep all elems from list that satisfy the predicate
nums filterNot (x => x > 0)     // Remove all elems from list that satisfy the predicate
nums partition (x => x > 0)     // Split the list in 2 lists, 1 that satisfy the predicate and 1 that doesn't

nums takeWhile (x => x > 0)     // Longest prefix of list with elems that that satisfy the predicate
nums dropWhile (x => x > 0)     // Remainder of a list, exluding any leading elements satisfying the predicate
nums span (x => x > 0)          // Same as (takeWhile, dropWhile)

// Reduction, Aggregations
(nums foldLeft 0) (_ + _)
nums reduceLeft (_ + _)
nums.sum
nums.product

