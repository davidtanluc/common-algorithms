import com.model._

val k = "hello"

val occ = Map("Apple" -> 6, "Margarine" -> 4, "Bread" -> 2)

type Qty = Int
type Desc = String
val bN = Bundle("",Item("",0))

val bundle1 = intoNewBundle(List(),occ,bN,List(("Bread","Margarine")))
/*
res0: com.model.Bundle = Bundle(NO NAME,
WrappedArray(Bundle(NO NAME,WrappedArray
(Bundle(,WrappedArray(Item(,0))),
Combo(Bread,1,Margarine,2))), Item(Apple,4)))

 */
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
findPriceWithComboDiscount(bundle1)// 4res0: Double = 7.42 ;; 6=>9,57
def findPriceWithComboDiscount(item: Product): Double = item match {
  case Item("Apple", qty) => {
    //4 -> 4.3 ,,6-> 6.45
    val single_item_price = 1.99
    val double_item_price = 2.15

    qty % 2 * single_item_price + qty / 2 * double_item_price
  }
  case Item("Bread", qty) => qty * 2.12
  case Item("Margarine", qty) => qty * 1.00
  case Item(_, _) => 0.0 // skip not listed

  /// combo 1 buy 1 bread margarine get 1 free
  case Combo("Bread", q1, "Margarine", q2) => {
    //1,2--> 3.12 , 1,3 --> 4.12 --> 1,4 -->5.12 , 2,4->6.24
    val bread = 2.12
    val margarine = 1.00
    val diff = q2 - q1 *2 // 5 - 2
    if (diff > 0) { //to do
      q1 * bread + (q1 + diff) * margarine
    } else {
      q1 * bread + (q2 % 2 + q2 / 2) * margarine

    }
  }
  case Combo(_, _, _, _) => 0.0 // skip not listed

  case Bundle(_, leafs@_*) => leafs.map(findPriceWithComboDiscount).sum
}
findPriceNoDiscount(bundle1)//7.96 --> apple 6 => 16.06
def findPriceNoDiscount(item: Product): Double = item match {
  case Item("Apple", qty) => {println(qty);qty * 1.99}
  case Item("Bread", qty) => {println(qty);qty * 2.12}
  case Item("Margarine", qty) => qty * 1.00
  case Item(_, _) => 0.0 // skip not listed
  /// combo 1 buy 1 bread margarine get 1 free
  case Combo("Bread", q1, "Margarine", q2) => {
    val bread = 2.12
    val margarine = 1.00
    q1 * bread + q2 * margarine
  }
  case Combo(_, _, _, _) => 0.0 // skip not listed
  case Bundle(_, leafs@_*) => leafs.map(findPriceNoDiscount).sum
}

  def listInCart(item: Product, result: List[(Desc, Qty)]): List[(Desc, Qty)] = item match {

    case Item("Apple", q) => List(("Apple", q)) ++ result
    case Item("Bread", q) => List(("Bread", q)) ++ result
    case Item("Margarine", q) => List(("Margarine", q)) ++ result
    case Item(_, _) => List() ++ result // skip not listed

    case Combo("Bread", q1, "Margarine", q2) => List(("Bread", q1), ("Margarine", q2)) ++ result
    case Combo("Margarine", q2, "Bread", q1) => List(("Bread", q1), ("Margarine", q2)) ++ result
    case Combo(_, _, _, _) => List() ++ result //skip unlisted

    case Bundle(_, leafs@_*) => leafs.foldLeft(result)((acc, a) => listInCart(a, acc))

  }
  
  val productAndPrices = Map("Apple" -> List(1.99, 2.15), "Bread" -> 2.12, "Margarine" -> 1.00)
  
    def makeBundle(k1: List[Product], b: Bundle): Bundle = {
      if (k1.isEmpty) return b
      makeBundle(k1.tail, Bundle("Hello", b, k1.head))
  
    }