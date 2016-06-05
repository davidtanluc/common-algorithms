def fibonacci1(n:Int)= {
  lazy val fibs: Stream[BigInt] =
    0 #::
      1 #::
      (fibs zip fibs.tail).map { case (a, b) => a + b }
  fibs(n)
}
println(fibonacci1(10))
def fibonacci2(n:Int)={
  lazy val fibs: Stream[Int] = 0 #::
                                   fibs.scan(1)(_ + _) // use scan or scanleft
  fibs(n)
}
println(fibonacci2(10))
