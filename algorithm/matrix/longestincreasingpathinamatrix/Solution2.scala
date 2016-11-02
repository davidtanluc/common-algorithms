package matrix1

/**
  * Created by davidtan on 11/2/16.
  * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
  * 329. Longest Increasing Path in a Matrix
  *

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down.
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

  */
object Solution2 {

  var dx = Array(-1, 1, 0, 0)
  var dy = Array(0, 0, -1, 1)

  def dfs(matrix: Array[Array[Int]], i: Int, j: Int, mem: Array[Array[Int]]): Int = {

    if (mem(i)(j) != 0) return mem(i)(j)

    val height = matrix.length //height
    val width = matrix(0).length //width

    for (m <- 0 until 4) {
      // 4 directions

      val x = i + dx(m) // movements...
      val y = j + dy(m)

      if (x >= 0 && y >= 0 && x < height && y < width && matrix(x)(y) > matrix(i)(j)) {

        mem(i)(j) = mem(i)(j) max dfs(matrix, x, y, mem)
      }

    }
    ///
    mem(i)(j) += 1
    mem(i)(j)
  }

  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
    val h = matrix.length
    val w = matrix(0).length

    if (matrix.isEmpty) return 0

    val mem = Array.ofDim[Int](h,w)

    var longest = 0

    for (height <- matrix.indices;
         width <- matrix(0).indices) {

      longest = longest max dfs(matrix, height, width, mem)

    }

    longest
  }

  def main(args: Array[String]) = {

    val matrix = Array[Array[Int]](Array(9, 9, 4), Array(6, 6, 8), Array(2, 1, 1))
    println(longestIncreasingPath(matrix)) //4

    val matrix2 = Array(
      Array(3, 4, 5),
      Array(3, 2, 6),
      Array(9, 8, 7)
    )
    println(longestIncreasingPath(matrix2)) //7

  }


}
