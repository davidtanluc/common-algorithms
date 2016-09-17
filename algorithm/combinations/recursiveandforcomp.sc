type Occurrences = List[(Char, Int)]
combinations(List(('a', 1), ('b', 1),('c', 1),('d', 1)))
def combinations(occurrences: Occurrences): List[List[Char]] = {
  occurrences match {
    case x if x.isEmpty => List(Nil)
    case head :: tail => head match {
      case (ch, weight) =>
        for {
          rest <- combinations(tail)
          i <- 0 to weight
        } yield if (i > 0) ch :: rest else rest
    }
  }
}
//res0: List[List[Char]] =
// List(List(),
// List(a), List(b), List(c), List(d),
// List(a, b), List(a, c), List(b, c), List(a, d), List(b, d),  List(c, d),
// List(a, b, c), List(a, b, d), List(a, c, d), List(b, c, d),
// List(a, b, c, d))

