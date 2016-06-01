(1 to 5 flatMap (n=> Seq(n, n*n)))


import scala.util.control.Exception._

/**
Define a standalone(not invoked as a method on a list) map function from scratch
using explicit recursion on lists. Use only pattern matching and ::. Also fill in
suitable argument and return types in the spaces provided:
 */
def map1[A,B](f:A=>B)(xs:List[A]) : List[B] = xs match {

  case Nil => Nil
  case h :: t => f(h) :: map1(f)(t)

}

def map2[A,B](f:A=>B)(xs:List[A]) : List[B] = xs match {

  case List() => Nil
  case head :: tail => f(head) :: map2(f)(tail)

}

def map[A,B](f:A=>B)(xs:List[A])  = xs.foldLeft{
  Nil : List[B]
}{
  (r,x) => r :+ f(x)
}

/**
recursive version corresponds more naturally with foldRight
  */
def map[A,B](f:A=>B)(xs:List[A])  = xs.foldRight{
  Nil : List[B]
}{
  (x,r)=> f(x) ::r /*lazy*/
}

def map[A,B](f:A=>B)(xs:List[A])  = xs.foldRight{
  Nil : List[B]
}{
  (x,r)=> f(x) +:r /*lazy*/
}

/**
  * Based on your recursive version of map above, provide a non recursive function
  * that will behave like a map once you apply the fixpoint combinator Y to it. Hint: g
  * represents map already applied to its first argument f, so g takes and produce a
  * list.
  */

def preMap[A,B](f:A=>B)(g: List[A] => List[B])(xs:List[A]) : List[B] = xs match {
  case Nil => Nil
  case h :: t => f(h) :: g(t)
}