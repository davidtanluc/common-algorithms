//// Find which word/words is/are anagram of another in this list
import scala.collection.mutable

def makeList(str: String): Array[Int] = {
  val xs = Array.fill(26)(0)
  for (el <- str) xs(el - 'a') += 1
  xs
}
var C = Array("ate", "eat", "java", "apple", "jaav", "aet")

val occ = mutable.Map[List[Int], Int]()

// find types of list

C.foreach(token => {
  val ok1 = makeList(token).toList
  //println(ok1.toList)
  if (occ.isDefinedAt(ok1)) occ(ok1) += 1 else occ(ok1) = 1
})
//for(el <- occ.keys)println(el)
/*
List(2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0)
List(1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
List(1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

 */
C.filter(token => {
  val ok1 = makeList(token).toList
  occ.isDefinedAt(ok1) && occ(ok1) > 1
})
//res1: Array[String] = Array(ate, eat, java, jaav, aet)
