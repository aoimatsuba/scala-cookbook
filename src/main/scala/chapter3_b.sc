import scala.util.control.Breaks

object chapter3_b {

  // ###########4 Create a for Comprehension: a new collection from existing collection
  val clothes = Array("pants", "jacket", "dress", "shorts", "scarf")
  val capitalizedClothes = for(c <- clothes) yield c.capitalize

  // Except for rare occasions, return type is same as the original collection type
  val colors = scala.collection.mutable.ArrayBuffer[String]()
  colors += "red"
  colors += "yellow"
  colors += "gold"

  val capitColor = for (c <- colors) yield c.capitalize //capitColor is ArrayBuffer as well
  // using for/yield on a collection is the same as using map
  val upperColor = colors.map(_.toUpperCase)


  // ###########5 implement break and continue
  import util.control.Breaks._
  breakable {
    for (c <- clothes) {
      if (c.contains("short")) break
      else println(c)
    }
  }
  // above 'breakable' and 'break' are not keywords but methods in util.control.Breaks

  // To implement continue functionality,
  for (c <- clothes) {
    breakable {
      if (c.contains("a")) break
      else println(c)
    }
  }

  // break can also be labeled as following example
  val Outer = new Breaks
  val Inner = new Breaks

  Outer.breakable{
    for (i <- 1 to 10) {
      Inner.breakable{
        for(j <- 'a' to 'e') {
          if (i == 2 && j == 'b') Inner.break else println(s"$i, $j")
          if (i == 6 && j == 'c') Outer.break
        }
      }
    }

  }


  // ###########6 Use if construct like a ternary operator
  // if expression returns a value
  val value = if (clothes.length > 5) "too many" else "ok"

}