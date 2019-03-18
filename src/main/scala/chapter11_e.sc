object chapter11_e {

  // ##########24 Adding elements to a Set
  // mutable set
  var set = scala.collection.mutable.Set[Int]()

  set += 2
  set += (4, 5)
  // there is no error if the duplicate is added
  set += 4
  // can add elements from any sequence
  set ++= Vector(9, 4, 3)

  // can check if there is duplicate by add or contain
  set.add(2)  // false because it is duplicate
  set.add(12) // true because it is new
  set
  set.contains(4)
  set.contains(7)

  // immutable Set
  // Just assign to new variable
  val s1 = Set(1, 2)
  val s2 = s1 + 3
  // or use var
  var setR = Set(4, 5, 0)
  setR += 3
  setR


  // ###########25 Delete elements from Sets
  // to delete everything, use clear
  // mutable
  set
  set -= 9
  set -= (2, 3)
  set --= Array(12, 4)
  set.clear()
  set // Empty set Set()

  // the same thing can be said for remove as add
  set += (1, 2, 3, 5, 6, 23, 8)
  set.remove(2) // true
  set.remove(7) // false, doesn't exist
  // immutable set is the same as adding elements: remove elements and assign to new var.


  // ###########26 Use sortable Sets
  // use SortedSet: only available for immutable
  val s = scala.collection.SortedSet(17, 4, 5, 24, 8)

  // LinkedHashSet sort in order which the elements are inserted
  val sl = scala.collection.mutable.LinkedHashSet(9, 4, 2, 23, 8)

  // This sorting doesn't work for custom types because there isn't implicit Ordering
  // for example
  class Person(var name: String)

  val giraffe = new Person("Giraffe")
  val aoi = new Person("Aoi")
  val qp= new Person("Kyupio")

  // This doesn' work: no implicit ordering defined for Person
  // val persons = collection.SortedSet(giraffe, aoi, qp)

  // But extend the Ordered trait
  class PersonOrder(var name: String) extends Ordered [PersonOrder] {
    override def toString = name

    override def compare(that: PersonOrder): Int = {
      if (this.name == that.name) 0
      else if (this.name > that.name) 1
      else -1
    }
  }

  val giraffe2 = new PersonOrder("Giraffe")
  val aoi2 = new PersonOrder("Aoi")
  val qp2= new PersonOrder("Kyupio")

  val personSorted = collection.SortedSet(giraffe2, aoi2, qp2) // works!
}