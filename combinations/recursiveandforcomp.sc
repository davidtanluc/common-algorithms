type Occurrences = List[(Char, Int)]
combinations(List(('a', 1), ('b', 1),('c', 1),('d', 1)))
def combinations(occurrences: Occurrences): List[Occurrences] = {
  occurrences match {
    case x if (x.isEmpty) => List(Nil)
    case head :: tail => head match {
      case (ch, weight) =>
        for {
          rest <- combinations(tail)
          i <- 0 to weight
        } yield if (i > 0) (ch, i) :: rest else rest
    }
  }
}
//res0: List[Occurrences] =
//
// List(List(),
// List((a,1)),
// List((b,1)),
// List((c,1)),
// List((d,1)),

// List((a,1), (b,1)),
// List((a,1), (c,1)),
// List((b,1), (c,1)),
// List((a,1), (d,1)),
// List((b,1), (d,1)),
// List((c,1), (d,1)),


// List((a,1), (b,1), (c,1)),
// List((a,1), (b,1), (d,1)),
// List((a,1), (c,1), (d,1)),
// List((b,1), (c,1), (d,1)),


// List((a,1), (b,1), (c,1), (d,1)))