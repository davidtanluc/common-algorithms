package trees.behaviors

import scala.collection.mutable

/**
  * Created by davidtan on 9/18/16.
  */
object maxheight {

  case class Node(var data: Int, var left: Node = null, var right: Node = null)

  var root: Node = null

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
        if (newnode.left != null) q.enqueue(newnode.left)
        if (newnode.right != null) q.enqueue(newnode.right)

        nodeCount -= 1
      }
    }
    //
    height
  }

  def main(args: Array[String]) {
    val tree = maxheight

    tree.root = Node(1)
    tree.root.left = Node(2)
    tree.root.right = Node(3)
    tree.root.left.left = Node(4)
    tree.root.left.right = Node(5)

    //println(tree.root)//Node(1,Node(2,Node(4,null,null),Node(5,null,null)),Node(3,null,null))

    println("Height of tree is " + tree.treeHeight(tree.root)) //3
  }
}

/*

                          1
                        /   \
                      2      3
                    /   \    /  \
                   4    5

 */
