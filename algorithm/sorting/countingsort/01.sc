//Run time complexity O(n)
def countingSort(theArray: Array[Int], maxValue: Int): Array[Int] = {
  val numsToCounts = new Array[Int](maxValue + 1)
  for (num <- theArray) {
    numsToCounts(num) = numsToCounts(num) + 1
    // println(num," ",numsToCounts.toList)

  }
  // println(numsToCounts.toList)
  //List(0, 1, 1, 1, 0, 1, 2, 1, 0, 0, 1, 1, 0, 0, 0, 0)

  // populate the final sorted array
  val sortedArray = new Array[Int](theArray.length + 1)
  var currentSortedIndex = 0
  //
  // for each num in numsToCounts
  for (num <- 0 until numsToCounts.length) {
    val count = numsToCounts(num)

    // for the number of times the item occurs
    for (x <- 0 until count) {
      // add it to the sorted array
      sortedArray(currentSortedIndex) = num;
      currentSortedIndex += 1
    }
  }
  sortedArray
}
val A = Array(1, 5, 6, 2, 6, 7, 10, 11, 3)
println(countingSort(A, A.length+2).toList.dropRight(1))
/*
List(1, 2, 3, 5, 6, 6, 7, 10, 11)

 */