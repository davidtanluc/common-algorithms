def solution(A:Array[Int]):Int={
  val sorted = A.sorted
  //println(sorted.toList)//List(1, 1, 2, 3, 4, 6)
  val smallestIndex = sorted.indexWhere(_ > 0)
  //println(smallestIndex) //0
  if(smallestIndex < 0) return 1 // -1 did not find
  if(sorted(smallestIndex) > 1) return 1 // when 1 is missing or head is missing


  for(n <- smallestIndex until A.length-1
      if sorted(n+1) > sorted(n) + 1){ // next is greater than current + 1
    return sorted(n) + 1 //found missing integer
  }

  sorted.last + 1 // if tail is missing

}
solution(Array(1,3,6,4,1,2)) // 5
/*
 A[0] = 1
  A[1] = 3
  A[2] = 6
  A[3] = 4
  A[4] = 1
  A[5] = 2
the function should return 5.
 */
// 100 %
//https://codility.com/c/run/training6H9Z7G-MHG