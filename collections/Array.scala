/**
 *  Arrays are mutable, indexed collections of values. Array[T] is Scala's
 *  representation for Java's T[].
 *
 * constructor
 *  new Array(_length: Int)
 */
object Array extends App {
  val a = Array(1, 2, 3, 4, 5)
  
  /**
   * def addString(b: StringBuilder): StringBuilder
   * 
   * b        string builder to which elements are appended
   * returns  string builder b to which elements were appended
   */
  val b = new StringBuilder
  val aStr = a.addString(b) // 12345
  println(aStr)

  /**
   * def addString(b: StringBuilder, sep: String): StringBuilder
   */
  val b1 = new StringBuilder
  val aStr1 = a.addString(b1, ", ") // 1, 2, 3, 4, 5
  println(aStr1)

  /**
   * def addString(b: StringBuilder, start: String, sep: String, end: String): StringBuilder
   */
  val b2 = new StringBuilder
  val aStr2 = a.addString(b2, "Array(", ", ", ")") // 1, 2, 3, 4, 5
  println(aStr2)

  /**
   * def aggregate[B](z: ⇒> B)(seqop: (B, T) ⇒> B, combop: (B, B) ⇒> B): B
   */
  val agg = a.aggregate(0) (
    { (acc, value) => acc + value },
    { (acc1, acc2) => acc1 + acc2 }
  )
  println(agg)  // 15

  /**
   * def canEqual(that: Any): Boolean
   */
  val c = Array(1, 2, 3, 4, 5)
  val isEqual = c.canEqual(a) // true
  println(isEqual)

  /**************************************************************************
   * Map operations map, flatMap, and collect, which produce a new collection
   * by applying some function to collection elements.
   */

  /**
   * def map[B](f: (A) => B): Array[B]
   *
   * Builds a new collection by applying a function to all elements of
   * this array
   */
  val fruits = Array("apple", "banana", "orange")
  val fruitsInCaps = fruits.map(_.toUpperCase) // Array[String]("APPLE", "BANANA", "ORANGE")
  println(fruitsInCaps.mkString(", "))

  /**
   * def flatMap[B](f: (A) => GenTraversableOnce[B]): Array[B]
   */
  val fruitsInChars = fruits.flatMap(_.toUpperCase) // Array[Char](A,P,P,L,E,B,A,N,A,N,A,O,R,A,N,G,E)
  println(fruitsInChars.mkString(", "))

  // Option/Some/None classes
  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }
  val strings = Array("1", "2", "foo", "3", "bar")
  val stringsMap = strings.map(toInt) // Array(Some(1), Some(2), None, Some(3), None)
  val stringsFlatMap = strings.flatMap(toInt) // Array(1, 2, 3)
  println(stringsMap.mkString(", "))
  println(stringsFlatMap.mkString(", "))
  println(stringsFlatMap.sum) // 6

  /**
   * def collect[B](pf: PartialFunction[A, B]): Array[B]
   *
   * Builds a new collection by applying a partial function to all elements
   * of this sequence on which the function is defined
   */
  val d = Array(0, 1, "2", "3", Some(4), Some("5"))
  val pf: PartialFunction[Any, Int] = {
    case i: Int => i
    case s: String => s.toInt
    case Some(s: String) => s.toInt
  }
  d.collect(pf).foreach(println) // 0 1 2 3 4 5

  /**************************************************************************
   * Conversions toArray, toList, toIterable, toSeq, toIndexedSeq, toStream,
   * toSet, toMap, which turn a Traversable
   */
  val numbers = Array(1, 2, 3, 4, 5)  // numbers: Array[Int]
  println(numbers.mkString(", "))
  val arrayOfNums = numbers.toArray
  println(arrayOfNums.mkString(", "))

  val listOfNums = numbers.toList // listOfNums: List[Int] = List(1, 2, 3, 4, 5)
  println(listOfNums)

  val iterable = numbers.toIterable // iterable: Iterable[Int] = WrappedArray(1, 2, 3, 4, 5)
  println(iterable)

  val seq = numbers.toSeq // seq: Seq[Int] = WrappedArray(1, 2, 3, 4, 5)
  println(seq)

  val indexedSeq = numbers.toIndexedSeq // indexedSeq: IndexedSeq[Int] = Vector(1, 2, 3, 4, 5)
  println(indexedSeq)

  val stream = numbers.toStream // stream: Stream[Int] = Stream(1, ?)
  println(stream)

  val set = numbers.toSet // set: Set[Int] = Set(5, 1, 2, 3, 4)
  println(set)

  val pairs = Array((1, "a"), (2, "b"), (3, "c"))
  val map = pairs.toMap // map: Map[Int, String] = Map(1 -> a, 2 -> b, 3 -> c)
  println(map)

  /**************************************************************************
   * Copying operations copyToBuffer and copyToArray. As their names imply, these
   * copy collection elements to a buffer or array, respectively.
   */
  /**
   * def copyToArray(xs: Array[A], start: Int, len: Int): Unit
   * def copyToArray(xs: Array[A], start: Int): Unit
   * def copyToArray(xs: Array[A]): Unit
   */
  val a1 = new Array[Int](6)
  a.copyToArray(a1, 2, 3) // 0 0 1 2 3 0
  println(a1.mkString(", "))

  /**
   * def copyToBuffer[B >: A](dest: Buffer[B]): Unit
   */
  val buff = new collection.mutable.ArrayBuffer[Int]()
  a.copyToBuffer(buff)
  println(buff.mkString(", "))

  /**************************************************************************
   * Element retrieval operations head, last, headOption, lastOption, and find
   */
  // val a = Array(1, 2, 3, 4, 5)
  println(a.head)

  /**
   * def combinations(n: Int): collection.Iterator[Array[T]]
   */
  val str = "abbbc"
  val combs = str.combinations(2) // Array(ab, ac, bb, bc)
  println(combs.mkString(", "))

  /**
   * def contains[A1 >: A](elem: A1): Boolean
   */
  println(a.contains(5)) // true
  println(a.contains(6)) // false

  /**
   * def containsSlice[B](that: GenSeq[B]): Boolean
   *
   * Tests whether this mutable indexed sequence contains a given sequence
   * as a slice.
   */
  println(a.containsSlice(Array(1, 2, 3))) // true
  println(a.containsSlice(Array(1, 2, 4))) // false

  /**
   * def count(p: (T) => Boolean): Int
   *
   * Counts the number of elements in the mutable indexed sequence which
   * satisfy a predicate.
   */
  println("even elements count: " + a.count(_ % 2 == 0))
  println("odd  elements count: " + a.count(x => x % 2 != 0))

  /**
   * def deep: collection.IndexedSeq[Any]
   */
  val deepString = Array(Array(1, 2), Array(3, 4)).deep.toString
  println(deepString)

  /**
   * def diff(that: collection.Seq[T]): Array[T]
   * 
   * Computes the multiset difference between this array and another
   * sequence.
   */
  val low = Array(1, 2, 3, 4, 5)
  val med = Array(      3, 4, 5, 6, 7)
  val lmDiff = low.diff(med) // Array(1, 2)
  val mlDiff = med.diff(low) // Array(6, 7)
  println(lmDiff.mkString(", "))
  println(mlDiff.mkString(", "))

  /**
   * def distinct: Array[T]
   *
   * Builds a new mutable indexed sequence from this mutable indexed
   * sequence without any duplicate elements.
   */
  val d1 = Array(1, 2, 1, 3, 2, 3, 4, 5, 5)
  val d1Dist = d1.distinct // Array(1, 2, 3, 4, 5)
  println(d1Dist.mkString(", "))

  /**
   * def drop(n: Int): Array[T]
   * Selects all elements except first n ones.
   * 
   * def dropRight(n: Int): Array[T]
   * Selects all elements except last n ones.
   *
   * def dropWhile(p: (T) ⇒ Boolean): Array[T]
   * Drops longest prefix of elements that satisfy a predicate.
   */

  /**
   * def filter(p: (T) ⇒ Boolean): Array[T]
   * Selects all elements of this mutable indexed sequence which satisfy
   * a predicate.
   */
  val f = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val fEven = f.filter(_ % 2 == 0) // Array(2, 4, 6, 8, 10)
  println(fEven.mkString(", "))

  /**
   * def flatten[U](implicit asTrav: (T) => collection.Traversable[U],
   *                m: ClassTag[U]): Array[U]
   *
   * Flattens a two-dimensional array by concatenating all its rows into
   * a single array.
   */
  val aoa = Array(Array(1, 2), Array(3, 4))
  val aoaToArray = aoa.flatten // Array(1, 2, 3, 4)
  println(aoaToArray.mkString(", "))

  val aos = Array("Hello", "World")
  val aoc = aos.flatten // Array[Char](H, e, l, l, o, W, o, r, l, d)
  println(aoc.mkString(", "))

  val optionVals = Array(Some(1), None, Some(3), None)
  val intVals = optionVals.flatten // Array[Int](1, 3)
  println(intVals.mkString(", "))

  /**
   * def groupBy[K](f: (T) ⇒ K): Map[K, Array[T]]
   *
   * Partitions this mutable indexed sequence into a map of mutable indexed
   * sequences according to some discriminator function
   */
  val groups = (1 to 20).toArray groupBy {
    case i if (i < 5)  => "g1"
    case i if (i < 10) => "g2"
    case i if (i < 15) => "g3"
    case _ => "g4"
  }
  // groups: scala.collection.immutable.Map[String,Array[Int]] =
  //    Map(g3 -> Array(10, 11, 12, 13, 14), 
  //        g2 -> Array(5, 6, 7, 8, 9), 
  //        g1 -> Array(1, 2, 3, 4), 
  //        g4 -> Array(15, 16, 17, 18, 19, 20))
  groups.foreach(group => println(group._1 + " => " + group._2.mkString(", ")))
  
  val mods = (1 to 20).toArray groupBy(_ % 4)
  mods.foreach(mod => println(mod._1 + " => " + mod._2.mkString(", ")))

  /**
   * def partition(p: (T) ⇒ Boolean): (Array[T], Array[T])
   * Partitions this mutable indexed sequence in two mutable indexed
   * sequences according to a predicate.
   */
  val numbers1 = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  // numbers1: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val parts = numbers1.partition(_ % 2 == 0)
  // parts: (Array[Int], Array[Int]) = (Array(2, 4, 6, 8, 10),Array(1, 3, 5, 7, 9))
  println(parts._1.mkString(", "))
  println(parts._2.mkString(", "))

  /**
   * def permutations: collection.Iterator[Array[T]]
   *
   * Iterates over distinct permutations.
   */
  val nums = Array(1, 2, 3)
  val perms = nums.permutations.toArray
  // perms: Array[Array[Int]] = Array(Array(1, 2, 3), Array(1, 3, 2), Array(2, 1, 3),
  //                                  Array(2, 3, 1), Array(3, 1, 2), Array(3, 2, 1))
  val permsMap = perms.map(arr => arr.mkString)
  // permsMap: Array[String] = Array(123, 132, 213, 231, 312, 321)
  println(permsMap.mkString(", "))

  /**
   * def reduce[A1 >: A](op: (A1, A1) => A1): A1
   *  
   * Reduces the elements of this mutable indexed sequence using the specified
   * associative binary operator.
   */
  val aoChars = Array("A", "B", "C")
  // aoChars: Array[String] = Array(A, B, C)
  println(aoChars.reduce(_ + _)) // "ABC"
  
  val aoNums = Array(12, 6, 15, 2, 20, 9)
  println(aoNums.reduce(_ min _)) // 2
  println(aoNums.reduce(_ max _)) // 20
  println(aoNums.reduce(_ + _)) // 64

  val peeps = Vector("al", "hannah", "emily", "christina", "aleka")
  val peepsMax = peeps.reduce((x, y) => if(x.length > y.length) x else y)
  println(peepsMax)

  /**
   * def reduceLeft[B >: A](op: (B, T) => B): B
   * Applies a binary operator to all elements of this mutable indexed sequence,
   * going left to right.
   *
   * def reduceRight[B >: A](op: (T, B) => B): B
   * Applies a binary operator to all elements of this mutable indexed sequence,
   * going right to left.
   */
  // calculate min value from collection
  val aoStrs = Array("one", "two", "three")
  val leftMin = aoStrs.reduceLeft((result, element) =>
                    if (element.length < result.length) element else result)
  println(leftMin)
  val rightMin = aoStrs.reduceRight((element, result) =>
                    if (element.length < result.length) element else result)
  println(rightMin)
}
