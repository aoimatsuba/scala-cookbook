import scala.collection.mutable.ListBuffer

object chapter11_a {

  // #########1　Create and populate List
  val list = 1 :: 2 :: 3 :: Nil
  val list2 = List(2, 4, 6)
  val list3 = List[Double](4, 6, 3)

  // use range
  val listR = List.range(1, 10)
  val listRS = List.range(1, 20, 3)

  // fill the list with certain values
  val listF = List.fill(4)("something")

  // element values determined by a function
  val listT = List.tabulate(5)(n => n * n * 10)

  // string to list
  "Noot".toList


  // ##########2 Create a mutable list
  // use a ListBuffer and then convert

  val listB = new ListBuffer[String]()
  listB += "japan"
  listB += "Taiwan"
  listB += "Germany"

  listB += "USA, Australia, Canada"

  listB.toList


  // ##########3 Adding elements to a List
  // prepend elements to create a new List

  val x = List(1, 3)
  val y = 0 :: x
  val z = -1 :: y

  // just use var and reassign the result to it
  var v = List(2, 4)
  v = 0 :: v

  // There are other methods that prepend or append single element
  val l = List(1, 2, 3)
  val k = 0 +: l

  // following doesn't work because :+ is a member of List but not int
  // val kl = 0 :+ l
  val h = l :+ 4


  // ##########4 Delete elements from List
  // instead of deleting elements, it can filter out the elements
  val originalList = List.range(1, 20)
  val newList = originalList.filter(x => x % 2 == 0)

  // or just declare original list as var
  // or use ListBuffer
  val listBuffer = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8)
  listBuffer -= 3
  listBuffer -= (1, 8)
  listBuffer.remove(0)

  // or remove by sequence using --=
  listBuffer --= Seq(5, 6)


  // ##########5 Merge (concatenate) Lists
  val odd = List(1, 3, 5)
  val even = List(2, 4, 6)

  val combined = odd ++ even
  val combinedColon = odd ::: even
  val combinedConcat = List.concat(odd, even)


  // ##########6 Using Stream, a lazy version of List
  // Stream elements are computed lazily, so it can be infinitely long

  val stream = 1 #:: 2 #:: 3 #:: 4 #:: Stream.empty // Stream(1, ?)
  val streamLong = (1 to 10000000).toStream // Stream(1, ?)

  streamLong.tail // Stream(2, ?) '?' => hasn't been evaluated yet

  // methods that are transformer method, it only returns ? and doesn't get evaluated.
  // However, methods that are NOT transformer method (ex. max, size, sum) will be
  // evaluated immediately and easily cause OutOfMemoryError
}