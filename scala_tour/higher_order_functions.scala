object HigherOrderFunctions extends App {
  val salaries = Seq(30000, 70000, 40000)
  // doubleSalary is a function which takes a single Int, salary, and
  // returns salary * 2
  // (parameter list) => returned
  val doubleSalary = (salary: Int) => salary * 2
  val newSalaries = salaries map (doubleSalary)
  println(newSalaries)

  // To shrink the code, we could make the function anonymous and pass
  // it directly as an argument to map
  val newSalaries2 = salaries map (salary => salary * 2)
  println(newSalaries2)

  // idiomatic way to write the same piece of code would be
  val newSalaries3 = salaries map (_ * 2)
  println(newSalaries3)


  /**
   * Functions that accept functions
   * HigherOrderFunctions is used to reduce redundant code.
   */
  object SalaryRaiser {
    def smallPromotion(salaries: List[Double]): List[Double] = {
      salaries.map(salary => salary * 1.1)
    }
    def greatPromotion(salaries: List[Double]): List[Double] = {
      salaries.map(salary => salary * math.log(salary))
    }
    def hugePromotion(salaries: List[Double]): List[Double] = {
      salaries.map(salary => salary * salary)
    }
  }

  // Extract the repeated code into a HigherOrderFunction like
  object SalaryRaiser1 {
    def promotion(salaries: List[Double], promotionFunction: Double => Double):
       List[Double] = {
      salaries.map(promotionFunction)
    }

    def smallPromotion(salaries: List[Double]): List[Double] = {
      promotion(salaries, salary => salary * 1.1)
    }
    def greatPromotion(salaries: List[Double]): List[Double] = {
      promotion(salaries, salary => salary * math.log(salary))
    }
    def hugePromotion(salaries: List[Double]): List[Double] = {
      promotion(salaries, salary => salary * salary)
    }
  }
}
