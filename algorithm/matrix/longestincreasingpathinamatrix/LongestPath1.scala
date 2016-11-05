package matrix1

/**
  * Created by davidtan on 11/4/16.
  */
object LongestPath1 {
  var dx = Array(-1, 1, 0, 0)
  var dy = Array(0, 0, -1, 1)

  def dfs(matrix: Array[Array[Int]], row: Int, col: Int, mem: Array[Array[Int]]): Int = {

    if (mem(row)(col) != 0) return mem(row)(col)

    val height = matrix.length //height
    val width = matrix(0).length //width

    for (movements <- 0 until 4) {
      // 4 directions

      val cur_row = row + dx(movements) // movements...
      val cur_col = col + dy(movements)

      if (cur_row >= 0 && cur_col >= 0 &&
        cur_row < height && cur_col < width &&
        matrix(cur_row)(cur_col) > matrix(row)(col)) {

        mem(row)(col) = mem(row)(col) max dfs(matrix, cur_row, cur_col, mem)
      }

    }
    ///
    mem(row)(col) += 1
    mem(row)(col)
  }

  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
    val h = matrix.length
    val w = matrix(0).length

    if (matrix.isEmpty) return 0

    val mem = Array.ofDim[Int](h, w)

    var longest = 0

    for (row <- matrix.indices;
         col <- matrix(0).indices) {

      longest = longest max dfs(matrix, row, col, mem)

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
