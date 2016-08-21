/*
What is the maximum sub array (length) for a target number
example if target k = 4

3
1
2
3
4

Array(1,3) =>2

4
3
1
2
1
4

Array(1,2,1) => 3
 */
def flatMapSublists[A,B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
  ls match {
    case Nil => Nil
    case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
  }
def combinations[A](n: Int, ls: List[A]): List[List[A]] =
  if (n == 0) List(Nil)
  else flatMapSublists(ls) { sl =>
    combinations(n - 1, sl.tail) map {sl.head :: _}
  }
val A = Array(3,1,2,1)//3
val B = Array(1,2,2,1,1,3,4,5,8,7,9,1,1,2,4,5,6,6,8,99,33,12)
//solution(4,A) //3
solution(25,B) //11
def solution(k:Int, A:Array[Int]):Int ={
  var max_length =0
  for(i<-A.indices){
    val l = combinations(i+1,A.toList)
    for(el <- l){
      if(el.sum ==k)max_length = max_length max el.length
    }
  }
  max_length
}

