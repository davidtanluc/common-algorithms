/*
  nPr -> n total items
         r total placement
   */

def permutations[T](A:List[T],r:Int):List[List[T]]={
  require(A.length > 0 && r > 0)

  r match {
    case 1 => for (el <- A) yield List(el)
    case _ => for {
      perm <- permutations(A, r - 1)
      el <- A} yield el :: perm
  }

}
//solution(List(1,2,3),3)
//res0: List[List[Int]] =
// List(List(1, 1, 1),
//      List(2, 1, 1),
//      List(3, 1, 1),

//      List(1, 1, 2),
//      List(2, 1, 2),
//      List(3, 1, 2),

//      List(1, 1, 3),
//      List(2, 1, 3),
//      List(3, 1, 3),

//      List(1, 2, 1),
//      List(2, 2, 1),
//      List(3, 2, 1),

//      List(1, 2, 2),
//      List(2, 2, 2),
//      List(3, 2, 2),
//      List(1, 2, 3),
//      List(2, 2, 3),
//      List(3, 2, 3),
//      List(1, 3, 1),
//      List(2, 3, 1),
//      List(3, 3, 1),
//      List(1, 3, 2),
//      List(2, 3, 2),
//      List(3, 3, 2),
//      List(1, 3, 3),
//      List(2, 3, 3),
//      List(3, 3, 3))