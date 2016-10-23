
val xs = List(1,2,3)


def combo(xs:List[Int],weight:Int):List[List[Int]]= xs match{
  case Nil => List(Nil) //# end
  case h::tail =>
    for(rest <- combo(tail,weight);
        i<- 0 to weight) yield
      if (i > 0) h :: rest else rest

}
println(combo(xs,1))
/*
List(
List(), List(1), List(2), List(1, 2),
 List(3), List(1, 3), List(2, 3),
 List(1, 2, 3))

 */