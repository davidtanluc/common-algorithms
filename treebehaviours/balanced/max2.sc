case class TreeNode(value:Int,left:TreeNode=null,right:TreeNode=null)

val tree1 = TreeNode(1,TreeNode(3,TreeNode(4,TreeNode(7)),TreeNode(5)),TreeNode(2))


def maxDepth1(t:TreeNode):Int ={
  if(t==null)return 0
  1 + maxDepth1(t.left) max maxDepth1(t.right)
}
////// balance

def isBalance1(t:TreeNode):Boolean ={
  if(t==null)return true
  (Math.abs(maxDepth1(t.right)-maxDepth1(t.left))<=1) && isBalance1(t.left) && isBalance1(t.right)
}

///// bottom up ///

def maxDepth2(t:TreeNode):Int={
  if(t==null)return 0

  val leftHeight = maxDepth2(t.left)
  if(leftHeight == -1)return -1
  val rightHeight = maxDepth2(t.right)
  if(rightHeight == -1)return -1

  if(Math.abs(leftHeight-rightHeight)<=1)leftHeight max rightHeight
  -1
}

def isBalance2(t:TreeNode):Boolean={
  if(t==null)return true

  if(maxDepth2(t) == -1)return false

  true

}