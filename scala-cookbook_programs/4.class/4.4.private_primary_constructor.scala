/**
 * Private primary constructor to enforce the Singleton pattern
 */
class Brain private {
  override def toString = "This is the brain"
}
object Brain {
  val brain = new Brain
  def getInstance = brain
}

object SingletonTest extends App {
  //val brain = new Brain // compiler error
  val brain = Brain.getInstance
  println(brain)
}
