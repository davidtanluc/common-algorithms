import scala.annotation.tailrec

def fibonacc1(n:Int):BigDecimal ={
  if(n<3)return 1
  fibonacc1(n-1)+fibonacc1(n-2)
}
println(fibonacc1(10))//55

def fibonacci2(n:Int): BigDecimal ={
  @tailrec
  def loop1(next:Int,result:BigDecimal,acc:BigDecimal):BigDecimal ={
    if(next==n)return result
    loop1(next+1,acc,acc+result)
  }
  loop1(0,0,1)
}

println(fibonacci2(10))//55
