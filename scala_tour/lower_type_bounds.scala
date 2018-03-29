/**
 * Example is a linkedlist implementation
 *             
 *            (trait)                    (trait)
 *             Node[+B]                    Bird
 *            /      \                   /      \
 *           /        \                 /        \
 *       ListNode[+B] Nil[+B]       African     European
 *     (case class) (case class)    Swallow     Swallow
 *       head                      
 *       tail
 *
 *  Nil reprasents an empty element (i.e. an empty list)
 *  ListNode is a node which contains an element of type B
 *    and a reference to the rest of the list (tail)
 */
trait Node[+B] {
  def prepend[U >: B](element: U): Node[U]
  //def prepend[B](element: B): Node[B]
  def foreach(f: (B) => Unit): Unit = {
    this match {
      case ListNode(head, tail) => { f(head); tail.foreach(f) }
      case Nil() => {}
    }
  }
}
case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
  def prepend[U >: B](element: U): ListNode[U] = {
  //def prepend[B](element: B): ListNode[B] = {
    ListNode(element, this)
  }
  def head: B = h
  def tail: Node[B] = t
}
case class Nil[+B]() extends Node[B] {
  def prepend[U >: B](element: U): ListNode[U] = {
  //def prepend[B](element: B): ListNode[B] = {
    ListNode(element, this)
  }
}

trait Bird
class AfricanSwallow() extends Bird
class EuropeanSwallow() extends Bird
class AfricanSwallowChild() extends AfricanSwallow
class EuropeanSwallowChild() extends EuropeanSwallow

object LowerTypeBoundsTest extends App {
  /*
  val africanSwallowList = ListNode[AfricanSwallow](new AfricanSwallow, Nil())
  var birdList: Node[Bird] = africanSwallowList
  birdList = birdList.prepend(new AfricanSwallowChild)
  birdList = birdList.prepend(new EuropeanSwallow)
  birdList = birdList.prepend(new EuropeanSwallowChild)
  println(birdList)
  */
  var birdList = ListNode(new AfricanSwallow, Nil())
  birdList = birdList.prepend(new AfricanSwallowChild)
  val birdList1 = birdList.prepend(new EuropeanSwallow)
  val birdList2 = birdList1.prepend(new EuropeanSwallowChild)
  println(birdList)
  println(birdList1)
  println(birdList2)
  birdList2.foreach(println)
}
