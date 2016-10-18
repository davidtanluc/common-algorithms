def printRepeating(arr: Array[Int], size: Int) {

  System.out.println("The repeating elements are : ")

  for (i <- 0 until size) {
    //println(Math.abs(arr(i))," ",arr(Math.abs(arr(i))))

    if (arr(Math.abs(arr(i))) > 0) arr(Math.abs(arr(i))) = -arr(Math.abs(arr(i)))
    else System.out.print(Math.abs(arr(i)) + " ")

  }
  //println(arr.toList) //List(4, -2, -4, -5, -2, -3, 1)

}

val arr = Array(4, 2, 4, 5, 2, 3, 1)
val arr_size = arr.length
printRepeating(arr, arr_size) //4 2