import scala.collection.mutable.ArrayBuffer

object chapter11_b {

  // ########## 7 Create an update an Array
  // Array is MUTABLE in that ELEMENTS can be changed, but
  // IMMUTABLE in that size cannot be changed
  val a = Array(1, 2, 3)
  val aType = Array[String]("one", "two", "three")

  // Define with an initial size and type
  val i = new Array[String](4)
  i(0) = "apple"
  i(1) = "orange"
  i(2) = "yuzu"
  i(3) = "kaki"
  // i(4) = "brah" ArrayIndexOutOfBoundsException

  // as practiced for List,
  val aRange = Array.range(2, 30, 4)
  val aFill = Array.fill(3)("haha")
  val aTab = Array.tabulate(4)(n => n * 2)
  val aList = List(1, 4, 5).toArray
  "Something".toArray

  // ##########8 Array with mutable size (ArrayBuffer)
  // in order to have array size changeable, use ArrayBuffer
  var ab = new ArrayBuffer[String]()
  ab += "size"
  ab += "is"
  ab += "changing!"
  ab += ("and", "more!")
  ab ++= Seq("AB", "CD")
  ab.append("can", "be") // returns unit
  ab

  // ##########9 Delete Array and ArrayBuffer elements
  // ArrayBuffer is mutable sequence
  ab -= "size"
  ab -= ("is", "changing!")

  ab --= Seq("AB", "CD")

  val chars = ArrayBuffer('a', 'b', 'c', 'd', 'e', 'f')
  chars.remove(2, 3)
  chars

  // clear removes everything from the buffer
  chars.clear()
  chars


  // ##########10 Sorting Arrays
  // String class has an implicit Ordering. So quickSort sorts sthe Array in place
  // there is no need to assign the result to a new variable
  val fruits = Array("papaya", "kiwi", "pineapple")
  scala.util.Sorting.quickSort(fruits)
  fruits


  // ###########11 Create Multidimensional Array
  val multiDArray = Array.ofDim[String](2, 3)
  multiDArray(0)(0) = "a"
  multiDArray(0)(1) = "b"
  multiDArray(0)(2) = "c"
  multiDArray(1)(0) = "d"
  multiDArray(1)(1) = "e"
  multiDArray(1)(2) = "f"

  for {
    i <- 0 until 2
    j <- 0 until 3
  } println(s"${multiDArray(i)(j)}")

  // use Array of Array
  val multi2 = Array(Array("a", "b"), Array("A", "B"))
  println(multi2(0))
  println(multi2(1))

}