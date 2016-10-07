/*

Task description
In this problem we consider only strings consisting of lower-case English letters (a−z).

A string is a palindrome if it reads exactly the same from left to right as it does from right to left. For example, these strings are palindromes:

aza
abba
abacaba
These strings are not palindromes:

zaza
abcd
abacada
Given a string S of length N, a slice of S is a substring of S specified by a pair of integers (p, q), such that 0 ≤ p < q < N. A slice (p, q) of string S is palindromic if the string consisting of letters S[p], S[p+1], ..., S[q] is a palindrome. For example, in a string S = abbacada:

slice (0, 3) is palindromic because abba is a palindrome,
slice (6, 7) is not palindromic because da is not a palindrome,
slice (2, 5) is not palindromic because baca is not a palindrome,
slice (1, 2) is palindromic because bb is a palindrome.
Write a function

object Solution { def solution(s: String): Int }
that, given a string S of length N letters, returns the number of palindromic slices of S. The function should return −1 if this number is greater than 100,000,000.

For example, for string S = baababa the function should return 6, because exactly six of its slices are palindromic; namely: (0, 3), (1, 2), (2, 4), (2, 6), (3, 5), (4, 6).

Assume that:

N is an integer within the range [0..20,000];
string S consists only of lower-case letters (a−z).
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */

def positions(str: String): List[Int] = {

  val t = "$" + (for (ch <- str) yield "#" + ch).toList.mkString("") + "#@"
  val p = new Array[Int](t.length) // palindrome position
  var center = 0
  var right = 0

  for (i <- 1 until t.length - 1) {
    val mirror = 2 * center - i

    if (right > i) p(i) = (right - i) min p(mirror)

    // attempt to expand palindrome centered at i
    while (t(i + (1 + p(i))) == t(i - (1 + p(i)))) p(i) += 1

    // if palindrome centered at i expands past right,
    // adjust center based on expanded palindrome.
    if (i + p(i) > right) {
      center = i
      right = i + p(i)
    }
  } //for
  p.toList
}
def solution(str: String): Int = {
  val pos = positions(str)
  var sum = 0
  for (el <- pos
       if el > 1) {
    sum += el / 2
    if (sum > 100000000) return -1
  }
  sum
}
solution("baababa") //6
//     ^  #  b  #  a  #  a  #  b  #  a  #  b  #  a  #  $  //str2
//   [ 0, 0, 1, 0, 1, 4, 1, 0, 3, 0, 5, 0, 3, 0, 1, 0, 0 ] arr1
//solution("abbacada") //4
//t=   ^  #  a  #  b  #  b  #  a  #  c  #  a  #  d  #  a  #  $
//p= [ 0, 0, 1, 0, 1, 4, 1, 0, 1, 0, 3, 0, 1, 0, 3, 0, 1, 0, 0 ]
// 100 %
//https://codility.com/demo/results/trainingAKF4FD-KGV/
solution("aabaa") == 4