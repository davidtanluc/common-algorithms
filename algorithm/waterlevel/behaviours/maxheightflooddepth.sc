/*
You are helping a geologist friend investigate an area with mountain lakes. A recent heavy rainfall has flooded these
 lakes and their water levels have reached the highest possible point. Your friend is interested to
 know the maximum depth in the deepest part of these lakes.

We simplify the problem in 2-D dimensions. The whole landscape can be divided into small blocks and described by
an array A of length N. Each element of A is the altitude of the rock floor of a block
(i.e. the height of this block when there is no water at all). After the rainfall, all the low-lying areas
(i.e. blocks that have higher blocks on both sides) are holding as much water as possible.
You would like to know the maximum depth of water after this entire area is flooded.
You can assume that the altitude outside this area is zero and the outside area can accommodate infinite amount of water.

For example, consider array A such that:

    A[0] = 1
    A[1] = 3
    A[2] = 2
    A[3] = 1
    A[4] = 2
    A[5] = 1
    A[6] = 5
    A[7] = 3
    A[8] = 3
    A[9] = 4
    A[10] = 2
The following picture illustrates the landscape after it has flooded:



The gray area is the rock floor described by the array A above and the blue area with dashed lines represents the
 water filling the low-lying areas with maximum possible volume. Thus, blocks 3 and 5 have a water depth of
 2 while blocks 2, 4, 7 and 8 have a water depth of 1. Therefore, the maximum water depth of this area is 2.

Write a function:

int solution(int A[], int N);
that, given a non-empty zero-indexed array A consisting of N integers, returns the maximum depth of water.

Given array A shown above, the function should return 2, as explained above.

For the following array:

    A[0] = 5
    A[1] = 8
the function should return 0, because this landscape cannot hold any water.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..100,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

                __5_
                 | |    __4
       3         | |_3__| |
       --        |        |
      |  |_2_    |        |_2_
   _1_|     |_1__|           |


 */
def solution(height: Array[Int]): Int = {
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
  //List(0, 0, 1, 2, 1, 2, 0, 1, 1, 0, 0)
  result.max

}
val rain1 = Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
val rain2 = Array(1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2)
val rain3 = Array(5,8)
//println(solution(rain1))//2
println(solution(rain2)) //2
println(solution(rain3)) //0
//https://leetcode.com/problems/trapping-rain-water/
//100 %
//https://codility.com/demo/results/trainingRHWRGA-NJX/
/*
(left:,List(0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3))
(right:List(3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1))
      Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
  diff     (0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0)
6
(left:,List (1, 3, 3, 3, 3, 3, 5, 5, 5, 5, 5))
(right:,List(5, 5, 5, 5, 5, 5, 5, 4, 4, 4, 2))
      Array (1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2)
   diff     (0, 0, 1, 2, 1, 2, 0, 1, 1, 0, 0)

8
 */