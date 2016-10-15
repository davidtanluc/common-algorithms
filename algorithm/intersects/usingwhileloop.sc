
def intersects(A: Array[Int], B: Array[Int]): List[Int] = {
  val nums1 = A.sorted
  val nums2 = B.sorted

  def whileloop(p1: Int, p2: Int, result: List[Int]): List[Int] = {

    if (p1 < nums1.length && p2 < nums2.length)

      (nums1(p1), nums2(p2)) match {

        case x if x._1 < x._2 => loop(p1 + 1, p2, result) // if nums1 smaller

        case y if y._1 > y._2 => loop(p1, p2 + 1, result) // if nums1 greater

        case _ => loop(p1 + 1, p2 + 1, result :+ nums1(p1)) // equals
      }

    else result
  }
  whileloop(0, 0, List())


}

intersects(Array(1, 2, 2, 1), Array(2, 2))
//res0: List[Int] = List(2, 2)

intersects(Array(1, 2, 2, 1, 3, 4, 5), Array(5, 2, 4))
//: List[Int] = List(2, 4, 5)
