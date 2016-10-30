/*
http://www.programcreek.com/2014/03/leetcode-candy-java/
There are N children standing in a line. Each child is assigned a rating value. You are giving ratings to these children subjected to the following requirements:

1. Each child must have at least one candy.
2. Children with a higher rating get more ratings than their neighbors.


 */
def candies(ratings: Array[Int]): Int = {
  val n = ratings.length

  if (ratings == null || n == 0) return 0

  val candies = new Array[Int](n)
  candies(0) = 1

  //scan from left to right
  for (i <- 1 until n) {
    // current rating greater previous
    if (ratings(i) > ratings(i - 1)) {

      candies(i) = candies(i - 1) + 1

    } else {
      // if not ascending, assign 1

      candies(i) = 1
    }

  }
  //println(candies.toList)
  //List(1, 2, 3, 1, 2, 1, 2)
  var result = candies(n - 1)
  //scan from right to left
  for (i <- n - 2 to 0 by -1) {
    var cur = 1

    // current rating greater than next
    if (ratings(i) > ratings(i + 1)) cur = candies(i + 1) + 1

    result += cur max candies(i)

  }
  //println(candies.toList)

  result
}
//candies(Array(0, 1, 2, 0, 3, 1, 4)) //12
//candies(Array(1, 0, 2)) //5
candies(Array(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1)) //30
//candies = List(1, 2, 3, 4, 5, 6, 1, 1, 1, 1, 1)

//candies(Array(5, 5, 4, 3, 3, 5, 8, 9, 7)) //17