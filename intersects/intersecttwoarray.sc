/*
Given two arrays, one with 100 elements and one with 10M elements,
how would you return an array that holds the intersection?

[1, 2]
[2, 3, 4]

[2]
 */
//// find dict for shorter array ////
val dict1 = Array(1,2).groupBy(elem=>elem).mapValues(elem=>elem.length)
//Map(2 -> 1, 1 -> 1)
val intersects = Array(2,3,4,2).filter(dict1.isDefinedAt)

Array(1,2).intersect(Array(2,3,4,2))
/*
res0: Array[Int] = Array(2)
 */
intersects
/*
res1: Array[Int] = Array(2, 2)
 */