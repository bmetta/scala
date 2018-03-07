object MainObject extends App {
  val list1 = 1 :: 2 :: 3 :: Nil
  val list2 = List.range(1, 10)     // List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val list3 = List.range(0, 10, 2)  // List(0, 2, 4, 6, 8)
  val list4 = List.fill(3)(10)      // List(10, 10, 10)
  val list5 = List.tabulate(5)(n => n * n)  // List(0, 1, 4, 9, 16)
}
