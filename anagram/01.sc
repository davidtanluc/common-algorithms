var C = Array("ate", "eat", "java", "apple", "jaav", "aet")


type Word = String
type Occurrences = List[(Char,Int)] //key , value

def anagramword(s:String):Occurrences = s.toLowerCase.toList.groupBy(elem=>elem).mapValues(elem=>elem.length).toList.sorted//map1
//anagramword("ate")//res0: Occurrences = List((a,1), (e,1), (t,1))
def findAnagramWordsinList(A:Array[String]) = A.groupBy(anagramword).mapValues(elem=>elem.length)//map2
findAnagramWordsinList(C)
/*
res1: scala.collection.immutable.Map[Occurrences,Int] =
 Map(List((a,1), (e,1), (l,1), (p,2)) -> 1, List((a,2), (j,1), (v,1)) -> 2, List((a,1), (e,1), (t,1)) -> 3)
s
 */
solution(C)//res0: Array[String] = Array(ate, eat, java, jaav, aet)
def solution(A:Array[String]):Array[String]={
  if(A.isEmpty)return Array()

  val dict1 = findAnagramWordsinList(A)

  A.filter(token=>{
    val tokeninanagram = anagramword(token)
    dict1.isDefinedAt(tokeninanagram) && dict1(tokeninanagram)>1
  })

}