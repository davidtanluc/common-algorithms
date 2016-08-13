//// Selection sort O(n^2) //////
val A = Array(1, 5, 6, 2, 6, 7, 10, 11, 3)

selectionSort(A)//res0: Array[Int] = Array(1, 2, 3, 5, 6, 6, 7, 10, 11)

def selectionSort(A:Array[Int]):Array[Int]={
  val n = A.length
  var minIndex = 0

  for(i<-A.indices){
    minIndex = i

    for(j<-i until n ;if A(minIndex)>A(j)) minIndex = j

    if(i!=minIndex){
      ///// swap ////
      val aux = A(i)
      A(i) = A(minIndex)
      A(minIndex)= aux
    }

  }

  A

}