import scala.collection.mutable.ArrayBuffer

class PandorasBox {
  case class Thing(name: String)

  var things = new ArrayBuffer[Thing]()
  
  def addThing(name: String) {
    things += new Thing(name)
  }
}

object InnerClass extends App {
  val p = new PandorasBox
  p.addThing("Evil Thing #1")
  p.addThing("Evil Thing #2")
  p.things.foreach(println)
}
