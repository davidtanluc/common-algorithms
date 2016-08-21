//solution( Array(3,1,2,1),4)//3
val B = Array(1,2,2,1,1,3,4,5,8,7,9,1,1,2,4,5,6,6,8,99,33,12)
solution(B,25)//11
def solution(a:Array[Int], k:Int):Int={
  var max_length = 0
  val l1 = a.toList
  for(i <- 1 to a.length;
      combo1 = l1 combinations i toList;
      elem <- combo1;
      if(elem.sum == k))
    max_length = max_length max elem.length

  max_length
}