//https://codility.com/programmers/task/missing_integer/
def solution(A:Array[Int],N:Int):Int={
  val sorted = A.sorted
  val smallestIndex = sorted.indexWhere(_ > 0)
  //println(smallestIndex)
  if(smallestIndex < 0) return 1 // -1 did not found
  if(sorted(smallestIndex) > 1) return 1 // when 1 is missing


  for(n <- smallestIndex until A.length-1){
    if(sorted(n+1) > sorted(n) + 1) return sorted(n) + 1
  }
  sorted.last + 1

}

println(solution(Array(-2,-3,-5,1,3,6,4,1,2),12)) // 5

//https://codility.com/demo/results/trainingWPV4MX-3NC/
/*
Write a function:

object Solution { def solution(a: Array[Int]): Int }
that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0) that does not occur in A.

For example, given:

  A[0] = 1
  A[1] = 3
  A[2] = 6
  A[3] = 4
  A[4] = 1
  A[5] = 2
the function should return 5.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 */