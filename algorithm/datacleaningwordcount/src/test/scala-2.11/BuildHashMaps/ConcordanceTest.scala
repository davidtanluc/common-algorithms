package BuildHashMaps

/**
 * Created by davidtan on 7/4/15.
 */

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 * - run the "test" command in the SBT console
 * - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class MainTest extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.8/index.html#org.scalatest.FunSuite
   *
   * Operators
   * - test
   * - ignore
   * - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  import Main._

  test("print partial values of concordance") {
    val buildHashMap = new BuildHashMap
    val mapZ = buildHashMap.buildMap(buildHashMap.parseInput("input01.txt"))
    assert(mapZ("a") == List(1, 1, 1, 0, 0, 0))
    assert(mapZ("a").length == 6)

    assert(mapZ("read") == List(1))
    assert(mapZ("read").length == 1)
    //println(mapZ)
  }


}
