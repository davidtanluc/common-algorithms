import scala.collection.mutable

//isISO1("foo","bar")//false
//isISO1("egg","add")//true

def isISO1(A:String, B:String):Boolean={

  val occurrences = mutable.Map[Char,Char]()
  var storeB = Set[Char]()

  for(i <- 0 until A.length){
    if(occurrences.isDefinedAt(A(i))){
      if(occurrences(A(i)) != B(i)) return false
    }else{

      if(storeB.contains(B(i)))return false ///

      occurrences(A(i)) = B(i)
      storeB += B(i)

    }
  }
  true
}