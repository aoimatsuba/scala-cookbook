object chapter3_a {
  // Chapter 3 Control Structures

  // ###########1 Iterate over the elements in a collection.  Operate on each element.
  val colors = Array("red", "blue", "yellow", "white", "green")
  for (color <- colors) {
    val c = color.toUpperCase()
    println(c)
  }

  // above loop doesn't return a value so if return value is wanted, use yield
  // A simple for loop that iterates over collection is translated to a foreach method call on the collection
  // for loop with yield is translated to a map method on the collection

  // Can see the scala compiler output by using $scalac -Xprint: parse <file>
  for (color <- colors) yield color.toUpperCase()
  for (color <- colors) yield {
    val c = color.toUpperCase.toLowerCase.capitalize
    c
  }
  colors.foreach( e => println(e.capitalize))

  // with counter
  for (i <- 1 until colors.length) {
    println(s"No.$i is ${colors(i).capitalize} ")
  }

  for ((color, counter) <- colors.zipWithIndex) {
    println(s"color No.${counter + 1} is ${color.capitalize}")
  }

  // Use Range
  for (i <- 2 to 11 if i > 5) println(i)

  // Looping over a Map
  val colorMap = Map(1 -> "red", 2 -> "blue", 3  ->"yellow", 4  ->"white", 5 ->"green")
  for((num, color) <- colorMap) {
    println(s"Key is $num and the value is $color")
  }


  // ###########2 Loop with multiple counters / multi dimensional array
  for (i <- 1 to 6 if i % 2 == 0 ; j <- 10 to 20 if j % 2 != 0) {
    println(s"$i is even and $j is odd")
  }

  // preferred style
  for {
    i <- 1 to 6 if i % 2 == 0
    j <- 10 to 20 if j % 2 != 0
  } println(s"$i and $j")

  val multiDimArray = Array.ofDim[Int](2, 3)
  multiDimArray(0)(0) = 0
  multiDimArray(0)(1) = 1
  multiDimArray(0)(2) = 2
  multiDimArray(1)(0) = 10
  multiDimArray(1)(1) = 11
  multiDimArray(1)(2) = 12

  for {
    i <- 0 to 1
    j <- 0 to 2
  } println(s"Num at ($i)($j) is ${multiDimArray(i)(j)}")


  // ###########3 Loop with guards (embedded if statement)
  for (i <- 0 to 10 if i % 2 == 0) println(i)

  // preferred style is
  for {
    i <- 0 to 10
    if i % 3 == 0
    if i > 5
  } println(i)



}
