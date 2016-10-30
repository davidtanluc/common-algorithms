import java.util
val A = Array(6, 7, 4, 3, 5)
//val A = List(6, 0, 7, 0, 4, 0, 0, 0, 0, 3, 0, 0, 5)
val B = Array(0, 1, 1, 4, 2)
/// find largest lake size
def addZero(n: Int): List[Int] = {
  if (n == 0) return List(0)
  (for (i <- 1 to n) yield 0).toList
}
//addZero(0)
def makeHeight(A: Array[Int], B: Array[Int]) = {
  (for (i <- A.indices) yield {
    A(i) :: addZero(B(i))
  }).toList.flatten
}
//findIndexZero(List(0, 6, 0, 5, 1, 5, 2, 5, 5, 5, 5, 0, 0, 0))
def findIndexZero(A: List[Int]) = (for (i <- A.indices; if A(i) == 0) yield i).toList
// List(0, 2, 11, 12, 13)
findArea(List(0, 2, 11, 12, 13), List(0, 6, 0, 5, 1, 5, 2, 5, 5, 5, 5, 0, 0, 0))

def findArea(A: List[Int], B: List[Int]) = {
  val xx = new util.ArrayList[Int]()
  val n = A.length
  var i = 0
  while (i < n) {
    val current = A(i) //0
    i += 1
    if (i < n) {
      val next = A(i) //2
      val count = next - current
      val ll1 = for (k <- current until next) yield B(k)
      println(ll1)

      if (ll1.isEmpty) xx.add(0)
      else if (ll1.length < 2) {
        println(count,"1 ",ll1(0))
        xx.add(count * ll1(0))
      }

      else {
        val kk1 = ll1.sorted
        val n1 = kk1.length
        println(count," 2",kk1(n1 - 2))

        xx.add(kk1(n1 - 2) * count)
      }


    }
  }

  println(xx.toArray.toList)

}
//List(0, 6, 0, 5, 1, 5, 2, 5, 5, 5, 5, 0, 0, 0)
//def findsentinel(xs: List[Int]) = {
//  val n = xs.length
//  for (i <- xs.indices) yield {
//    var j = i
//    j +=1 //next
//    var tmp = xs(i)
//    var count = 0
//    if (xs(i) == 0 && j< n) {// find sentinel
//      while(j<n && xs(j)!=0){
//        tmp += xs(j)
//        count +=1
//        j +=1
//      }
//    }
//    tmp
//  }
//}
val l1 = makeHeight(A, B).toArray //Array(6, 0, 7, 0, 4, 0, 3, 0, 0, 0, 0, 5, 0, 0)
// check sentinel between zero
//biggestlake(l1)
def biggestlake(height: Array[Int]): Int = {
  val n = height.length

  if (height == null || n <= 2) return 0

  val left = new Array[Int](n)
  val right = new Array[Int](n)

  //scan from left to right
  val head = height.head
  var max = head
  left(0) = head

  for (i <- 1 until n) {
    max = max max height(i)
    left(i) = max

  }
  //println("left:",left.toList)

  //scan from right to left
  val last = height.last
  max = last
  right(n - 1) = last

  for (i <- n - 2 to 0 by -1) {
    max = max max height(i)
    right(i) = max
  }
  //println("right:",right.toList)

  //calculate max value
  val result = (for (i <- height.indices) yield Math.min(left(i), right(i)) - height(i)).toList
  println(result)
  //List(0, 6, 0, 5, 1, 5, 2, 5, 5, 5, 5, 0, 0, 0)


  result.sum

}