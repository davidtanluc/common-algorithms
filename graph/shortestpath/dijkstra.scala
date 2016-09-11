import java.util.Scanner
import scala.collection.mutable

/**
  * Problem Introduction
  * Now, you are interested in minimizing not the number of segments, but the total cost of a flight. For this
  * you construct a weighted graph: the weight of an edge from one city to another one is the cost of the
  * corresponding flight.
  * http://www.cs.usfca.edu/~galles/visualization/Dijkstra.html
  */
object dijkstra {

  type Vertex = Int
  type Graph = Map[Vertex, List[Vertex]]
  val INF = Int.MaxValue


  def Dijkstra (adj: mutable.Map[Vertex, List[Vertex]],
                cost: mutable.Map[Vertex, List[Vertex]],
                start: Int, end: Int):Int= {

    val n = adj.size
    val dist = new Array[Int](n)
    val visited = new Array[Boolean](n)

    for (i<- 0 until n) dist(i) = INF
    ///
    dist(start) = 0

    // Traverse each vertex outside of known region R.
    for (j<- 0 until n) {

      val minVertex = ExtractMin(dist, visited)

      if(minVertex != -1){

        visited(minVertex) = true

        for (i <- adj(minVertex).indices;
             current_vertex = adj(minVertex)(i);
             weight = cost(minVertex)(i)
             if dist(current_vertex) > dist(minVertex) + weight)
          dist(current_vertex) = dist(minVertex) + weight //increment

      }
      ///
    }
    //
    if (dist(end) == INF) -1 else dist(end)

  }


  def ExtractMin(distances: Array[Int],
                 visited: Array[Boolean]): Int = {

    var minDist = INF
    var minVertex = -1

    for (v<- distances.indices
         if !visited(v)) {

      if (distances(v) < minDist)minVertex = v

      minDist = minDist min distances(v)

    }
    ///

    minVertex
  }

  /////
  def main(args: Array[String]) {

    val scanner= new Scanner(System.in)
    val n = scanner.nextInt
    val m = scanner.nextInt

    val occ = mutable.Map[Vertex, List[Vertex]]()
    val rev = mutable.Map[Vertex, List[Vertex]]()
    val cost = mutable.Map[Vertex, List[Vertex]]()

    for (i<-0 until n) {
      occ(i) = List()
      rev(i) = List()
      cost(i) = List()
    }

    ////
    for (i<-0 until m) {
      val x = scanner.nextInt
      val y = scanner.nextInt
      val w = scanner.nextInt

      if (occ.isDefinedAt(x - 1)) occ(x - 1) =  occ(x - 1) :+ y - 1 else occ(x - 1) = List(y - 1)
      if (rev.isDefinedAt(y - 1)) rev(y - 1) =  rev(y - 1) :+ x - 1 else rev(y - 1) = List(x - 1)
      if (cost.isDefinedAt(x - 1)) cost(x - 1) =  cost(x - 1) :+ w else cost(x - 1) = List(w)

    }
    ////
    val h = scanner.nextInt - 1
    val k = scanner.nextInt - 1
    //println(occ)//   Map(2 -> List(), 1 -> List(2), 3 -> List(0), 0 -> List(1, 2))
    //println(rev)//Map(2 -> List(1, 0), 1 -> List(0), 3 -> List(), 0 -> List(3))
    //println(cost.zipWithIndex)//Map((2,List()) -> 0, (1,List(2)) -> 1, (0,List(1, 5)) -> 3, (3,List(2)) -> 2)
    println(Dijkstra(occ, cost, h, k)) //3


  }


}

/*
2 September 2016
Good job! (Max time used: 3.77/6.00, max memory used: 152174592/536870912.)
Sample 1.
https://rosettacode.org/wiki/Dijkstra%27s_algorithm#Scala
Input:
4 4
1 2 1
4 1 2
2 3 2
1 3 5
1 3
3
//Using array: 3
(dist,List(0, 3, 2, 5, 6))
FROM 0 to 4
total weight 6: 1 → 3 → 5 and 1 → 3 → 2 → 5.
0 -2 -4
0 -2-1-4
/////////////////////////////
Map(,
4 -> List(3),
3 -> List(),
2 -> List(1, 4, 3)
1 -> List(2, 3, 4)
0 -> List(1, 2))
/////////////////////////////////////
0
2
1
3
4
PATHS ARE => 0,2,1,4 or 0,2,4 or 0,2,3# , 0, 1 ,4
0-> 2 ->4
0-> 2 ->3 -> 4
Sample 1.
Input:
5 9
1 2 4
1 3 2
2 3 2
3 2 1
2 4 2
3 5 4
5 4 1
2 5 3
3 4 4
1 5

//////Output ////
6
 */