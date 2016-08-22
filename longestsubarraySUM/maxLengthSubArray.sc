/*
For example, the subarrays of array a = [1, 2, 3] are [1], [2], [3], [1, 2],[2, 3], and [1, 2, 3].
Now, let's say we have an integer, k = 3. The subarrays of a having elements that sum to a
number <= k are [1],[2], and [1,2]

The longest of these subarrays is [1, 2], which has a length of 2.
 */
//val B = Array(1,2,3) //2
val B = Array(3,1,2,1) //3
val A2 = B ++ B
maxLengthSubArrayContiguos(A2,4)
def maxLengthSubArrayContiguos(A: Array[Int], s: Int): Int = {
  val n = A.length
  var front = 0
  var total = 0
  var kadane = 0
  var length1 = 0

  for (back <- 0 until n) {
    if(back>=n/2)return kadane //#end

    while (front < n && total + A(front) <= s) {
      total += A(front)
      front += 1
      length1 +=1
    }
    //println(front)
    if (total == s) kadane = kadane max length1

    total -= A(back)
    //println(back)
    length1 -= 1
  }

  kadane //max_length_subarray
}

/* Input

  3
  1
  2
  3
  4
Output

2


/////
4
3
1
2
1
4


Output

3


