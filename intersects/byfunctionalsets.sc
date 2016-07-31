type Set = Int => Boolean

/**
  * Indicates whether a set contains a given element.
  */
def contains(s: Set, elem: Int): Boolean = s(elem)

/**
  * Returns the set of the one given element.
  */
def singletonSet(elem: Int): Set = input => elem == input


/**
  * Returns the union of the two given sets,
  * the sets of all elements that are in either `s` or `t`.
  */
def union(s: Set, t: Set): Set = input => s(input) || t(input)

/**
  * Returns the intersection of the two given sets,
  * the set of all elements that are both in `s` and `t`.
  */
def intersect(s: Set, t: Set): Set = input => s(input) && t(input)

val s1 = singletonSet(1)
val s2 = singletonSet(2)
val s3 = singletonSet(3)

val s = union(s1, s2) //1,2
val t = union(s1, s3)
val i = intersect(s,t)

