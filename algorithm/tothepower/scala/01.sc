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

/*

https://en.wikipedia.org/wiki/Exponentiation_by_squaring

base^exp;; 2^3 = 8

  1 if exp =0
  1/base^-exp if exp <0
  base * (base * base)^(exp-1)/2 if exp is odd
  base * base ^exp/2 if exp is even
}
*/

expBySquaring(2, 10)//1024
expBySquaring(2, 3)//8
expBySquaring(2, 0)//1
def expBySquaring(base: Int, exp: Int): Long = {

  if (base == 0) return 0

  exp match {
    case 0 => 1
    case 1 => base
    case x if x % 2 != 0 => base * expBySquaring(base * base, (x - 1) / 2) //odd
    case y if y % 2 == 0 => expBySquaring(base * base, y / 2) //even
  }

}


