/*
    Array(2, 1, 3, 2, 3)
           -3--     3--
     2--   |   |2--|   |
     | |   |           |
     |  -1-            |
    0|                 |

 */

def solution(A: Array[Int], B: Array[Int]): Array[Int] = {
  val N = A.length
  val size = A.max max B.max
  val island = Array.fill(size + 2)(0)

  (0 until N - 1).
    filter(j => A(j) > A(j + 1)).
    foreach(j => {
      island(A(j)) += 1
      island(A(j + 1)) -= 1
    })

  //println(island.toList)//  List(0, -1, 0, 1, 0)

  island(A(N - 1)) += 1
  //println(island.toList)//List(0, -1, 0, 2, 0)


  (size to 0 by -1).
    foreach(i => island(i) += island(i + 1))

  //println(island.toList)//List(1, 1, 2, 2, 0)

  B.map(water => island(water + 1))

}
//100 %
//https://codility.com/demo/results/training5Z8XFP-YRP/
//List(1, 2, 2, 0, 2)
println(solution(Array(2, 1, 3, 2, 3), Array(0, 1, 2, 3, 1)).toList)