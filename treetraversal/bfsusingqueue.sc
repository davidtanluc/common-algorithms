import java.util

import scala.collection.mutable

case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

val NodeAll = TreeNode(1, TreeNode(2, TreeNode(4, TreeNode(7)), TreeNode(5)),
  TreeNode(3, TreeNode(6, TreeNode(8), TreeNode(9))))

bfs1(NodeAll)//res0: java.util.ArrayList[Int] = [1, 2, 3, 4, 5, 6, 7, 8, 9]


def bfs1(t: TreeNode): util.ArrayList[Int] = {
  val q = mutable.Queue[TreeNode]()
  val result = new util.ArrayList[Int]

  if (t == null) return result
  result.add(t.value)
  q.enqueue(t)

  while (q nonEmpty) {
    val root = q.dequeue()
    if (root.left != null) {
      result.add(root.left.value)
      q.enqueue(root.left)
    }
    if (root.right != null) {
      result.add(root.right.value)
      q.enqueue(root.right)
    }

  }
  result
}