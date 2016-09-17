//// if sorted ///
/*
O(logn)
no additional data structure

 */
var x = Array(1, 2, 4, 5, 6, 6, 7)
var target = 12
solution(x, target)//(5,7)
def solution(A: Array[Int], target: Int): (Int, Int) = {

  var l = 0 //start
  var r = A.length - 1

  while (l < r) {
    A(l) + A(r) match {
      case x if x == target => return (A(l), A(r))
      case y => if (y < target) l += 1 else r -= 1
    }
  }

  (0, 0)
}