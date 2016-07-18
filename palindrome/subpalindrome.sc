/*
Map(a->4,b->1,aa->2)
 */

//isPalindrome("abaa")
def isPalindrome(s:String):Boolean= {
  if(s.isEmpty || s.length==1)return true
  var left = 0
  var right = s.length-1

  while(left<right){
    if(s(left)!=s(right)){
      return false
    }
    left += 1
    right -=1
  }
  true

}
val h ="aabaa"
makeDict(h)//5
//res0: scala.collection.immutable.Map[String,Int] =
// Map(a -> 4, aabaa -> 1, aba -> 1, b -> 1, aa -> 2)

def makeDict(s:String)={// a,aa,ba //3//4//5
  (for{
    j<- 1 to s.length
    i<- 0 to s.length-j
  }yield s.substring(i,i+j)).filter(isPalindrome).
    groupBy(elem=>elem).mapValues(elem=>elem.length).size
}