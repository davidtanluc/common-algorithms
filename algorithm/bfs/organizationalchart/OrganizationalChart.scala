import java.util
import scala.collection.mutable

/*
                        person (0)

                   /                    \
              doctor  (1)                athlete (2)

          /        \                  /         /            \
    md  (3)        phd  (4)      baseball(5)   football(6)     basketball(7)

0 -> 1,2
1 -> 3,4
2 -> 5,6,7

Traversal
 */
object OrganizationalChart {
  type Vertex = String
  type Graph = Map[Vertex, List[Vertex]]

  private def BFS(adj: Map[Vertex, List[Vertex]], s: String) = {

    /** BFS: add all vertices on same layer before next layer. */
    val q = mutable.Queue[Vertex]()
    q.enqueue(s)
    val visited = new util.ArrayList[String]()
    visited.add(s)

    while (q.nonEmpty) {

      val u = q.dequeue()

      if (adj.isDefinedAt(u)) {
        for (v <- adj(u); if !visited.contains(v)) {
          q.enqueue(v)
          visited.add(v)
        }
      }
    }
    println(visited.toArray.toList)//List(person, doc, athlete, md, phd, baseball, football, basketball)

  }

/////////////////////////////
def main (args: Array[String] ) {
  //val occ = Map (0 -> List (1, 2), 1 -> List (3, 4), 2 -> List (5, 6, 7) )
  val occ2 = Map ("person" -> List ("doc", "athlete"), "doc" -> List ("md", "phd"), "athlete" -> List ("baseball", "football", "basketball") )

  println (BFS(occ2, "person") )

}
}
