object MainObject extends App {
  // immutable maps
  val states_imm = Map("AL" -> "Alabama", "AK" -> "Alaska")
  states_imm.foreach{
    case (k, v) => println(k, v)
  }

  // mutable maps
  var states_mut = collection.mutable.Map[String, String] ()
  states_mut += ("AL" -> "Alabama")
}
