def combs[A](n: Int, l: List[A]): Iterator[List[A]] = n match {
  case _ if n < 0 || l.lengthCompare(n) < 0 => Iterator.empty
  case 0 => Iterator(List.empty)
  case n => l.tails.flatMap({
    case Nil => Nil
    case x :: xs => combs(n - 1, xs).map(x :: _)
  })
}

val B = Array(1,2,2,1,1,3,4,5,8,7,9,1,1,2,4,5,6,6,8,99,33,12)
//solution(4,A) //3
solution(25,B) //11
def solution(k:Int, A:Array[Int]):Int ={
  var max_length =0
  for(i<-A.indices){
    val l = combs(i+1,A.toList)
    for(el <- l){
      if(el.sum ==k)max_length = max_length max el.length
    }
  }
  max_length
}