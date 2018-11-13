object chapter4_d {

  // #########12 When to use abstract class

  // When creating a base class that requires constructor
  // arguments => trait doesn't allow constructor params
  abstract class Food(name: String)
  //trait Mammal(name: String) // Doesn't compile

  // Note: A class can only extend one abstract class
  abstract class BaseController(s: String) {

    // methods defined in abstract class
    def capitalize { s.capitalize }
    def toLower: String = { s.toLowerCase }

    // abstract methods
    def toUpper
    def addQuote: String // abstract method that returns String
    def addSomeWord(w: String): String // abstract method that takes a param
  }

  class ChildController(s: String) extends BaseController(s) {
    override def toUpper = println(s.toUpperCase())

    override def addQuote: String = s"'$s'"

    override def addSomeWord(w: String): String = s"$s is human"
  }

  val bc = new ChildController("Aoi")
  bc.toUpper


  // ##########13 Defining properties in an abstract base class (or trait)

  abstract class Pet (name: String) {
    val greeting: String
    var age: Int
    def sayHello {println(greeting)}

    override def toString: String = s"I say $greeting, I am $age years old"
  }

  // Now child classes will provide values for the fields with val/var
  class Dog (name: String) extends Pet(name) {
    val greeting: String = "Woof" // Seems like it doesn't matter if "override" is there?
    // => Because the abstract field doesn't actually exist in the abstract ase class,
    // override keyword is not necessary
    var age: Int = 5
  }

  class Cat (name: String) extends Pet(name) {
    val greeting: String = "Meow"
    var age: Int = 10
  }

  val dog = new Dog("Hugo")
  val cat = new Cat("Nooto")

  dog.sayHello
  cat.sayHello
  println(dog)
  println(cat)

  //Verify age can be changed
  dog.age = 4
  println(dog)

  // Can also provide initial value for fields in abstract class
  abstract class Book(title: String) {
    val status = s"$title: "
  }

  class Chapter(title: String, var chapter: Int) extends Book(title) {
    override val status: String = s"$title: Chapter$chapter"
  }

  val ch = new Chapter("Harry Potter", 5)
  println(ch.status)

  // to avoid base class field overridden, declare as final
  abstract class TextBook(subject: String) {
   final val status = "Meh"
  }

  class Study(subject: String) extends TextBook(subject) {
    override val status = "Progress" // ERROR: Cannot override final member
  }

}