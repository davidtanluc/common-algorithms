///
val A = Array(1, 2, 3, 3, 4, 5, 5, 3)
//// remove duplicate /////
//solution1(A)
def solution1(A: Array[Int]) = {
  for (i <- A.indices) {
    if (A(Math.abs(A(i))) > 0) A(Math.abs(A(i))) = -A(Math.abs(A(i))) else println(A(i))
  }
}
//////////
solution2(A)
//res0: List[Int] = List(3, 5, 3)
def solution2(A: Array[Int]): List[Int] = {
  (for (i <- A.indices) yield {
    if (A(Math.abs(A(i))) > 0) {
      A(Math.abs(A(i))) *= -1
      List()
    } else {
      List(Math.abs(A(i)))
    }
  }).toList.filter(_.nonEmpty).flatten


}