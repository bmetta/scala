object MainObject extends App {
  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)
    def decrement = s.map(c => (c - 1).toChar)
    def hideAll = s.replaceAll(".", "*")
  }
  println("HAL".increment)
  println("HAL".decrement)
  println("HAL".hideAll)
}
