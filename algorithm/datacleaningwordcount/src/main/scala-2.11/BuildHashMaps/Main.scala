package BuildHashMaps

import scala.collection.immutable.TreeMap
/**
 * Created by davidtan on 7/4/15.
 */
sealed trait Tokens {
  // RegEx remove ,"-:
  def parseInput(in: String): Array[String] = {
    io.Source.fromFile(in).mkString.replaceAll("[,\\(\"\\)\\-\\:]", "").split("\\s+")
  }
}

class BuildHashMap extends Tokens {
  def buildMap(words: Array[String]): TreeMap[String, List[Int]] = {
    var freq = new scala.collection.immutable.TreeMap[String, List[Int]]
    var count = 0
    words.foreach { token =>
      val temp = if (token.count(_ == '.') == 1) token.dropRight(1).toLowerCase else token.toLowerCase // find full stop and remove
      freq = freq + (temp -> (count :: freq.getOrElse(temp, List())))
      if (token.indexOf(".") == token.length - 1) count += 1; //count by full stop
    } // foreach no side effect
    freq //return freq
  }
}

object Main extends App {
  val buildHashMap = new BuildHashMap
  val mapZ = buildHashMap.buildMap(buildHashMap.parseInput("input01.txt"))
  val rr = mapZ foreach { case (key, value) =>
    println(key + "<---{" + value.length + ":" + value.mkString(",") + "}")
  }
}


