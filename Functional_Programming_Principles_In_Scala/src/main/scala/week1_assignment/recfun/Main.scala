package week1_assignment.recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c > r)
        throw new IllegalArgumentException("The column index cannot be greater than the row index")
      else if (c == 0 || c == r)
        1
      else
        pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def charValue(c:Char): Int = {
        if (c == '(')
          1
        else if (c == ')')
          -1
        else
          0
      }

      def balanceIter(chars: List[Char], unclosed_parenthesis: Int) : Boolean = {
        /*
         * Ending Condition 1: (end of string scanning)
         * When we finish to analyze the String (chars.isEmpty == tue),
         * the string is considered balanced if there are no unclosed parenthesis
         *
         * Ending Condition 2: (too many closed parenthesis)
         * If a closed parenthesis is encountered and with no unclosed parenthesis left,
         * We get (unclosed_parenthesis < 0) and we can end the check earlier considering the string unbalanced.
         * This condition covers cases like this string: "(Hello)) World"
        */

        if (unclosed_parenthesis < 0) // Ending Condition 2: (too many closed parenthesis)
          false
        else if (chars.isEmpty) // Ending Condition 1: (end of string scanning)
          unclosed_parenthesis == 0
        else
          balanceIter(chars.tail, unclosed_parenthesis + charValue(chars.head))
      }

      balanceIter(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0)
        1
      else if (money < 0 || coins.isEmpty)
        0
      else {
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
      }
    }
  }
