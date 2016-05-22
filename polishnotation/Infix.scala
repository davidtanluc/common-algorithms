val A = "4 13 5 / +"


val result = A.split(" ").foldLeft(List[Double]())(
  ////acc,elements
  (list,operator)=>(list,operator) match{
    case(x::y::xs,"*")=>(x*y)::xs
    case(x::y::xs,"/")=>(y/x)::xs
    case(x::y::xs,"+")=>(x+y)::xs
    case(x::y::xs,"-")=>(x-y)::xs
    case(ys,_)=>operator.toDouble :: ys
  }

)