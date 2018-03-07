object MainObject {
  def main(args: Array[String]) {
    val foo = """This is
    a multiline
    String"""
    println(foo)
    println("--------- 1")

    val speech1 = """Four score and
    |seven years ago""".stripMargin
    println(speech1)
    println("--------- 2")

    val speech2 = """Four score and
    #seven years ago""".stripMargin('#')
    println(speech2)
    println("--------- 3")

    // convert multiline string into one continuous line
    val s = """This is known as a
    |"multiline" string
    |or 'heredoc' syntax.""".stripMargin.replaceAll("\n", " ")
    println(s)
    println("--------- 4")
  }
}
