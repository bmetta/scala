object Operators extends App {
  case class Vector(val x: Double, val y: Double) {
    def +(that: Vector) = new Vector(this.x + that.x, this.y + that.y)
  }

  val v1 = Vector(1.0, 1.0)
  val v2 = Vector(2.0, 2.0)
  val v3 = v1 + v2
  println(v3.x, v3.y)
}
