//http://rosettacode.org/wiki/Maximum_triangle_path_sum#Scala
/*
https://projecteuler.net/problem=18
By starting at the top of the triangle below and moving to adjacent numbers on the row below,
the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:
 */
var triangle2 = Array(
  Array(2),
  Array(3, 4),
  Array(6, 5, 7),
  Array(4, 1, 8, 3))
def solutionMax(triangle: Array[Array[Int]]): Array[Array[Int]] = {

  for (cur_row <- triangle.length - 2 to 0 by -1;
       cur_col <- triangle(cur_row).indices) {

    val previous_lower_row = cur_row + 1
    val next_to_right_col = cur_col + 1

    triangle(cur_row)(cur_col) += triangle(previous_lower_row)(cur_col) max
      triangle(previous_lower_row)(next_to_right_col) // Dynamic programming

  }

  triangle
}

def solutionMin(triangle: Array[Array[Int]]): Array[Array[Int]] = {
  for (cur_row <- triangle.length - 2 to 0 by -1;
       cur_col <- triangle(cur_row).indices) {

    val previous_lower_row = cur_row + 1
    val next_to_right_col = cur_col + 1

    triangle(cur_row)(cur_col) += triangle(previous_lower_row)(cur_col) min
      triangle(previous_lower_row)(next_to_right_col) // Dynamic programming
  }
  triangle
}

def displayGrid(grid: Array[Array[Int]]) = {
  for (row <- grid.indices) println(grid(row).toList)
}
//println("Thsi ", displayGrid(solutionMax(triangle2)))
//println("Thsi ", displayGrid(solutionMin(triangle2)))
/*
MAX
List(21)
List(16, 19)
List(10, 13, 15)
List(4, 1, 8, 3)
(Thsi ,())
res0: Unit = ()
MIN
List(11)
List(9, 10)
List(7, 6, 10)
List(4, 1, 8, 3)
(Thsi ,())
 */