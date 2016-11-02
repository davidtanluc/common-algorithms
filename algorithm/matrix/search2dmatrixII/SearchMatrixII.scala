package matrix1

/**
  * Created by davidtan on 11/2/16.
  * https://leetcode.com/problems/search-a-2d-matrix-ii/
  * Write an efficient algorithm that searches for a value
  * in an m x n matrix. This matrix has the following properties:

  * Integers in each row are sorted in ascending from left to right.
  * Integers in each column are sorted in ascending from top to bottom.
  * For example,

  * Consider the following matrix:

  * [
  * [1,   4,  7, 11, 15],
  * [2,   5,  8, 12, 19],
  * [3,   6,  9, 16, 22],
  * [10, 13, 14, 17, 24],
  * [18, 21, 23, 26, 30]
  * ]
  * Given target = 5, return true.

  * Given target = 20, return false.
  */
object SearchMatrixII {

  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {

    val m = matrix.length - 1 //height
    val n = matrix(0).length - 1 //width

    var row = m
    var col = 0
    while (row >= 0 && col <= n) {

      if (target < matrix(row)(col)) {
        row -= 1 // go to next lower row
      }
      else if (target > matrix(row)(col)) {
        col += 1 // go to next right
      }
      else { // equal
        return true
      }
    }
///
    false

  }
  /////////////////////////
  def main(args: Array[String]) = {

    val matrix1 = Array(
      Array(1, 4, 7, 11, 15),
      Array(2, 5, 8, 12, 19),
      Array(3, 6, 9, 16, 22),
      Array(10, 13, 14, 17, 24),
      Array(18, 21, 23, 26, 30)
    )
    println(searchMatrix(matrix1, 5)) //true
    println(searchMatrix(matrix1, 20)) //false

  }

}
