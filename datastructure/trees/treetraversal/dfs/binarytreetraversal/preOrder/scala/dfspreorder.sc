import java.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)
val NodeAll = TreeNode(1, TreeNode(2, TreeNode(4, TreeNode(7)), TreeNode(5)),
  TreeNode(3, TreeNode(6, TreeNode(8), TreeNode(9))))
/*
Post
res0: java.util.ArrayList[Int] = [1, 2, 4, 7, 5, 3, 6, 8, 9]

In order
res0: java.util.ArrayList[Int] = [1, 2, 4, 7, 5, 3, 6, 8, 9]

 */

println("Node All" + preorderTraversal(NodeAll))
def preorderTraversal(root: TreeNode): ArrayBuffer[Int] = {
  val returnList = new ArrayBuffer[Int]
  if (root == null) return returnList
  val stack = mutable.Stack[TreeNode]()
  stack.push(root)
  //println("First stack : "+ stack)
  while (stack nonEmpty) {
    val n = stack.pop
    //println("First n : "+n)
    //returnList += n.value ///pre-order
    if (n.right != null) {
      stack.push(n.right)
    }
     returnList +=n.value; // in-order

    if (n.left != null) {
      stack.push(n.left)
    }
    //returnList.add(n.val); // post-order

  }
  returnList
}
///// not working /////