import scala.collection.immutable.ListMap

object chapter11_d {

  // ###########17 Traversing a Map
  val movies = Map(
    "Conan" -> 7.0,
    "Ant Man" -> 7.6,
    "Geisha" -> 5.5,
    "Winnie the Pooh" -> 8.5
  )

  for ((k, v) <- movies) println(s"Rating for $k is $v.")
  movies.foreach {
    case (title, rate) => println(s"Rating of movie title $title was $rate!")
  }

  // to use the Tuple syntax to access the key
  movies.foreach(movie => println(s"${movie._1}: ${movie._2}"))
  // cannot do following because the foreach expects a function literal with A TUPLE argument
  // movies.foreach((k, v) => println(s"$k: $v"))

  // if only key or value is needed,
  movies.keys.foreach(println)
  movies.values.foreach(println)

  // operate on map values using mapValues
  movies.mapValues(rate => rate + 0.5)
  // transform can use both key and value
  movies.transform((k, v) => s"$k worth ${v.toString}")


  // ###########18 Getting the keys or values from a Map
  // just use following
  movies.keys
  movies.keySet
  movies.keysIterator
  movies.values
  movies.valuesIterator


  // ###########19 Reversing Keys and Values
  val reverseMovies = for((title, rate) <- movies) yield (rate, title)


  // ###########20 Testing for existence of a key or value
  val states = Map(
    "AK" -> "Alaska",
    "AL" -> "Alabama",
    "CA" -> "California"
  )

  // use contains for keys
  if (states.contains("NY")) println("YES") else println("NOPE")

  // values: valueIterator
  // exists: method for iterator check if the predicate holds
  // contains: this contains is just checking for char set in a string, not map
  states.valuesIterator.exists(_.contains("laska"))
  states.valuesIterator.contains("Alaska") // this check for the iterator element


  // #############21 Filtering a Map
  // for mutable map, use retain
  var x = scala.collection.mutable.Map(2 -> "two", 4 -> "four", 6 -> "six")
  x.retain((k, v) => v.length > 3)
  x
  // transform let you transform elements
  x.transform((_, v) => v.toUpperCase())
  x

  // for immutable, just use filter/filterKeys
  val y = Map(1 -> "one", 3 -> "three", 5 -> "five")
  y.filterKeys(_ > 2)
  y

  // can also use Set with filterKeys to define the elements to retain
  y.filterKeys(Set(1, 3))
  // Or use tuple: filter method provides predicate a Tuple2
  y.filter((t) => t._2 == "five")


  // ############22 Sort an existing Map by Key or Value
  // for the basic immutable Map, can use sortBy to sort
  val grades = Map(
    "Giraffe" -> 95,
    "QP" -> 63,
    "Izzy" -> 82,
    "Aoi" -> 78
  )

  // by key
  ListMap(grades.toSeq.sortBy(_._1):_*) // treat a single argument of a seq type as a variable arg..
  // by value
  ListMap(grades.toSeq.sortBy(_._2):_*)
  // each of above result is a new sorted map (so needs to be assigned to a new variable)

  // a bit more about *_
  // it cannot construct a ListMap with Seq of tuples, but the apply method
  // accepts a Tuple2 varargs param.


  // ############23 Finding the Largest Key or Value in a Map
  // key string is largest
  grades.max
  grades.keysIterator.max
  // value is largest
  grades.valuesIterator.max

  // or use reduceLeft with own definition of max
  grades.valuesIterator.reduceLeft(_ min _) // min is the largest in this case
}