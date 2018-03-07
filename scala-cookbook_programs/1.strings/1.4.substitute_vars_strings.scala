/**
 * String interpolation: precede your string with the letter s and
 * include your variables inside the string, with each variable name
 * preceded by a $ character.
 */
object MainObject extends App {
  var name = "Fred"
  var age = 30
  var weight = 6

  println(s"$name is $age years old and weight $weight ft")
  println("------- 1")

  // expression in string literals
  println(s"Age next year is ${age + 1}")
  println(s"$name is 30 year old: ${age == 30}")
  println("------- 2")


  case class Student(name: String, id: Int)
  val hannah = Student("hannah", 20)
  println(s"${hannah.name} id ${hannah.id}")

  // The f string interpolator (printf style formatting)
  println(f"$name is $age years old and weight $weight%.2f ft")
  println(f"$name is $age years old and weight $weight%.0f ft")
  println("------- 3")

  // raw interpolator
  println(s"foo\nbar")
  println(raw"foo\nbar")
  println("------- 4")

  // user defined interpolator
  println("%s is %d years old and weight %d ft".format(name, age, weight))
  println("------- 5")
}
