object chapter10_d {

  // ##########13 Transform one collection to Another with for/yield

  // for/yield: for comprehension / sequence comprehension
  val a = Array(1, 2, 3, 4, 5)

  val newElement = for (e <- a) yield e

  val fruits = Array("Orange", "Kaki", "Pomegranate", "Banana")
  for(f <- fruits) yield f.capitalize

  for(i <- 0 until fruits.length) yield (i, fruits(i))
  for(f <- fruits) yield (f, f.toUpperCase)

  // case when the end collection is different size from the input collection
  val cars = Vector("Mercedes", "Porsche", "Tesla")
  for {
    c <- cars
    if c.startsWith("M")
  } yield c

  // if no element from the original collection ot be yielded, it will return
  // an empty Vector


  // ###########14 Transform one collection to another with map

  fruits.map(_.toUpperCase)
  // can convert different type
  val lengths = fruits.map(_.length)

  // map also works for writign a chain of method calls
  val s  = " eggs, milk, butter, Coco Puffs "
  val items = s.split(",").map(_.trim)

  // First filter the collection and then call map
  items.filter(_.length > 4).map(_.capitalize)


  // ###########15 Flatten a list of lists with flatten

  val listOfList = List(List(1, 2), List(3, 5))
  listOfList.flatten
  // real-life example: wedding attendee
  val couples = Array(Array("Aoi", "Russell"), Array("Noot", "Oscar"))
  val guests = couples.flatten.sorted

  // remove duplicates by using distinct
  val dups = Vector(Vector("Aoi", "Russell"), Vector("Russell", "Noot"))
  dups.flatten.distinct

  // flatten pulls the value from Some elements to create a new list and
  // drops None elements
  val option = List(Some("Baj"), None, None, Some("Poke"), Some("Raseru"))
  option.flatten
}