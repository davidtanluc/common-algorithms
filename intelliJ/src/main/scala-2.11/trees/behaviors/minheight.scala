package trees.behaviors

import scala.collection.mutable

/**
  * Created by davidtan on 9/18/16.
  */
object minheight {
  case class Node(var data:Int,var left:Node=null,var right:Node=null)

  private var root: Node = null

  private def treeHeight(node: Node): Int = {

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

  def main(args: Array[String]) {
    val tree = minheight

    tree.root = Node(1)
    tree.root.left = new Node(2)
    tree.root.right = new Node(3)
    tree.root.left.left = new Node(4)
    tree.root.left.right = new Node(5)

    println("Minimum height of tree is " + tree.treeHeight(tree.root))//1
  }
}
/*

                          1
                        /   \
                      2      3
                    /   \    /  \
                   4    5

 */