object chapter10_f {

  // ##########20 Walk through collection with the reduce and fold

  // reduceLeft: starts comparing the first two elements in the collection and
  // returns result, then the result is compared with the third element.
  val numbers = Array.range(1, 25)
  // this case sum of all the elements
  numbers.reduceLeft(_ + _)

  val randomInt = Array(4, 6, 1, 3, 7, 2)
  randomInt.reduceLeft((x, y) => {
    val bigger = x max y
    println(s"Compared $x and $y, $bigger is bigger!")
    bigger
  })

  // foldLeft: sets a seed value to be used for the first element
  randomInt.reduceLeft(_ + _)
  randomInt.foldLeft(10)(_ + _)
  randomInt.foldLeft(100)(_ + _)

  // scanLeft and scanRight is similar to reduce but returns a sequence
  randomInt.scanLeft(10)((x, y) => {
    val result = x * y
    println(s"$x, $y, result = $result")
    result
  })

  // The first element is the one passed, and it became the x. y is the first
  // element of the seq. Next, the result will be x, and so on..


  // ###########21 Extract unique elements from a sequence

  // use distinct method: it gives a new collection with dups removed
  val num = Array(5, 6, 23, 1, 5, 2, 1)
  num.distinct

  // also converting to Set works the same way as well
  // By definition Set only contains unique elements
  num.toSet


  // ###########22 Merge sequential collections

  // Use ++= to merge a sequence into a mutable
  val a = collection.mutable.ArrayBuffer(1, 3, 5)
  a ++= Seq(6, 6, 2)
  // and ++ for immutable
  val b = Array(5, 6, 7, 9)
  val c = b ++ Array(4, 2, 1)

  // intersect creates a seq with elements that are in both elements
  val inter = b.intersect(a)

  // union returns all elements from both collection WITH duplicates
  val union = b.union(a)
  // use distinct to get unique elements
  union.distinct

  // diff returns a new list which contains all elements of "this" list except
  // some of occurrences of elements that also appear in "that"
  val thisSeq = Array(1, 2, 4, 5, 3)
  val thatSeq = Array(4, 5, 7)
  thisSeq diff thatSeq // this gives Array(1, 2, 3)
  thatSeq diff thisSeq // this gives Array(7)

  // concat concatenates seq
  Array.concat(thisSeq, thatSeq)
}