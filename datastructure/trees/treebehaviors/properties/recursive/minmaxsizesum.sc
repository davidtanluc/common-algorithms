case class TreeNode(value:Int,left:TreeNode=null,right:TreeNode=null)
/*
                       1
                   /       \
                  3         2
           /      \
         4         5
        /
       7
 */
val tree1 = TreeNode(1,TreeNode(3,TreeNode(4,TreeNode(7)),TreeNode(5)),TreeNode(2))
val tree2 = TreeNode(1,TreeNode(3),TreeNode(4))//
//# MAX height
maxDepth(tree1) //3
def maxDepth(t:TreeNode):Int={

  if(t.left==null && t.right == null)return 0

  if(t.left !=null)return maxDepth(t.left) + 1
  if(t.right !=null)return maxDepth(t.right) + 1

  1 + maxDepth(t.left) max maxDepth(t.right)
}

//# MIN height
minDepth(tree1)//1
def minDepth(t:TreeNode):Int={
  if(t==null)return 0

  if(t.left ==null)return minDepth(t.right) + 1
  if(t.right ==null)return minDepth(t.left) + 1

  1 + minDepth(t.left) min minDepth(t.right)
}

//#SIZE total elements or nodes
size(tree1) //6
def size(t:TreeNode):Int={ //number of elements
  if(t==null)return 0
  1 + size(t.left) + size(t.right)

}
//# SUM of leaves
sumImpl(tree1) //29
def sumImpl(root:TreeNode):Int={
  root match{
    case null =>  1
    case r => r.value + sumImpl(r.left) + sumImpl(r.right)
  }
}
