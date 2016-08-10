//average O(nlogn) worst n^2

def sort(xs: Array[Int]) {
  def swap(i: Int, j: Int) {
    val t = xs(i);
    xs(i) = xs(j);
    xs(j) = t
  }
  def sort1(l: Int, r: Int) {
    val pivot = xs((l + r) / 2)
    var i = l
    var j = r
    while (i <= j) {
      while (xs(i) < pivot) i += 1
      while (xs(j) > pivot) j -= 1
      if (i <= j) {
        swap(i, j)
        i += 1
        j -= 1
      }
    }
    if (l < j) sort1(l, j)
    if (j < r) sort1(i, r)
  }
  sort1(0, xs.length - 1)
}
//http://www.scala-lang.org/docu/files/ScalaByExample.pdf
val ll1 = Array(1, 5, 5, 7, 2, 4)
sort(ll1)
println(ll1.toList)//List(1, 2, 4, 5, 5, 7)