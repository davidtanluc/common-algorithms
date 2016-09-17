val INF = Int.MaxValue // infinity
/// u,v,k
val Vertices = 6 // nos of vertex

def shortestPath(graph: Array[Array[Int]], start: Int, end: Int, path_vertex: Int): Int = {

  // Base cases //
  if (path_vertex == 0 && start == end) return 0
  if (path_vertex == 1 && graph(start)(end) != INF) return graph(start)(end)
  if (path_vertex <= 0) return INF

  // Initialize result
  var result = INF

  // Go to all adjacent of u and recur
  for (i <- 0 until Vertices
       if graph(start)(i) != INF && start != i && end != i;// if end = i reached
       weight = shortestPath(graph, i, end, path_vertex - 1) //move to next one
       if weight != INF)
    result = result min (graph(start)(i) + weight)

  result
}
//val B = Array.ofDim[Int](n+1,maxweight+1)
//// 0,1,2,3,4,5 /////
//List("Spain", "France", "Belgium", "Germany", "Austria", "Italy")
val graph2 = Array(
  Array(0,1,INF, INF, INF, INF),
  Array(INF, 0,3, INF, 5, 4),
  Array(INF, INF, 0, 1, INF, INF),
  Array(INF, INF, INF, 0, 3, INF),
  Array(INF, INF, INF, INF, 0, 4))
val list_of_countries = List("Spain", "France", "Belgium", "Germany", "Austria", "Italy")
def solution(start: Int, end: Int, graph: Array[Array[Int]]): Unit = {
  var minimum_weights = INF //weight
  for (i <- 0 until Vertices) {
    val shortestpath = shortestPath(graph, start, end, i)
    println(i, "i Paths : ",shortestpath)
    /*
(0,i Paths : ,2147483647)
(1,i Paths : ,2147483647)
(2,i Paths : ,5)
(3,i Paths : ,10)
(4,i Paths : ,2147483647)
(5,i Paths : ,12)
     */
    minimum_weights = minimum_weights min shortestpath
  }
  println("FINAL weights: ", minimum_weights, " ", list_of_countries(start), " to ", list_of_countries(end))
}
//solution(1, 5,graph2) //france to italy
solution(0, 5,graph2) //spain to italy
////// bidirectional ///
val graph3 = Array(
  Array(0, 1, INF, INF, INF, INF),//itself weight is zero, not connected is INF
  Array(1, 0, 3, INF, 5, 4),
  Array(INF, 3, 0, 1, INF, INF),
  Array(INF, INF, 1, 0, 3, INF),
  Array(INF, INF, INF, 3, 0, 4))

//solution(0, 5,graph3)
/*
Single direction
(FINAL,5, ,Spain, to ,Italy)
Bi-Direction
(FINAL,5, ,Spain, to ,Italy)
 */
/*
val occ = Map("Spain"
val listcountries = List("Spain", "France", "Belgium", "Germany", "Austria", "Italy")
val listcountries =Spain -0, France -1 , Belgium-2, Germany-3, Austria-4 , Italy-5
           1 (weights)
       (0) ---> (1)
                      \   \
            3    |    |   |
                 |    |   |
                      5   |
                (2)   |   |
            1    |    |   |
                 |    |   | 4 (w)
                (3)<--    |
            3    |        |
                 |        |
                (4)       |
            5    |        |
                 |        |
                (5)<------
 */