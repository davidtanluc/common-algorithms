import com.model._
val occ = Map("Apple" -> 4, "Margarine" -> 2, "Bread" -> 1)
val bN = Bundle("Nothing",Item("Banana",0))
type Qty = Int
type Desc = String

val bundle1 = intoNewBundle(List(),occ,bN,List(("Bread","Margarine")))
//bundle1: com.model.Bundle = Bundle(Single Item,WrappedArray(Bundle(This is a combo,WrappedArray(Bundle(,WrappedArray(Item(,0))), Combo(Bread,1,Margarine,2))), Item(Apple,4)))

//intoNewBundle: intoNewBundle[](val visited: List[Desc],val m1: Map[Desc,Qty],val b:
// com.model.Bundle,val comboList: List[(String, String)]) => com.model.Bundle

def  intoNewBundle(visited: List[Desc], m1: Map[Desc, Qty], b: Bundle,comboList:List[(String,String)]): Bundle= {
  if (m1.isEmpty) return b
  ////// use all combo ////
  for(el<-comboList) {
    var m2 = m1
    val l = el._1
    val r = el._2

    if (m1.isDefinedAt(l) && m1.isDefinedAt(r) && !visited.contains(l) && !visited.contains(r)) {
      val combo = ComboOrItem(l, m1(l), r, m1(r))
      m2 -= l
      m2 -= r // remove left right
      //println(m2)

      return intoNewBundle(l :: r :: visited, m2, Bundle("This is a combo", b, combo), comboList)
    }
  }
  ////////////////////////////////////////////////
  val item = m1.head._1
  val qty = m1.head._2

  item match {
    case x if visited.contains(item) => intoNewBundle(visited,m1.tail,b,comboList) //skip and go to next
    case y if !visited.contains(item) => intoNewBundle(item:: visited,m1.tail,
      Bundle("Single Item",b,ComboOrItem(item,qty)),comboList)
  }
}
price(bundle1)
def price(item: Product): Double = item match {
  case Item("Apple", qty) => {
    //4 -> 4.3 ,,6-> 6.45
    val single_item_price = 1.99
    val double_item_price = 2.15

    qty % 2 * single_item_price + qty / 2 * double_item_price
  }
  case Item("Bread", qty) => qty * 2.12
  case Item("Margarine", qty) => qty * 1.00

  case Item(_, _) => 0.0 // skip not listed

  case Combo("Bread", q1, "Margarine", q2) => {
    //1,2--> 3.12
    val bread = 2.12
    val magarine = 1.00
    if (q1 > 0) {
      q1 * bread + (q2 % 2 + q2 / 2) * magarine
    } else {
      q2 * magarine
    }
  }
  case Combo(_, _, _, _) => 0.0 // skip not listed

  case Bundle(_, leafs@_*) => leafs.map(price).sum
}