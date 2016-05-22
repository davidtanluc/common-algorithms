//https://en.wikipedia.org/wiki/Reverse_Polish_notation


def isNum(n:Any):Boolean={
  val numPattern = "[0-9]+".r
  val s = n.toString()
  !(numPattern.findAllMatchIn(s) isEmpty)
}
val isLevelTwo = Set("/","*","^")
val isPlusMinus = Set("+", "-")
////////////////////////
val B = "5 + 6 - 2 * 9 + 3 ^ 7 - 1"
val bList = B.split(" ").toList

def inBlock(l1: List[String]): List[String] = {
  val end = l1.length

  def translate(start: Int, end1:Int,stick2:List[String], stack1: List[String]): List[String] = {
    if (start == (end1 - 1))  return stick2 ++ List(l1(start)) ++ stack1
    l1(start) match {
      case (operator) if(isPlusMinus contains operator) && stack1.nonEmpty =>
        translate(start+1, end1, stick2 ++ stack1, operator :: List())
      case (operator) if(isPlusMinus contains operator) && stack1.isEmpty =>
        translate(start+1, end1, stick2,  operator :: stack1)
      case (operator) if isLevelTwo contains operator =>
        translate(start+1, end1, stick2,  operator ::stack1)
      case (num)if isNum(num) =>
        translate(start+1, end1,stick2 :+ num, stack1)
    }
  }
  translate(0, end,List(), List())
}

println(inBlock(bList))////List(5, 6, +, 2, 9, *, -, 3, 7, ^, +, 1, -) 56+29*-37^+1-