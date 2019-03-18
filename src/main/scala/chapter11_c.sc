object chapter11_c {

  // ###########12 Creating Maps

  // Immutable map
  val immutableMap = Map("CA" -> "California", "NY" -> "New York", "NV" -> "Nevada")

  // mutable map
  var states = collection.mutable.Map("AL" -> "Alabama")
  // creates Tuple2 to add a key-value
  states += ("OR" -> "Oregon")
  // therefore can also add as follows
  val months = Map((1, "Jan"), (2, "Feb"), (3, "Mar"))


  // ###########13 Choose a Map implementation

  // map with sorted order by keys
  import scala.collection.SortedMap
  val grades = SortedMap("Izuki" -> 99, "Quzuki" -> 77, "Aoi" -> 87)

  // map with insertion order of the elements
  import scala.collection.mutable.LinkedHashMap
  val order = LinkedHashMap(2 -> "two", 1 -> "one")
  order += 4 -> "four"

  // ListMap return elements in the newest first order
  import scala.collection.mutable.ListMap
  val oppositeOrder = ListMap(2 -> "two", 1 -> "one") // 1 -> 2
  oppositeOrder
  oppositeOrder += 4 -> "four" // 4 -> 2 -> 1 ??
  // Elements that are added are prepended to the head of the list => X
  // Does NOT seem like it is ordered (found discussion in stack overflow too)


  // ############14 Add Update, and Remove elements with a mutable Map
  var usStates = scala.collection.mutable.Map[String, String]()

  usStates += ("AL" -> "Alabama")
  // usStates("CA") = "California"
  usStates += ("CA" -> "California", "TX" -> "Texas", "BC" -> "British Columbia")
  // remove elements by key
  usStates -= ("BC", "AL")
  // update value
  //usStates("CA") = "Where Davis is located"
  // Above line somehow doesn't work but it is basically doing the same thing
  usStates.update("CA", "Where Davis is located")
  usStates

  val fruits = collection.mutable.Map(
    "a" -> "Apple",
    "o" -> "Orange",
    "g1" -> "Grape",
    "g2" -> "Grapefruit",
    "k" -> "Kiwi"
   )

  // Add element or replace existing
  fruits.put("k2", "Kaki") // adding a new item
  fruits.put("o", "ooooorange") // put returns replaced: it is None when it is new
  fruits

  // retain to keep only the items that match the predicate supplied
  fruits.retain((k, _) => k.contains("g"))


  // ############15 Add, Update, and Remove elements with an immutable Map
  // basically adding/updating/removing by assigning to a new variable

  val cities = Map(
    "Tokyo" -> "Japan",
    "San Jose" -> "USA",
    "Kaohsiung" -> "Taiwan",
    "Munich" -> "Germany"
  )
  // add
  val cities2 = cities + ("London" -> "UK")
  // update certain element
  val cities3 = cities2 + ("Munich" -> "Deutschland")
  // remove
  val cities4 = cities3 - "Munich"

  // Or declare the immutable map as var


  // ###########16 Accessing Map values
  // when the map doesn't contain the key specified, it throws NoSuchElementException
  // in order to avoid this, create a map with withDefaultValue method
  val drink = Map("juice" -> 120, "coke" -> 100, "beer" -> 300).withDefaultValue("Not found")
  drink("wine")

  // or use getOrElse when getting
  val soda = Map("coke" -> 100, "sprite" -> 120)
  soda.getOrElse("ginger ale", "Not found")


}