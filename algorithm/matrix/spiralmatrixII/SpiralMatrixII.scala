package matrix1

/**
  * Created by davidtan on 11/2/16.
  * https://leetcode.com/problems/spiral-matrix-ii/
  * Given an integer n, generate a square matrix filled with elements from
  * 1 to n^2 in spiral order.
  * <p>
  * For example,
  * Given n = 3,
  * You should return the following matrix:
  * <p>
  * [
  * [ 1, 2, 3 ],
  * [ 8, 9, 4 ],
  * [ 7, 6, 5 ]
  */
object SpiralMatrixII {
  def generateMatrix(n: Int): Array[Array[Int]] = {

    val total = n * n
    val result = Array.ofDim[Int](n, n)
    var x = 0
    var y = 0
    var step = 0
    var i = 0

    while (i < total) {
      /////////////////
      while (y + step < n) {
        i += 1
        result(x)(y) = i
        y += 1
      }
      y -= 1
      x += 1
      ////
      while (x + step < n) {
        i += 1
        result(x)(y) = i
        x += 1
      }
      x -= 1
      y -= 1
      ////
      while (y >= 0 + step) {
        i += 1
        result(x)(y) = i
        y -= 1
      }
      y += 1
      x -= 1
      step += 1
      ///
      while (x >= 0 + step) {
        i += 1
        result(x)(y) = i
        x -= 1
      }
      x += 1
      y += 1
    }

    result
  }
  def displayGrid(grid: Array[Array[Int]]) = {
    for (row <- grid.indices) println(grid(row).toList)
  }

  def main(args: Array[String]) = {
    displayGrid(generateMatrix(3))
    /*
    List(1, 2, 3)
List(8, 9, 4)
List(7, 6, 5)
     */
    //displayGrid(generateMatrix(5))
    /*
    List(1, 2, 3, 4, 5)
List(16, 17, 18, 19, 6)
List(15, 24, 25, 20, 7)
List(14, 23, 22, 21, 8)
List(13, 12, 11, 10, 9)
     */

  }
}
