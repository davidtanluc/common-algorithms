
case class TreeNode(value:Int, left:TreeNode=null,right:TreeNode=null)
val tree1 = TreeNode(1,
                      TreeNode(3,
                               TreeNode(4,TreeNode(7)),TreeNode(5)),
                                                                       TreeNode(2))

///////////

//minDepth(tree1)//2
def minDepth(t:TreeNode):Int = {
  if(t==null)return 0

  if(t.left==null)return minDepth(t.right)+1
  if(t.right==null)return minDepth(t.left)+1

  1 + minDepth(t.right) min minDepth(t.left)
}