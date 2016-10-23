val text = "aaaba" // haystack
val pattern = "ba" // needle

def solution(t: String, p: String): Int = {
  val n = t.length // text
  val m = p.length // pattern
  val p1 = p(0) // first char of pattern

  for (i <- 0 to n - m
       if t(i) == p1
       if t.substring(i, i + m) == p) {

    return i

  }
  -1


}
//solution(text, pattern) //3

solution2(text, pattern) // 3
def solution2(t: String, p: String): Int = {
  val n = t.length
  val m = p.length
  val p1 = p(0) // first char of pattern

  def loop(i: Int): Int = {
    if(m == 1)return i // found if pattern size is one.

    var pK = 1  // second char of pattern
    var tK = i + 1

    while (tK < i + m) { // m -1 ~~ log(m)

      if (p(pK) != t(tK)) return -1

      pK += 1
      tK += 1
    }

    i //true
  }

  for (i <- 0 to n - m //log(n)
       if t(i) == p1
       if loop(i) != -1) {

    return i

  }
  -1


}
//O(log(n) * m) runtime, O(1) space – Brute force:
