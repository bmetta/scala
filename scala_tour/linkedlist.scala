sealed trait LinkedList[+E]
case class Node[+E](val head: E, val tail: LinkedList[E]) extends LinkedList[E]
case object Empty extends LinkedList[Nothing]

object LinkedList {
  def apply[E](items: E*) : LinkedList[E] = {
    if (items.isEmpty) {
      Empty
    } else {
      Node(items.head, apply(items.tail: _*))
    }
  }
}

object List extends App {
  val listHead = LinkedList(1, 2, 3, 4, 5)
}
