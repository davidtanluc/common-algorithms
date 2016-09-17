object LinkedListDetectCycle {
  //// head of list
  var head: Node = null

  case class Node(d: Int) {
    var data = d
    var next: Node = null
  }

  def push(new_data: Int) {
    val new_node = Node(new_data)
    new_node.next = head
    head = new_node
  }

  def detectLoop: Int = {
    var slow_p = head
    var fast_p = head

    while (slow_p != null && fast_p != null && fast_p.next != null) {

      slow_p = slow_p.next
      fast_p = fast_p.next.next

      if (slow_p eq fast_p) {
        println("Found loop")
        return 1
      }
    }
    //
    println("No loop")
    0
  }

  override def toString: String = {
    var current = head
    var result = head.data.toString

    while (current.next != null) {
      result += "->" + current.next.data
      current = current.next
    }
    println(result)
    result
  }

}

solution() //"Found loop"
def solution() = {
  val llist = LinkedListDetectCycle
  llist.push(20)
  llist.push(4)
  llist.push(15)
  llist.push(10)

  //llist.toString //10->15->4->20
  /*Create loop for testing 10->15->4->20 ---> goes to 15 */
  llist.head.next.next.next.next = llist.head
  llist.detectLoop
}