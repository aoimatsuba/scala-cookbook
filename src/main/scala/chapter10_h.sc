object chapter10_h {

  // ###########26 Create and use Enumerations

  // Can extend the scala.Enumeration class to create enumeration
  object Margin extends Enumeration {
    type Margin = Value
    val TOP, BOTTOM, LEFT, RIGHT = Value
  }

  // And import it if it is in a different scope
  var currentMargin = Margin.TOP


  // ###########27 Tuples, for when a bag of things needed

  // Done in previous chapters
  case class Person(name: String)
  val t = (3, "Three", Person("Aoi"))
  val (x, y, z) = t

  // if only some variables are needed
  val (_, _, person) = t // it will only assign the value to person

  // can also create tuple by a similar syntax to create map
  val tuple = "1" -> "Something"


  // ###########28 Sort a collection

  val a = List(4, 6,2,9, 12,6, 2)
  // with sort, it can sort any type that has implicit scala.math.Ordering
  a.sorted

  // with needs to provide a function for sortWith
  // needs to provide (T, T) => Boolean
  a.sortWith(_ > _)


  // ###########29 Converting a collection to a string with mkString
  a.mkString
  a.mkString("numners: ", ",", " that's all!")
}