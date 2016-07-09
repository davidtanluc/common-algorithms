////// mid keep changing
// sorted


val A = Array(1, 3, 5, 8, 10)

var l = 0
val key = 8
var r = A.size - 1
while (l < r) {
  val mid = (l + r) / 2;
  if (A(mid) < key) {
    l = mid + 1
  }
  else {
    r = mid
  }

}

if (A(l) == key) println("Found ", A(l))


/*
<%

View bounds( apply
implicit convertion).Used
in parameterized and
abstract type declarations
to convert the type using
view.
 */
def binarySearch01[A](xs: Seq[A], x: A)(implicit ord: Ordering[A]): Option[Int] = {
  var (low, high) = (0, xs.size - 1)
  while (low <= high)
    (low + high) / 2 match {
      case mid if ord.gt(xs(mid), x) => high = mid - 1
      case mid if ord.lt(xs(mid), x) => low = mid + 1
      case mid => return Some(mid)
    }
  None
}

def binarySearch[A <% Ordered[A]](xs: Seq[A], x: A): Option[Int] = {
  var (low, high) = (0, xs.size - 1)
  while (low <= high)
    (low + high) / 2 match {
      case mid if xs(mid) > x => high = mid - 1
      case mid if xs(mid) < x => low = mid + 1
      case mid => return Some(mid)
    }
  None
}


val sample = Seq(1, 4, 5, 6, 77, 89, 0)
val elem = 77 // none
val elem1 = 77
println(binarySearch(sample, elem))
println(binarySearch01(sample, elem1))