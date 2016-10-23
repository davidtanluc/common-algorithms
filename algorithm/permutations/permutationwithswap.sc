def solution() = {
  def swap(C: Array[Int], a: Int, b: Int) {
    val tmp = C(a)
    C(a) = C(b)
    C(b) = tmp
  }
  def permute(arr: Array[Int], l: Int, r: Int): Unit = {
    if (l == r) println(arr.toList)
    else {

      for (i <- l to r) {
        swap(arr, l, i)
        permute(arr, l + 1, r)
        swap(arr, l, i)
      }


    }

  }
  permute(Array(1, 2, 3), 0, 3 - 1)
}
solution()
/*
List(1, 2, 3)
List(1, 3, 2)
List(2, 1, 3)
List(2, 3, 1)
List(3, 2, 1)
List(3, 1, 2)
 */