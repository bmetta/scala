class Foo {
  // Optionally, define the field as lazy if the algorithm requires a long
  // time to run.
  lazy val text = io.Source.fromFile("/etc/passwd").getLines.foreach(println)
}

object BlockOrFunctionToFieldTest extends App {
  val f = new Foo
}
