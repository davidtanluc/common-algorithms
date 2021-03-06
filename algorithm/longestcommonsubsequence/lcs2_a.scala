/**
  * Created by davidtan on 8/9/16.
  */
object lcs2_a {
  def lcs(str1: String, str2: String, len1: Int, len2: Int): Int = {
    if (len1 == str1.length || len2 == str2.length) return 0
    if (str1(len1) == str2(len2)) lcs(str1, str2, len1 + 1, len2 + 1) + 1
    else lcs(str1, str2, len1 + 1, len2) max lcs(str1, str2, len1, len2 + 1)
  }

  def lcsDynamic2(str1: String, str2: String): Int = {
    val DP = Array.ofDim[Int](str1.length + 1, str2.length + 1)
    //print(DP.length) //10
    //print(DP(0).length) //7
    /*
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0

     */

    var max = 0

    for(i<- 1 until DP.length){
      val prev_i = i -1
      for(j <- 1 until DP(i).length){
        val prev_j = j-1

        if (str1(prev_i) == str2(prev_j)) DP(i)(j) = DP(prev_i)(prev_j) + 1

        else DP(i)(j) =  DP(prev_i)(j) max DP(i)(prev_j)

        max = max max DP(i)(j)
      }}
         // for (row <- DP) {
           // for (elem <- row) print(elem + " ")
            //println()
          //}
          /*
          0 0 0 0 0 0 0
          0 1 1 1 1 1 1
          0 1 1 1 1 1 1
          0 1 1 1 1 1 1
          0 1 1 2 2 2 2
          0 1 1 2 2 2 2
          0 1 1 2 2 3 3
          0 1 1 2 2 3 3
          0 1 1 2 2 3 3
          0 1 1 2 2 3 4

          */
    //#END
    max

  }

  def main(args: Array[String]) {
    val str1: String = "ABCDGHLQR"
    val str2: String = "AEDPHR"
    System.out.print(lcsDynamic2(str1,str2)) //4
  }
}
