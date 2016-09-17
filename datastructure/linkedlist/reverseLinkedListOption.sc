sealed case class Node2(value: Int, var nextNode: Option[Node2] = None)

sealed case class LinkedList2(head: Node2) {

  def add(int: Int): Unit = {
    var current = head
    var next = current.nextNode
    while (next.isDefined) {
      current = next.get
      next = current.nextNode
    }
    current.nextNode = Option(Node2(int)) // to to last
  }

  override def toString: String = {
    var curr = head
    var res = head.value.toString
    while (curr.nextNode.isDefined) {
      res += "->" + curr.nextNode.get.value
      curr = curr.nextNode.get
    }
    res
  }
}

object LinkedList2 {
  def apply(n: Int*): LinkedList2 = {
    val l = LinkedList2(Node2(n.head))
    n.tail.foreach(l.add)
    l
  }
}

val l1 = LinkedList2(1, 2, 3, 4, 5) //l1: LinkedList2 = 1->2->3->4->5
reverse(l1) //res0: LinkedList2 = 5->4->3->2->1

def reverse(l: LinkedList2): LinkedList2 = {

  def rev(prev: Node2, acc: Option[Node2] = None): Node2 = prev match {

    case Node2(v, Some(next)) => rev(next, Option(Node2(v, acc)))
    case Node2(v, _) => Node2(v, acc)

  }

  LinkedList2(rev(l.head))
}