/**
 * combine expressions within block {}
 * result: last expression in the overall block
 */
object Blocks extends App {
  println({
    val x = 1 + 1
    x + 1
  }) // 3
}

