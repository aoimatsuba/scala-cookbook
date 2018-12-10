object chapter10_b {

  // #########5 Declare a type when creating a collection
  // if not specified scala will assign Double to following
  val x = List(1, 4.6, 55D, 4) // List[Double]
  // assign type
  val xN = List[Number](1, 4,6, 9D, 23)

  // Another example with following class hierarchy
  trait Animal
  trait FurryAnimal extends Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal

  // without specifying type
  val a = Array(Dog("Hugo"), Cat("Noot"))
  // Above is Array of "Product with Serializable with Animal]

  val animal = Array[Animal](Dog("Uncle Sam"), Cat("Baj")) //Array[Animal]


  // ##########6 Understand mutable variables with immutable collections

  // Define Vector (*immutable* collection)
  var siblings = Vector("Izuki")
  siblings = siblings :+ "Aoi"
  siblings = siblings :+ "Yori"
  println(siblings)

  // siblings variable points to a NEW collection each time :+ is used
  // can check the vector itself is immutable
  // siblings(5) = "Baj"


  // ##########7 Make Vector "go to" immutable sequence
  // Vector: faster, general-purpose, immutable sequential collection

  val v = Vector(1, 2, 3)
  v(0)
  // cannot modify vector but can "add" element by assigning it to new Vector
  val b = v ++ Vector(4, 5)

  // update the element by assigning the result to a NEW variable
  val c = b.updated(3, 44)

  c.take(3)
  c.filter(_ < 10)


  // ##########8 Make ArrayBuffer "go to" mutable sequence
  import scala.collection.mutable.ArrayBuffer
  var fruits = ArrayBuffer[String]()

  fruits += "Apple"
  fruits += ("Pomegranate", "Pear")

  // can add lements from another collection as well
  fruits ++= List("Kiwi", "Orange")

  fruits -= "Pear"
  println(fruits)
}