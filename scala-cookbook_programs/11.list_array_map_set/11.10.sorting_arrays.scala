object SortMain extends App {
  val fruits = Array("cherry", "apple", "banana")
  scala.util.Sorting.quickSort(fruits)
  fruits.foreach(println)
}
