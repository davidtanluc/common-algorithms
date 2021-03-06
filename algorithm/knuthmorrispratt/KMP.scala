package week3knorris

import java.util
import java.util.Scanner

/**
  * Created by davidtan on 9/5/16.
  */
object KMP {

  private def computePrefixFunction(combo: String): Array[Int] = {

    val s = new Array[Int](combo.length)
    s(0) = 0
    var border = 0

    for (i <- 1 until combo.length) {

      while (border > 0 && combo(i) != combo(border)) border = s(border - 1)

      border = if (combo(i) == combo(border)) border + 1 else  0

      s(i) = border

    }
    //
    s
  }

  private def findAllOccurences(pattern: String, text: String):List[Int] = {

    val combo = pattern + "$" + text
    val prefix = computePrefixFunction(combo)

    (for(i <- pattern.length + 1 until combo.length
          if prefix(i) == pattern.length) yield i - 2 * pattern.length).toList

  }

  def main(args: Array[String]) {
    val scanner: Scanner = new Scanner(System.in)
    val pattern = scanner.next
    val text = scanner.next
    val result =  findAllOccurences(pattern, text)
    for(a <- result)print(a+" ")
    println()

  }

  //
}
/*
Good job! (Max time used: 9.65/24.00, max memory used: 164761600/536870912.)
Input:

ATA

ATATA


0 2

/////
(prefix :,List(0, 0, 1, 2, 0, 0, 1, 2, 3, 4, 3, 4, 0, 0, 1, 2, 3, 4, 3, 0, 0, 0))

ATAT

GATATATGCATATACTT

1 3 9



///////
(prefix :,List(0, 0, 0, 1, 0, 1, 2, 3, 4, 0, 1, 0, 1, 2, 3, 4))
ABRA

ABRACADABRA

0 7
 */
