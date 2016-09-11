val INF = Int.MaxValue
val MIN = Int.MinValue

countChangeMin(Array(1,3,5),6)//List(0, 1, 2, 1, 2, 1, 2)
def countChangeMin(coins:Array[Int],money:Int)= {
  val dp = Array(0) ++ Array.fill(money)(INF)
  for (coin <- coins;//1,3
       coin_value_to_money <- coin to money) //1..6, 3..6
    dp(coin_value_to_money) = dp(coin_value_to_money - coin) + 1 min dp(coin_value_to_money)

  dp.toList
}
countChangeMax(Array(1,3,5),6)//res1: List[Int] = List(0, 1, 2, 3, 4, 5, 6)
def countChangeMax(coins:Array[Int],money:Int)= {
  val dp = Array(0) ++ Array.fill(money)(MIN)
  for (coin <- coins;//1,3
       coin_value_to_money <- coin to money) //1..6, 3..6
    dp(coin_value_to_money) = dp(coin_value_to_money - coin) + 1 max dp(coin_value_to_money)

  dp.toList
}

countChangeWays(List(1,3,5),6)//res2: List[Int] = List(1, 1, 1, 2, 2, 3, 4)
def countChangeWays(coins:List[Int],money:Int)= {
  val ways = Array(1) ++ Array.fill(money)(0)//Array(1,0,0,0,0,0,0,0)
  for (coin <- coins;coin_value_to_money <- coin to money)
      ways(coin_value_to_money) += ways(coin_value_to_money - coin)
  ways.toList
}

greedyCoinChanging(Array(1,3,5),6)//res1: List[(Int, Int)] = List((1,1), (3,0), (5,1))
///// in this case max number of changes is 2 same as min
def greedyCoinChanging(coins:Array[Int], dollar_value :Int) = {
  coins.
    reverse.
    foldLeft((List[(Int,Int)](),dollar_value))({
      (acc,el) => {
        val k = acc._2
        ((el,k / el)::acc._1, k % el)
      }})._1

}
countChangeWaysRecursive(6,List(1,3,5))//res2: Int = 4 max number of changes
def countChangeWaysRecursive(dollar_value: Int, coins: List[Int]): Int = (dollar_value,coins) match {
  case(0,_) =>1 // if money is zero is 1
  case(_,c) if c.isEmpty =>0 //  if list is empty ends
  case(m,_) if m<0 =>0  /// if money is -ve end
  case(m,c::cs)=>countChangeWaysRecursive(m-c,coins)+ countChangeWaysRecursive(m,cs)
}