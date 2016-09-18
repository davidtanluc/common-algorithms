import scala.collection.mutable

case class Node(var data: Int, var left: Node = null, var right: Node = null)


def treeHeight(node: Node): Int = {

  if (node == null) return 0
  val q = mutable.Queue[Node]()
  q.enqueue(node)

  var height: Int = 0

  while (true) {

    var nodeCount: Int = q.size
    if (nodeCount == 0) return height //#end
    height += 1

    while (nodeCount > 0) {

      val newnode = q.dequeue()
      if (newnode.left == null) q.enqueue(newnode.right)
      if (newnode.right == null) q.enqueue(newnode.left)

      nodeCount -= 1
    }
  }
  //
  height
}

solution()
def solution()={
  val root = Node(1)

  root.left = Node(2)
  root.right = Node(3)
  root.left.left = Node(4)
  root.left.right = Node(5)

  println("Min Height of tree is " + treeHeight(root)) //1

}


/*

                          1
                        /   \
                      2      3
                    /   \    /  \
                   4    5

 */