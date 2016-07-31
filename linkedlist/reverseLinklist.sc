case class LinkedNode(value:Int,var next:LinkedNode=null)

val ll1 = LinkedNode(1,LinkedNode(2,LinkedNode(3,LinkedNode(4,LinkedNode(5)))))

reverseLinkedList(ll1)
//res0: LinkedNode =
// LinkedNode(5,LinkedNode(4,LinkedNode(3,LinkedNode(2,LinkedNode(1,null)))))

def reverseLinkedList(head:LinkedNode):LinkedNode ={
  if(head==null || head.next==null)return head

  val second = head.next
  head.next = null

  val rest = reverseLinkedList(second)

  second.next = head

  rest

}

