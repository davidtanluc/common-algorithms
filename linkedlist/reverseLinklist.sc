case class LinkedNode(value:Int,var next:LinkedNode=null)

val ll1 = LinkedNode(1,LinkedNode(2,LinkedNode(3,LinkedNode(4,LinkedNode(5)))))

//reverseLinkedList(ll1)
def reverseLinkedList(head:LinkedNode):LinkedNode ={
  if(head==null || head.next==null)return head

  val second = head.next
  head.next = null

  val rest = reverseLinkedList(second)

  second.next = head

  rest

}
revLList(ll1)
def revLList(head:LinkedNode):LinkedNode= head match{
  case null => head
  case x if x.next==null => head
  case _ =>{
    val second = head.next
    head.next = null
    println("#HEAD",head," second ",second)

    val rest = reverseLinkedList(second)

    second.next = head
    println("#SECOND",second)


    rest
  }
}