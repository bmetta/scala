/**
 * Any
 *      AnyVal -> Double, Float, Long, Int, Short, Byte, Char, Boolean, Unit
 *      AnyRef -> All non-value types, user-defined types
 */
object UnifiedTypes extends App {
  val list: List[Any] = List (
    "a string", // string
    732,        // integer
    'c',        // character
    true,       // boolean
    () => "an anonumous function returning a string"
  )
  list.foreach(element => println(element))
}
