/*
A non-empty zero-indexed array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.
 */
val A = Array(4,1,3,2)
solution(A)
def solution(A:Array[Int]):Int={
  val sorted_view = A.sorted.view
  if(sorted_view == (1 to sorted_view.length)) 1
  else 0
}
val A1 = Array(4,1,3)
solution(A1)

//https://codility.com/demo/results/training58A2BE-PQ5/