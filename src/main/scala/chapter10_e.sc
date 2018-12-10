object chapter10_e {

  // ##########16 Combine map and flatten with flatMap
  def bag = List("1", "2", "three", "5", "twenty")

  // define a method that returns Some[Int] or None
  def toInt(int: String): Option[Int] = {
    try {
      Some(Integer.parseInt(int.trim))
    } catch {
      case e: Exception => None
    }
  }

  // returns list of some and None
  bag.map(toInt)
  // will also flatten so just list of integers
  bag.flatMap(toInt)


  // ##########17 Use filter to filter a collection
  // for filter a predicate(a function that returns Boolean) must be supplied
  val x = List.range(1, 100)
  x.filter(_ % 8 == 0)

  // can put the predicate in a separate method and then pass it
  def onlyStrings(a: Any) = a match {
    case s: String => true
    case _ => false
  }

  val mix = List("America", 5, "Japan", "Canada", true)
  val strings = mix.filter(onlyStrings)


  // #########18 Extract a sequence of elements from a collection
  val y = x.drop(87)
  // drop the elements as long as the predicate is true
  val z = y.dropWhile(_ < 91)
  // dropRight is the same as drop but from the end of the sequence
  val r = y.dropRight(5)

  // take extracts the first N element, and takeWhile is to extract while
  // predicate is true
  val i = y.take(4)
  val j = y.takeWhile(_ < 92)

  // slice(from, until): from is inclusive, until is exclusive
  val s = x.slice(12, 23)


  // ###########19 Split sequences into subsets (groupby/partition etc)
  val g = x.groupBy(_ % 10 == 0)

  // partition gives back two group where the predicate is (true, false)
  val p = y.partition(_ % 2 == 0)

  // span is like partition but it gives list consists of the longest prefix
  // of this list whose elements all satisfy the predicates (like while)
  val span = y.span(_ % 2 == 0) // this will be (List(88), List(the rest))

  // those groups can be accessed like followings
  val (even, odd) = y.partition(_ % 2 == 0)
  even

  val trueGroup = g(true)
  trueGroup

  // sliding(size, step) breaks a sequence into many groups
  val oddNums = x.sliding(3, 14).toList

  // unzip takes two sequences of tuple values and create two resulting seq
  val listOfPeople = List(("Aoi", "Noot"), ("Raseru", "Oskar"))
  val couples = listOfPeople.unzip
  // zip is the opposite
}