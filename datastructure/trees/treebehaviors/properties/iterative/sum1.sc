import scala.collection.mutable

case class Node(var data: Int, var left: Node = null, var right: Node = null)

def sumofLeaves(node: Node): Int = {

  if (node == null) return 0
  val q = mutable.Queue[Node]()
  q.enqueue(node)
  var sum1: Int = 0

  while (true) {

    var nodeCount: Int = q.size
    if (nodeCount == 0) return sum1 //#end

    while (nodeCount > 0) {

      val newnode = q.dequeue()
      sum1 += newnode.data
      //println(sum1)
      if (newnode.left != null) q.enqueue(newnode.left)
      if (newnode.right != null) q.enqueue(newnode.right)

      nodeCount -= 1
    }
  }
  //
  sum1
}

solution()
def solution()={
  val root = Node(1)
  root.left = Node(2)
  root.right = Node(3)
  root.left.left = Node(4)
  root.left.right = Node(5)
  println("Sum  of tree is " + sumofLeaves(root))//Sum  of tree is 15
}


/*

                          1
                        /   \
                      2      3
                    /   \    /  \
                   4    5

 */