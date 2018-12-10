object chapter10_c {

  // #########9 Looping over a collection with foreach
  // foreach should take an element as an input param and should NOT return anything
  val x = Vector(2, 5, 6, 10, 9)
  x.foreach(println)

  // can be used for String as it is a sequence of type Char
  "Noot chan".foreach(println)
  // multiline
  val longWords = new StringBuffer
  val sentence = "My cat is from roseville california. She is fuwafuwa"
  // split returns Array[String]
  sentence.split(" ").foreach{ e =>
    if (e.length > 5) longWords.append(s"$e")
    else println(s"not added: $e")
  }

  // Map params can be handled as a tuple
  val catsRate = Map("Baj" -> 2, "Noonoo" -> 10, "Oscar" -> 7)
  catsRate.foreach {
    case (key, value) => println(s"The rate of $key is $value")
  }


  // ##########10 Looping over a collection with for loop
  // Can create a new collection from the existing collection using for/yield
  val veggies = Vector("carrot", "napa", "paprika", "potato")
  for(veg <- veggies) println(veg.toUpperCase)

  // can use zipWithIndex to loop with a counter
  for ((veg, count) <- veggies.zipWithIndex) {
    println(s"Number $count, is $veg")
  }
  // or Stream with zip to start from some number
  for ((veg, count) <- veggies.zip(Stream from 2)) {
    println(s"Number $count, is $veg")
  }

  // Use yield to get a new collection from an input collection
  val VEGGIES = for(veg <- veggies) yield veg.toUpperCase.reverse

  // Iterate Map with for loop
  for((k, v) <- catsRate) println(s"$k gets $v!")


  // ###########11 Use zipWithIndex or zip to create loop with counters
  // Like it is done above,
  val months = Array("Jan", "Feb", "March", "April", "May", "June")
  //zipWithIndex creates collection of tuples of (element, Int count)
  months.zipWithIndex.foreach{
    case (month, count) => println(s"$count is $month?")
  }

  // counter of withZipIndex always starts with 0. To avoid it,
  // use zip with Stream
  for((month, count) <- months.zip(Stream from 1)) {
    println(s"$count is $month!")
  }


  // ############12 Use iterators

  // Iterator is not collection so when you try to print once it works
  // but second time it does not work because it has been already exhausted
  val i = Iterator(1, 2, 3)
  i.foreach(println)

  i.foreach(println)

}