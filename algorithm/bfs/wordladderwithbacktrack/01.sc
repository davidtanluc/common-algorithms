/*

LeetCode – Word Ladder II (Java)

Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that: 1) Only one letter can be changed at a time, 2) Each intermediate word must exist in the dictionary.

For example, given: start = "hit", end = "cog", and dict = ["hot","dot","dog","lot","log"], return:

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]


http://www.programcreek.com/2014/06/leetcode-word-ladder-ii-java/


                     hit
                      |
                     hot
                /          \
              dot          lot
               |            |
              dog          log
                \           /
                     cog

 */
import scala.collection.mutable
type Word = String
def anagramword(s: String) = s.toLowerCase.toList.groupBy(elem => elem).mapValues(elem => elem.length)
def checkdiffbyOne(w1: Word, w2: Word): Boolean = {
  val left = anagramword(w1)
  val right = anagramword(w2)
  var count = 0

  for (l <- left.keys) {
    if (right.isDefinedAt(l)) {
      if (right(l) != left(l)) count += 1
    } else {
      count += 1
    }
  }
  if (count == 1) true else false
}
def makeDict(l: List[Vertex]) = {
  val occ = mutable.Map[Vertex, List[Vertex]]()
  for (left <- l; right <- l; if checkdiffbyOne(left, right)) {
    //println(left,"right",right)
    if (!occ.isDefinedAt(left)) occ(left) = List(right)
    else occ(left) = List(right) ++ occ(left)
  }
  occ
}
val ll1 = List("hit", "hot", "dot", "dog", "lot", "log", "cog")
val g1 = makeDict(ll1)
//val g1 = Map(
//  "dog" -> List("cog", "log", "dot"),
//  "cog" -> List("log", "dog"),
//  "log" -> List("cog", "lot", "dog"),
//  "hot" -> List("lot", "dot", "hit"),
//  "hit" -> List("hot"),
//  "dot" -> List("lot", "dog", "hot"),
//  "lot" -> List("log", "dot", "hot"))
type Vertex = String
type Graph = Map[Vertex, List[Vertex]]

def BFS(start: Vertex, g: Graph): Map[Vertex, List[Vertex]] = {
  val occ = mutable.Map[Vertex, List[Vertex]]()
  occ(start) = List()

  def bfs0(elems: List[Vertex], visited: List[List[Vertex]]): List[List[Vertex]] = {

    val newNeighbours = (elems.flatMap(g(_)) filterNot visited.flatten.contains).distinct

    for (el <- newNeighbours; el2 <- elems; if g(el).contains(el2))
      if (occ.isDefinedAt(el)) occ(el) = el2 :: occ(el) else occ(el) = List(el2)

    ////
    if (newNeighbours.isEmpty) visited
    else bfs0(newNeighbours, newNeighbours :: visited)
  }
  println("BFS",bfs0(List(start), List(List(start))))
  //(BFS,List(List(cog), List(log, dog), List(lot, dot), List(hot), List(hit)))

  occ.toMap
}
///
/* TRACE
 Map(dog -> List(dot),
 cog -> List(dog, log),
 log -> List(lot),
 hot -> List(hit),
 hit -> List(),
 dot -> List(hot),
 lot -> List(hot))
 */
val start = "hit"
val end = "cog"
val occ1 = BFS(start, g1.toMap)

def backTrack(start: Word) = {
  val result = new scala.collection.mutable.MutableList[List[Vertex]]()

  def backTrack2(result: mutable.MutableList[List[Vertex]], trace: Graph,
                 path: List[Vertex], word: Vertex): mutable.MutableList[List[Vertex]] = {

    if (trace.isDefinedAt(word)) {
      trace(word).foreach(prev => {

        val tmp = word :: path

        if (prev == start) result += List(start, word) ++ path

        backTrack2(result, trace, tmp, prev)
      })
    }

    result
  }
  backTrack2(result, occ1, List(), end)
}
// #### FINAL ///
// MutableList(
// List(hit, hot, dot, dog, cog),
// List(hit, hot, lot, log, cog))

backTrack(start)