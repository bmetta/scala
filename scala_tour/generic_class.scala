/**
 * Generic classes take a type as a parameter within square brackets [].
 * One convention is to use the letter A as type parameter identifier
 */
class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A): Unit = { elements = x :: elements }
  def top: A = { elements.head }
  def pop: A = {
    val topVal = top
    elements = elements.tail
    topVal
  }
}

abstract class Fruit(name: String) {
  def getName = name
}
class Banana(name: String) extends Fruit(name)
class Apple(name: String) extends Fruit(name)

object GenericClass extends App {
  val stack = new Stack[Int]
  stack.push(1)
  stack.push(2)
  println(stack.pop) // 2
  println(stack.pop) // 1


  val fruitStack = new Stack[Fruit]
  fruitStack.push(new Banana("banana"))
  fruitStack.push(new Apple("apple"))
  println(fruitStack.pop.getName)
  println(fruitStack.pop.getName)
}
