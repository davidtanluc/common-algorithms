case class TreeNode(value:Int,left:TreeNode=null,right:TreeNode=null)

val tree1 = TreeNode(1,TreeNode(3,TreeNode(4,TreeNode(7)),TreeNode(5)),TreeNode(2))
val tree2 = TreeNode(1,TreeNode(3),TreeNode(4))//
/*
                       1
                   /       \
                  3         2
           /      \
         4         5
        /
       7
 */
maxDepth1(tree1)//4
maxDepth1(tree2)//2
def maxDepth1(t:TreeNode):Int ={
  if(t==null)return 0
  1 + maxDepth1(t.left) max maxDepth1(t.right)
}
////// balance
isBalance1(tree1) //false
isBalance1(tree2) //true
def isBalance1(t:TreeNode):Boolean ={
  if(t==null)return true
  (Math.abs(maxDepth1(t.right)-maxDepth1(t.left))<=1) && isBalance1(t.left) && isBalance1(t.right)
}

///// bottom up ///
maxDepth2(tree1)//-1
maxDepth2(tree2)//-1
def maxDepth2(t:TreeNode):Int={
  if(t==null)return 0

  val leftHeight = maxDepth2(t.left)
  if(leftHeight == -1)return -1
  val rightHeight = maxDepth2(t.right)
  if(rightHeight == -1)return -1

  if(Math.abs(leftHeight-rightHeight)<=1)leftHeight max rightHeight
  -1
}
isBalance2(tree1) //false
def isBalance2(t:TreeNode):Boolean={
  if(t==null)return true
  if(maxDepth2(t) == -1)return false

  true

}
isBalanced(tree1) //false
isBalanced(tree2) //true
def isBalanced(t1: TreeNode): Boolean = {

  def loop(t: TreeNode): Int =
    if (t ==null) 0
    else {
      val l = loop(t.left)
      if (l == -1) -1
      else {
        val r = loop(t.right)
        r match {
          case -1 =>  -1
          case _ =>  if (Math.abs(l - r) > 1) -1 else 1 + l max r
        }
      }
    }
  !(loop(t1) == -1)
}