/*
https://leetcode.com/problems/trapping-rain-water/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
                   3_
          2_       | |2_   2_
     1_   | |1_  1_|    |1_| |1_
  _0_| |0_|   |0_|              |

 */
def trap(height: Array[Int]): Int = {
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
  //println(result)
  //List(0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0)

  result.sum

}
val rain1 = Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
val rain2 = Array(1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2)
val rain3 = Array(5,8)

trap(rain1) == 6
trap(rain2) == 8
trap(rain3) == 0

/*
(left:,List(0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3))
(right:List(3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1))
      Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
  diff     (0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0)
6
 */

