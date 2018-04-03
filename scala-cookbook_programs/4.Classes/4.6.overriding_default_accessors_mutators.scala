class Person(private var _name: String) {
  def name = _name // accessor
  def name_= (n: String) { _name = n } // mutator
}

object OverrideTest extends App {
  val p = new Person("Jonathan")
  p.name = "Jony"
  println(p.name)
}
