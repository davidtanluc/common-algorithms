import scala.collection.mutable.HashSet

/**
  * Created by davidtan on 9/25/16.
  */
object happynumber2 {
  def isHappy(N: Int): Boolean = {
    var n = N
    val set = HashSet[Int]()

    while (!set.contains(n)) {
      set += n // add
      n = getSum(n)
      if (n == 1) return true
    }
    false
  }

  def getSum(N: Int): Int = {
    var n = N
    var sum = 0

    while (n > 0) {
      val mod1 = n % 10
      sum += mod1 * mod1
      n = n / 10
    }

    sum
  }

  def main(args: Array[String]): Unit = {
    for (i <- 0 to 100) {
      val ok1 = isHappy(i)
      if (ok1) println(i)
    }
  }
}

/*
https://en.wikipedia.org/wiki/Happy_number

For example, 19 is happy, as the associated sequence is:

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1.
The 143 happy numbers up to 1,000 are:

1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100, 103, 109, 129,
130, 133, 139, 167, 176, 188, 190, 192, 193, 203, 208, 219, 226, 230, 236, 239, 262, 263, 280, 291,
293, 301, 302, 310, 313, 319, 320, 326, 329, 331, 338, 356, 362, 365, 367, 368, 376, 379, 383, 386, 391, 392,
397, 404, 409, 440, 446, 464, 469, 478, 487, 490, 496, 536, 556, 563, 565, 566, 608, 617, 622, 623, 632, 635, 637,
638, 644, 649, 653, 655, 656, 665, 671, 673, 680, 683, 694, 700, 709, 716, 736, 739, 748, 761, 763, 784, 790, 793,
802, 806, 818, 820, 833, 836, 847, 860, 863, 874, 881, 888, 899, 901, 904, 907, 910, 912, 913, 921, 923, 931, 932,
 937, 940, 946, 964, 970, 973, 989, 998, 1000

1
7
10
13
19
23
28
31
32
44
49
68
70
79
82
86
91
94
97
100
 */