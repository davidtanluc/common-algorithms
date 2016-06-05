import scala.collection.mutable.ArrayBuffer

def merge(l: List[Int], r: List[Int]): List[Int] = {
  var result = ArrayBuffer[Int]()
  var il = 0
  var ir = 0

  while (il < l.length && ir < r.length) {
    if (l(il) < r(ir)) {
      result += l(il)
      il += 1
    } else {
      result += r(ir)
      ir += 1
    }

  }
  //// remainder
  while (il < l.length) {
    result += l(il)
    il += 1
  }
  while (ir < r.length) {
    result += r(ir)
    ir += 1
  }
  result.toList
}

val l = List(1, 3, 5)
val r = List(2, 4, 9)

//println(merge(l, r))
//List(1, 2, 3, 4, 5, 9)

//////////

def mergeSortRec(arr: List[Int]): List[Int] = {

  val total_length = arr.length
  import scala.math._
  if (total_length == 1) return arr
  val mid = floor(total_length / 2).toInt
  val left = arr.take(mid)
  val right = arr.drop(mid)

  merge(mergeSortRec(left), mergeSortRec(right))
}

val unsorted = List(1, 9, 12, 34, 3, 77, 8)
println(mergeSortRec(unsorted))
////(#1,List(1, 3, 8, 9, 12, 34, 77))

def mergeSortRec2(arr: List[Int]): List[Int] = {

  val total_length = arr.length
  if (total_length == 1) return arr
  val mid = total_length / 2
  val (left, right) = arr splitAt mid
  merge(mergeSortRec2(left), mergeSortRec2(right))
}

println("#2", mergeSortRec2(unsorted))
//(#2,List(1, 3, 8, 9, 12, 34, 77))