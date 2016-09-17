def lcs(str1: String, str2: String, len1: Int, len2: Int): Int = {
  if (len1 == str1.length || len2 == str2.length) return 0
  if (str1(len1) == str2(len2)) lcs(str1, str2, len1 + 1, len2 + 1) + 1
  else lcs(str1, str2, len1 + 1, len2) max lcs(str1, str2, len1, len2 + 1)
}

def lcsDynamic2(str1: String, str2: String): Int = {
  val DP = Array.ofDim[Int](str1.length + 1, str2.length + 1)
  var max = 0

  for (i <- 1 until DP.length; prev_i = i - 1;
       j <- 1 until DP(i).length; prev_j = j - 1){

      if (str1(prev_i) == str2(prev_j))

        DP(i)(j) = DP(prev_i)(prev_j) + 1

      else DP(i)(j) =  DP(prev_i)(j) max DP(i)(prev_j)

      max = max max DP(i)(j)
  }

  //#END
  max

}

def lcs3(str1: String, str2: String, str3: String,len1: Int, len2: Int, len3:Int): Int = {
  if (len1 == str1.length || len2 == str2.length || len3 == str3.length) return 0
  if (str1(len1) == str2(len2) && str2(len2) == str3(len3)) lcs3(str1, str2, str3, len1 + 1, len2 + 1,len3 + 1) + 1
  else lcs3(str1, str2, str3,len1 + 1, len2,len3) max lcs3(str1, str2,str3, len1, len2 + 1,len3) max lcs3(str1, str2, str3, len1, len2,len3+1)
}

def lcsDynamic3(str1: String, str2: String,str3:String): Int = {
  val DP = Array.ofDim[Int](str1.length + 1, str2.length + 1,str3.length+1)
  var max = 0

  for (i <- 1 until DP.length; prev_i = i - 1;
       j <- 1 until DP(i).length; prev_j = j - 1;
       k <- 1 until DP(i)(j).length;prev_k = k - 1) {

        if (str1(prev_i) == str2(prev_j) &&  str2(prev_j) == str3(prev_k))

          DP(i)(j)(k) = DP(prev_i)(prev_j)(prev_k) + 1

      else DP(i)(j)(k) =  DP(prev_i)(j)(k) max DP(i)(prev_j)(k) max DP(i)(j)(prev_k)

      max = max max DP(i)(j)(k)
  }
  //#END
  max

}

val str1: String = "ABCDGHLQR"
val str2: String = "AEDPHR"
//val str3: String = "EDPH"
//val str3: String = "Z"
val str3: String = "HELLOOWORLD"
//lcs(str1,str2,0,0)//res0: Int = 4
//lcs3(str1,str2,str3,0,0,0)//res0: Int = 2
lcsDynamic3(str1,str2,str3)//2, 0, 2