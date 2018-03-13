object functions extends App {
  // anonymous function (i.e. no name), that returns integer + 1
  (x: Int) => x + 1

  // function with name
  // takes one parameter
  val addOne = (x: Int) => x + 1
  println(addOne(10))

  // takes two parameter
  val add = (x: Int, y: Int) =>  + y
  println(add(10, 20))

  // takes no parameter
  val getTheAnswer = () => 42
  println(getTheAnswer())
}
