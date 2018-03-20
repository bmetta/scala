sealed trait LinkedList[+E] {
  def foreach(f: (E) => Unit): Unit = {
    this match {
      case Node(head, tail) => {
        f(head)
        tail.foreach(f)
      }
      case Empty => {}
    }
  }
  
  def map[R](f: (E) => R): LinkedList[R] = {
    this match {
      case Node(head, tail) => Node(f(head), tail.map(f))
      case Empty => Empty
    }
  }

  def foldLeft[B](accumulator: B)(op: (B, E) => B): B = {
    this match {
      case Node(head, tail) => {
        val current = op(accumulator, head)
        tail.foldLeft(current)(op)
      }
      case Empty => accumulator
    }
  }

  def reverse(): LinkedList[E] = {
    foldLeft(LinkedList[E]())((acc, item) => Node(item, acc))
  }
}
case class Node[+E](val head: E, val tail: LinkedList[E]) extends LinkedList[E]
case object Empty extends LinkedList[Nothing]

object LinkedList {
  // items: E* is a vararg (the * denotes its a sequence of Es)
  def apply[E](items: E*) : LinkedList[E] = {
    if (items.isEmpty) {
      Empty
    } else {
      // : _* is required for us to tell the compiler we are not sending in a
      // sequence of E as the first parameter but the sequence is all the
      // parameters
      Node(items.head, apply(items.tail: _*))
    }
  }
}

object List extends App {
  val listHead = LinkedList(1, 2, 3, 4, 5)
  listHead.foreach(println); // 1 2 3 4 5

  listHead.map(x => x * x).foreach(println) // 1 4 9 16 25

  println(listHead.foldLeft(0)(_ + _)) // 15

  listHead.reverse.foreach(println) // 5 4 3 2 1
}
