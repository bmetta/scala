/**
 * Example is a linkedlist implementation
 *             
 *            (trait)                    (trait)
 *             Node[+B]                    Bird
 *            /      \                   /      \
 *           /        \                 /        \
 *       ListNode[+B] Nil[+B]       African     European
 *     (case class) (case class)    Swallow     Swallow
 *       head                      (case class) (case class)
 *       tail
 *
 *  Nil reprasents an empty element (i.e. an empty list)
 *  ListNode is a node which contains an element of type B
 *    and a reference to the rest of the list (tail)
 */
object LowerTypeBounds extends App {
}
