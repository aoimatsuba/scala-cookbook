import scala.collection.immutable.LinearSeq

object chapter10_a {

  // ##########1 Understand the collections hierarchy

  // At high level, scala's collection starts from Traversable and Iterable
  // Below that there are mainly Seq / Map / Set

  // Seq
  // Indexed Sequences: random access of elements is efficient
  // By default it creates Vector
  val x = IndexedSeq(1, 2, 3)
  // Linear Sequences: collection can be efficiently split in to head and tail
  // LinearSeq creates a singly linked List
  val y = LinearSeq(1, 3, 7)
  y.tail

  // Map
  // Simplest immutable map in scope by default
  val map = Map(4 -> "four", 3 -> "three")
  // Mutable Map needs to be imported
  val mutable = collection.mutable.Map(5 -> "five")
  mutable(5) = "FIVE"
  mutable.get(5)

  // Set
  // Collection of unique elements
  // immutable set in scope by default
  val set = Set(4, 5, 1)
  val mutableSet = collection.mutable.Set(4, 6, 2)


  // ###########2 Choose a collection class
  // Set
  /*         Immutable      Mutable
  Indexed     Vector       ArrayBuffer
  Linear      List         ListBuffer
   */

  // some other collection classes
  // Emuration: a finite collection of values
  // Iterator: isn't a collection but a way to access elements
  // Tuple: a heterogeneous collection of elements. Implemented as case class


  // ###########3 Choose a collection method to solve a problem
  // It is just a list of bunch of methods with description. Reading material


  // ###########4 Understand the performance of collections: Reading material

}