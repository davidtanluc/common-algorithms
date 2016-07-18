def toPostfix(infix: String): String = {
  def op(op: String): Int = {
    var b = 0
    for (i <- infix.length - 1 until 0 by -1) {
      val ch = infix(i)
      if (ch == ')') b += 1
      if (ch == '(') b -= 1
      if (op.indexOf(ch) >= 0 && b == 0) return i
    }
    -1
  }
  def subString(a:Int) = toPostfix(infix.substring(0, a)) + toPostfix(infix.substring(a + 1)) + infix(a)

  if (infix.length <= 1) return infix

  val i = op("+-")
  if (i > -1) return subString(i)

  val j = op("*/")
  if (j > -1) return subString(j)

  val k = op("^")
  if (k > -1) return subString(k)

  toPostfix(infix.substring(1, infix.length - 1));
}
//val s1 = "5+(2-3)"//523-+
//val s1 ="5+((6-2)*9+3)"//562-9*3++
//val s1 ="5+((6-2)*9+3)^7-1" //562-9*3+7^+1-
val s1 ="(5+((6-2)*9+3)^7-1)" //562-9*3+7^+1-
toPostfix(s1)
