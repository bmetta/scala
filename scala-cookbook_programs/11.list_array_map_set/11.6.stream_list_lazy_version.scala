/**
 * Stream: like List but invokes its transformer methods (map, filter, etc)
 * lazily
 * Stream can be long, infinitely long
 * Stream constructed with #::
 */
object StreamMain extends App {
  val stream1 = 1 #:: 2 #:: 3 #:: Stream.empty // Stream(1, ?)
  // ? denotes end of the stream hasn't been evaluated yet

  val stream2 = (1 to 1000).toStream // Stream(1, ?)
  println(stream2.head, stream2.tail) // head = 1, tail = Stream(2, ?)
  println(stream2.max) // max, size, sum methods may cause java.lang.OutOfMemoryError
  println(stream2(0))  // 1
  println(stream2(1))  // 2
  println(stream2(10)) // 11
}
