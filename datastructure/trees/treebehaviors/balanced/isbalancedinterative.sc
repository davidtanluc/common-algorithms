case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

val tree1 = TreeNode(1, TreeNode(3, TreeNode(4, TreeNode(7)), TreeNode(5)), TreeNode(2))
val tree2 = TreeNode(1, TreeNode(3), TreeNode(4)) //
/*
                       1
                   /       \
                  3         2
           /      \
         4         5
        /
       7
 */
/////////////////////////////////////////////
isBalanced(tree1) //false
isBalanced(tree2) //true
def isBalanced(t1: TreeNode): Boolean = {

  def loop(t: TreeNode): Int =
    if (t == null) 0
    else {
      val l = loop(t.left)
      if (l == -1) -1
      else {
        val r = loop(t.right)
        r match {
          case -1 => -1
          case _ => if (Math.abs(l - r) > 1) -1 else 1 + l max r
        }
      }
    }
  !(loop(t1) == -1)
}