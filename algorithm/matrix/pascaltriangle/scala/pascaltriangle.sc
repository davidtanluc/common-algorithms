/*

                1
              1   1
            1  2   1
           1 3   3  1
          1 4   6  4  1



1) col=0  => 1
2) c==r both ends => 1
3) pascal(c-1,r-1)+ pascal(c,r-1)

 */
def pascal2(row: Int): List[Int] = row match {
  case 1 => List(1)
  case 2 => List(1, 1)
  case n => List(1) ::: pascal2(n - 1).sliding(2).map(_.sum).toList ::: List(1)
}
//printPascal2(5)
/*
List(1)
List(1, 1)
List(1, 2, 1)
List(1, 3, 3, 1)
List(1, 4, 6, 4, 1)
 */
def printPascal2(n: Int) = {
  for (row <- 1 to n) {
    println(pascal2(row))
  }
}
def pascal1(row: Int, col: Int): Int = (row, col) match {
  case (_, 0) => 1
  case x if col == row => 1
  case _ => pascal1(row - 1, col) + pascal1(row - 1, col - 1)
}
///////////////
printPascal(5)
/*
(row:,0)1
(row:,1)1 1
(row:,2)1 2 1
(row:,3)1 3 3 1
(row:,4)1 4 6 4 1
(row:,5)1 5 10 10 5 1
 */
def printPascal(n: Int) = {
  for (row <- 0 to n) {
    // height
    print("row:", row)
    for (col <- 0 to row) // width
      print(pascal1(row, col) + " ")
    println()
  }
}
////////////
