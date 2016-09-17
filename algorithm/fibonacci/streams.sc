import scala.collection.immutable.Stream.cons

def fibonacci1(n:Int)= {
  lazy val fibs: Stream[BigInt] =
    0 #::
      1 #::
      (fibs zip fibs.tail).map { case (a, b) => a + b }
  fibs(n)
}
println(fibonacci1(10))//55
def fibonacci2(n:Int)={
  lazy val fibs: Stream[Int] = 0 #::
                                   fibs.scan(1)(_ + _) // use scan or scanleft
  fibs(n)
}
println(fibonacci2(10))//55

val fibs = {
  def go(f0: Int, f1: Int): Stream[Int] = cons(f0, go(f1, f0+f1))
  go(0, 1)
}
fibs(5)//5
fibs(10)//55
