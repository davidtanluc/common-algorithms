//https://en.wikipedia.org/wiki/Reverse_Polish_notation
//https://en.wikipedia.org/wiki/Shunting-yard_algorithm

def isNum(n:Any):Boolean={
  val numPattern = "[0-9]+".r
  val s = n.toString()
  !(numPattern.findAllMatchIn(s) isEmpty)
}
val isLevelTwo = Set("/","*","^")
val isPlusMinus = Set("+", "-")

def inBlock(l1: List[String]): (List[String],Int) = {
  val end = l1.length

  def translate(start: Int, end1:Int,stick2:List[String], stack1: List[String]): (List[String],Int) = {
    if (start == (end1 - 1))  return (stick2 ++ List(l1(start)) ++ stack1,end1-1)
    l1(start) match {
      case (operator) if(isPlusMinus contains operator) && stack1.nonEmpty =>
        translate(start+1, end1, stick2 ++ stack1, operator :: List())
      case (operator) if(isPlusMinus contains operator) && stack1.isEmpty =>
        translate(start+1, end1, stick2,  operator :: stack1)
      case (operator) if isLevelTwo contains operator => translate(start+1, end1, stick2,  operator ::stack1)
      case (num)if isNum(num) => translate(start+1, end1,stick2 :+ num, stack1)
      case ("(") =>{
        val paren_open = translate(start+1, end1,List(), List())
        translate(paren_open._2+1,end1,stick2 ++ paren_open._1,stack1)
      }
      case (")") if(start != end1-1)=> (stick2++stack1,start)//close paren and not end
      //case (")") if(start == end1-1)=> (stick2 ++ stack1,end1-1)//crazy end
    }
  }
  translate(0, end, List(), List())
}


println(inBlock("5+6-2*9+3^7-1".split("").toList)._1)//List(5, 6, +, 2, 9, *, -, 3, 7, ^, +, 1, -)
println(inBlock("5+(6-2)*9+3^7-1".split("").toList)._1)//List(5, 6, 2, -, 9, *, +, 3, 7, ^, +, 1, -)
println(inBlock("5+((6-2)*9+3)^7-1".split("").toList)._1)//List(5, 6, 2, -, 9, *, 3, +, 7, ^, +, 1, -)
println(inBlock("5+6-2*9+3^7-1".split("").toList)._1)//List(5, 6, +, 2, 9, *, -, 3, 7, ^, +, 1, -)
println(inBlock("5+6-2*(9+3^7)-1".split("").toList)._1)//List(5, 6, +, 2, 9, 3, 7, ^, +, *, -, 1, -)
//println(inBlock("5+((6-2)*9+3)^(7-1)".split("").toList)._1)//List(5, 6, 2, -, 9, *, 3, +, 7, ^, +, 1, -)
