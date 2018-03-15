/**
 * Objects aer single instances of their own definitions.
 * Think of them as singletons of their own classes
 * It is created lazily when it is referenced
 */

object IdFactory {
  private var counter = 0

  def create(): Int = {
    counter += 1
    counter
  }
}

object Object extends App {
  val id1 = IdFactory.create()
  println(id1) // 1

  val id2 = IdFactory.create()
  println(id2) // 2
}
