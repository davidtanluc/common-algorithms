import java.util.Scanner

import scala.collection.mutable

object WebCrawler {
  type Vertex = Int
  type Graph = Map[Vertex, List[Vertex]]

  private def distance(adj: mutable.Map[Vertex, List[Vertex]], s: Int, t: Int): Int = {

    /** BFS: add all vertices on same layer before next layer. */
    val dist = Array.fill(adj.size)(Int.MaxValue)
    dist(s) = 0

    val q = mutable.Queue[Int]()
    q.enqueue(s)

    while (q.nonEmpty) {
      val u = q.dequeue()

      for (v <- adj(u); if dist(v) == Int.MaxValue) {
        q.enqueue(v)
        dist(v) = dist(u) + 1
      }
    }
    if (dist(t) == Int.MaxValue) -1 else dist(t)
  }


  /////////////////////////////
  def main(args: Array[String]) {
    val scanner = new Scanner(System.in)
    val n = scanner.nextInt
    val m = scanner.nextInt
    val occ = mutable.Map[Vertex, List[Vertex]]()

    for (i <- 0 until m) {

      var x = 0
      var y = 0
      x = scanner.nextInt
      y = scanner.nextInt
      if (occ.isDefinedAt(x - 1)) occ(x - 1) = y - 1 :: occ(x - 1) else occ(x - 1) = List(y - 1)
      if (occ.isDefinedAt(y - 1)) occ(y - 1) = x - 1 :: occ(y - 1) else occ(y - 1) = List(x - 1)

    }
    //println(occ)
    //Map(2 -> List(0, 1), 1 -> List(2, 0), 3 -> List(0), 0 -> List(2, 3, 1))

    val x = scanner.nextInt - 1
    val y = scanner.nextInt - 1
    println(distance(occ, x, y))

  }

}

/*
4 4
1 2
4 1
2 3
3 1
2 4

Output
2

By hand
 0 -> 1
 3 -> 0
 1 -> 2
 2 -> 0
 //Map(2 -> List(0, 1), 1 -> List(2, 0), 3 -> List(0), 0 -> List(2, 3, 1))
 bi-directional
 0 <- 1
 3 <- 0
 1 <- 2
 2 <- 0

  0 ->List(1,2,3)
  1 ->List(0,2)
  2 ->List(0,1)
  3 ->List(0)

from 1 to 3 it is 2 paths
 */