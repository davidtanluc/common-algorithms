package pascaltriangles

import java.util

/**
  * Created by davidtan on 11/5/16
  *https://leetcode.com/problems/pascals-triangle-ii/
  * * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
  */
object SolutionII {

  def getRow(rowIndex: Int): util.ArrayList[Int] = {

    val result = new util.ArrayList[Int]()

    if (rowIndex < 0) return result

    result.add(1) // col = 0

    for (row <- 1 to rowIndex) {

      for (col <- result.size - 2 to 0 by -1) {

        result.set(col + 1, result.get(col) + result.get(col + 1))
      }

      result.add(1) // col is last
    }

    result
  }

  def main(args: Array[String]) = {
    println(getRow(3).toArray.toList) //List(1, 3, 3, 1)
  }


}
