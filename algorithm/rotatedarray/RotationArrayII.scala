/**
  * Created by davidtan on 10/19/16.
  */
object RotationArrayII {
  def findMin(A: Array[Int]): Int = {

    if (A.isEmpty) return -1
    val n = A.length

    var left = 0
    var right = n - 1

    while (left <= right) {

      while (left != right && A(left) == A(right)) left += 1   // move left by 1

      val mid = (left + right) / 2

      if (A(left) <= A(right)) return A(left)

      if (A(mid) >= A(left)) left = mid + 1 else right = mid

    }

    -1

  }
  //////with duplicate .....
  def main(args: Array[String]) = {
    val A: Array[Int] = Array(5, 6, 1, 2, 3, 4)
    val B: Array[Int] = Array(1, 2, 3, 4)
    val C: Array[Int] = Array(2, 1)
    val Z: Array[Int] = Array(4, 5, 6, 1, 2, 2, 3, 4, 4)

    println(findMin(A))//1
    println(findMin(B))//1
    println(findMin(C))//1
    println(findMin(Z))//1
  }
}
