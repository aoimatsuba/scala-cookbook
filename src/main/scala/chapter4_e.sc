object chapter4_e {

  // ##########14 Create boilerplate code with case classes

  // Case class = intended to create immutable records
  // constructor params are val by default for case class
  case class Person(name: String, var relation: String)
  // therefore accessor methods are generated. (Mutator is only when fields are var)

  val izzy = Person("Izuki", "brother")
  izzy.name
  izzy.relation = "Older brother"

  // toString method by default
  izzy
  izzy match {
    case Person(n, r) => println(n, r)
  }

  // also hashCode method; instances can be compared
  val qp = Person("Yori", "Younger brother")
  izzy == qp // => false

  // copy is useful when you want to copy and modify field(s) partially
  val kyupi = qp.copy(relation = "younger bro")
  qp == kyupi

  // ##########15  Define an equals method for object equality


  // In Java, == is "reference equality" while in Scala, it is "instance equality"
  class Animal(var name: String) {

    def canEqual(a: Any) = a.isInstanceOf[Animal]

    override def equals(that: Any): Boolean = that match {
      case that: Person => that.canEqual(this) && this.hashCode == that.hashCode
      case _ => false
    }

    override def hashCode(): Int = {
      val prime = 31
      var result = 1
      result = prime*result + (if(name == null) 0 else name.hashCode)
      result
    }
  }
  // equals method in scala must be
  // 1. reflexive: For all x: Any, x.equals(x) == true
  // 2. symmetric: For all x and y of Any, x.equals(y) <=> y.equals(x)
  // 3. transitive: For all x, y, and z of Any, x.equals(y) && y.equals(z) => x.equals(z)


  // ###########16 Creating Inner class
  // Create an inner class to keep the class out of public API

  class PandoraBox (name: String) {

    case class Thing(name: String) {
      var shape = "meh"
    }

    var things = new collection.mutable.ArrayBuffer[Thing]()
    things += Thing("Evil Thing #1")
    things += Thing("Evil Thing #2")

    def addThing(name: String): Unit = {
      things += Thing(name)
    }
  }

  // When accessing collection of "things", it doesn't need to know about concept of Thing
  val box = new PandoraBox("P Box")
  box.things.foreach(println)
  box.addThing("Evil Baji")
  box.things.foreach(println)

  // In Scala, unlike Java, inner classes are *bound to the outer object*
  val box1 = new PandoraBox("Box")
  val box2 = new PandoraBox("Box")
  val stuff1 = box1.Thing("")
  val stuff2 = box2.Thing("")

  stuff1.shape = "round"
  stuff2.shape = "square"

  println(s"stuff1 = ${stuff1.shape}")
  println(s"stuff2 = ${stuff2.shape}")
}