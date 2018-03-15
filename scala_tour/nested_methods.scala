object NestedMethod extends App {
  def factorial(n: Int): Int = {
    def factUtil(n: Int, accumulator: Int): Int = {
      if (n <= 1) accumulator
      else factUtil(n - 1, n * accumulator)
    }
    factUtil(n, 1)
  }

  println("Factorial of 5: " + factorial(5))
  println("Factorial of 3: " + factorial(3))
}
