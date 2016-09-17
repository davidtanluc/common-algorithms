case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

val NodeAll = TreeNode(1, TreeNode(2, TreeNode(4, TreeNode(7)), TreeNode(5)),
  TreeNode(3, TreeNode(6, TreeNode(8), TreeNode(9))))
val f1 = List(NodeAll)

def solution(root:TreeNode): List[Any] ={
  if(root==null)return List()

  def loop1(result:List[Any],queue:List[TreeNode]): List[Any] ={
    if(queue.head ==null)return  result//end
    //// dequeue ///
    val left = queue match {
        case (l::xs1) if l.left !=null => (l.left.value,l.left)
        case _ =>(null,null) //do nothing
      }
    val right = queue match {
      case (l::xs1) if l.right !=null => (l.right.value,l.right)
      case _ => (null,null) //do nothing
    }

    val out = queue match{
      case(x::xs1)=>xs1++List(left._2)++List(right._2)
      case _ =>List()++List(left._2)++List(right._2)
    }
    ///// result ///////////
    (left._1,right._1) match{
      case(null,null)=>loop1(result,out)
      case(null,r)=>loop1(result++List(r),out)
      case(l,null)=>loop1(result++List(l),out)
      case(l,r)=>loop1(result++List(l)++List(r),out)
    }
  }
  ///// starts here ///////////////
  loop1(List(root.value),List(root))
}
solution(NodeAll)