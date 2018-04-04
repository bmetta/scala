class Stock {
  private var price: Double = _ // Accessed by the other instances of the same type

  // Its only accessed from the objects that contains it.
  //private[this] var price: Double = _ 
  
  def setPrice(p : Double) { price = p }
  def isHigher(that: Stock): Boolean = this.price > that.price
}

object PreventSetterGetterTest extends App {
  val s1 = new Stock
  val s2 = new Stock

  s1.setPrice(20)
  s2.setPrice(100)
  println(s2.isHigher(s1))
}
