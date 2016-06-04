import scala.math.Ordered

def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  //(lt: (T, T) => Boolean)
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      //   without implicit ->       if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
      // if (lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
    }
    val (fst, snd) = xs splitAt n
    merge(msort(fst)(ord), msort(snd)(ord))
    // can remove the ord -> due to implicit its implied....
    //merge(msort(fst)(lt), msort(snd)(lt))
  }
} //> msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]

val unsorted = List(1, 9, 12, 34, 3, 77, 8)
println("#1 ", msort(unsorted))
//[A <% Ordered[A]]
///////////////////////////////////////////////////////////////

def msort2[T <% Ordered[T]](xs: List[T]): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: tail_x, y :: tail_y) =>
        if (x < y) x :: merge(tail_x, ys) else y :: merge(xs, tail_y)
    }
    val (fst, snd) = xs splitAt n
    merge(msort2(fst), msort2(snd))
  }
}

println("#2 ", msort2(unsorted))
/*
(#1 ,List(1, 3, 8, 9, 12, 34, 77))
(#2 ,List(1, 3, 8, 9, 12, 34, 77))

 */