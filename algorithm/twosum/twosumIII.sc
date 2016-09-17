import scala.collection.mutable

/*
Question:
Design and implement a TwoSum class. It should support the following operations: add
and find.
add(input) – Add the number input to an internal data structure.
find(value) – Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5); find(4)  true; find(7)  false
 */

/**
  * Created by davidtan on 9/15/16.
  */
object twosumIII {

  case class TwoSum(input: Int) {
    private val table = mutable.Map[Int, Int]()

    def add(input: Int) {
      val count = if (table.isDefinedAt(input)) table(input) else 0
      table(input) = count + 1

      println(table)
    }

    def find(_val: Int): Boolean = { //???
      for (entry <- table) {
        val num = entry._1 //key
        val y = _val - num
        if (y == num) {
          if (entry._2 >= 2) return true
        } else if (table.isDefinedAt(y)) {
          return true
        }
      }
      false
    }
  }

  def solution(l: List[Int], target: Int): Boolean = {
    val ts = TwoSum(-1)

    for (el <- l) {
      val diff = Math.abs(target - el)
      println("diff",diff)
      if (ts.find(diff)) {
        println(diff," ",el)
        return true
      }

      ts.add(el)

    }
    false
  }


//  def main(args: Array[String]): Unit = {
//    val l = List(1, 4, 5, 7, 8)
//    val target = 11
//    println(solution(l, target))
//  }


}

val l = List(1, 4, 5, 7, 8)
val target = 11
val result = twosumIII
println(result.solution(l, target))

/*
l: List[Int] = List(1, 4, 5, 7, 8)
target: Int = 11
result: twosumIII.type = twosumIII$@3f607f54
(diff,10)
Map(1 -> 1)
(diff,7)
Map(4 -> 1, 1 -> 1)
(diff,6)
Map(5 -> 1, 4 -> 1, 1 -> 1)
(diff,4)
Map(5 -> 1, 4 -> 1, 7 -> 1, 1 -> 1)
(diff,3)
Map(8 -> 1, 5 -> 1, 4 -> 1, 7 -> 1, 1 -> 1)
false
 */
