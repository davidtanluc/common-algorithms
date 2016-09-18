case class IntNode(data: Int, left: Option[IntNode] = None, right: Option[IntNode] = None) {

  def levelOrder(f: IntNode => Unit) = {

    def loop(xs: List[IntNode]): Unit = xs match {
      case Nil => None
      case node :: rest => f(node); loop(rest ++ node.left ++ node.right)
    }
    loop(List(this))

  }
}

implicit def toListIntNode(n: IntNode): Option[IntNode] = Some(n)

val tree = IntNode(1,
  IntNode(2, IntNode(4, IntNode(7)), IntNode(5)),
  IntNode(3, IntNode(6, IntNode(8), IntNode(9))))

/*
                          1
                        /     \
                      2        3
                    /   \      /
                   4     5    6
                 /           /  \
                7           8    9

 */

List(tree.levelOrder _) foreach {
  case func => {
    var s = "LevelOrder : "
    func(n => s += n.data.toString + " ")
    print(s)
  }
} //Level Order  : 1 2 3 4 5 6 7 8 9