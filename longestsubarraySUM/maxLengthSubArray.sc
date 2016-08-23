/*
For example, the subarrays of array a = [1, 2, 3] are [1], [2], [3], [1, 2],[2, 3], and [1, 2, 3].
Now, let's say we have an integer, k = 3. The subarrays of a having elements that sum to a
number <= k are [1],[2], and [1,2]

The longest of these subarrays is [1, 2], which has a length of 2.

Constraints :
1<=n<=10^5
1<=a[i]<=10^3
1<=k<=10^9 ;; Max INT = -2147483648 to 2147483647~ 2 * 10^9
 */
def positionConverter(currentPosition:Int,limitNumber:Int):Int=
  if(currentPosition>=limitNumber)currentPosition % limitNumber else currentPosition
maxLengthSubArrayContiguous(Array(1,2,3),4) == 2
maxLengthSubArrayContiguous(Array(3,1,2,1),4) == 3
maxLengthSubArrayContiguous(Array(1,1,3,3,1,1),4) == 4
maxLengthSubArrayContiguous(Array(1,6,3,2,5,1),4) == 0

def maxLengthSubArrayContiguous(A: Array[Int], s: Int): Int = {
  val n = A.length
  var front = 0
  var total = 0
  var kadane = 0 //maximum sub array
  var ending_length = 0

  for (back <- 0 to n) {

    while (front < 2 * n && total + A(positionConverter(front,n)) <= s) {
      total += A(positionConverter(front,n))
      front += 1
      ending_length +=1
    }

    if (total == s) kadane = kadane max ending_length

    total -= A(positionConverter(back,n))
    ending_length -= 1
  }

  kadane //#end
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


