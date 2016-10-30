import scala.collection.mutable
/*
// O(logn)
Additional data structure - map
 */
//// not sorted ///

var A = Array(5, 4, 1, 2, 5, 6)
var B = Array(5, 3, 1, 2, 5, 6, 2)
var t = 9
solution(A, t) //(4,5)
solution(B, t) //(6,3)
def solution(A: Array[Int], target: Int): (Int, Int) = {
  val occ = mutable.Map[Int, Int]()

  for (el <- A;
       diff = Math.abs(target - el)) {

    if (occ.isDefinedAt(diff)) {
      return (el, diff)
    } else {
      occ(el) = 1
    }

  }
  (0, 0)

}



