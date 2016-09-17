/*
Sample Input 0:
7
2
3
10
2
4
8
1

Sample Output 0:
8
 */
val A = Array(7, 2, 3, 10, 2, 4, 8, 1)
solution(A)//8
def solution(A: Array[Int]): Int = {

  if (A.length < 2) return 0 // no diff require 2 elements

  var anchor = A(0) // 7
  var max_diff = Int.MinValue //max diff

  for (current <- A.tail) {

    anchor = anchor min current //anchor switch to new minimum

    max_diff = max_diff max (current - anchor)

  }
  //
  max_diff

}