def find_unique_id(ids: Array[Int]) = {
  var unique_id = 0

  for (id <- ids) {

    println("B binary :", unique_id.toBinaryString," d id ",id.toBinaryString)
    //println("B:", unique_id," d id ",delivery_id)
    /*
(B:,0, d id ,1)
1
(B:,1, d id ,2)
3
(B:,3, d id ,3)
0
(B:,0, d id ,5)
5
(B:,5, d id ,6)
3
(B:,3, d id ,1)
2
(B:,2, d id ,2)
0
(B:,0, d id ,5)
5
(B:,5, d id ,3)
6
     */
    unique_id ^= id
    println(unique_id)
  }
  unique_id
}
//// find non duplicate ////
/*
d_ids: Array[Int] = Array(1, 2, 3, 5, 6, 1, 2, 5, 3)
6
 */
val d_ids = Array(1, 2, 3, 5, 6, 1, 2, 5, 3)
find_unique_id(d_ids) //6