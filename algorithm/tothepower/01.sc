import scala.annotation.tailrec

//recPower(2,3)//8
//recPower(2,2)//4
//recPower(2,0)//1
def recPower(base: Int, exp: Int): Int = {

  if (exp == 0) return 1

  base * recPower(base, exp - 1)

}

//recPowerTailRec(2,10)//1024
//recPowerTailRec(2,2)//4
//recPowerTailRec(2,0)//1
//recPowerTailRec(0,0)//1
def recPowerTailRec(base: Int, exp: Int): Int = {

  @tailrec
  def loop(acc: Int, n: Int): Int = if (n == 0) acc else loop(acc * base, n - 1)

  loop(1, exp)
}
//https://en.wikipedia.org/wiki/Exponentiation_by_squaring
///// exponential squaring /////
/*
x^n

  1 if n =0
  1/x^-n if n <0
  sqr(x.(x^(n-1)/2)) if n is odd
  sqr((x^(n)/2)) if n is odd

  function expBySquaring(x, n) {
    if (n == 1) {
        return x;
    } else if (n % 2 != 0) { // n is odd
        return x * expBySquaring(x * x, (n - 1) / 2);

    }
    else { // n is even
        return expBySquaring(x * x, n / 2);
    }
}
 */
expBySquaring(2, 10)//1024
expBySquaring(2, 3)
expBySquaring(2, 0)
def expBySquaring(base: Int, exp: Int): Long = {

  if (base == 0) return 0

  exp match {
    case 0 => 1
    case 1 => base
    case x if x % 2 != 0 => base * expBySquaring(base * base, (x - 1) / 2) //odd
    case y if y % 2 == 0 => expBySquaring(base * base, y / 2) //even
  }

}


