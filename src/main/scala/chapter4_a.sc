
object chapter4_a {

  // #########1 Create primary constructor
  class Person(var firstName: String, var lastName: String) {

    println("the constructor begins")

    // some class fields
    private val HOME = System.getProperty("user.home")
    var age = 0

    // some methods
    override def toString = s"$firstName $lastName is $age years old"
    def printHome { println(s"HOME = $HOME") }
    def printFullName { println("====" + this) }

    printHome
    printFullName
    println("still in the constructor")

  }

  val person = new Person("Aoi", "Mat")


  // ##########2 Control visibility of constructor fields
  // var -> getter and setter generated
  // val -> getter generated
  // not specified -> no getter nor setter

  class Cat(var name: String)
  class Dog(val name: String)
  class Bird(name: String)

  val c = new Cat("Noot")
  c.name
  c.name = "Baj"
  val d = new Dog("Hugo")
  d.name
  //d.name = "Baj" Error
  val b = new Bird("Pokebird")
  // name field not accessible

  class Rabbit(private var name: String) {
    def getName = name + " is the owner"
  }
  val r = new Rabbit("Anna")
  //r.name // Error only accessible from withing the class
  r.getName

  // *** for case class, default is val ***
  case class Baj(name: String)
  val bb = Baj("Bad Baj")
  bb.name


  // ###########3 Define Auxiliary constructors

  // Each auxiliary constructor must have different signatures and
  // each of them must call one of previously defined constructors

  class Animal(val group: String, val isCarnivore: Boolean) {
    // Put parameters in primary constructor in order to have accessors
    // and mutator methods generated

    def this() {
      // must begin with previously defined constructor
      this(Animal.DEFAULT_TYPE, Animal.DEFAULT_DIET)
    }

    def this(isCarnivore: Boolean) {
      this(Animal.DEFAULT_TYPE, isCarnivore)
    }

    def this(group: String) {
      // previously defined constructor (not primary constructor)
      this(Animal.DEFAULT_DIET)
    }
  }

  object  Animal {
    val DEFAULT_TYPE = "Mammal"
    val DEFAULT_DIET = false
  }

  // Auxiliary constructors for case class
  case class Grade(name: String, var rank: Int)

  object Grade {

    val NO_NAME = "<no name>"
    val MAX_STUDENT = 30

    def apply() = new Grade(NO_NAME, MAX_STUDENT)
    def apply(name: String) = new Grade(name, MAX_STUDENT)
  }

  val noName = Grade()

  val aoi = Grade("name")
  println(aoi.rank)
  aoi.rank = 10
  println(aoi.rank)
  val baj = Grade("Baj", 1)


}