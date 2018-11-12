object chapter4_c {

  // ##########8 Initialize a field in a class by calling a function

  class Document {

    // Set a field value with block of code
    val text = {
      var lines = ""
      try {
        lines = io.Source.fromFile("/chapter2").getLines().mkString
      } catch {
        case e: Exception => lines = "ERROR!!!" + e
      }

      // return what we get from file/error message
      lines
    }

    println(text)
  }

  val doc = new Document

  // Following code get compilation error w/o "lazy" because the file
  // doesn't exist.
  // But with "lazy", text field is NOT initialized until it is accessed
  // so it is not getting any error.

  class Foo {
    lazy val text = io.Source.fromFile("/scala/chapter2").getLines().mkString
  }

  val f = new Foo
  println("No error till here!")
//  f.text


  // ###########9 Set the type for uninitialized var field

  case class User(var username: String, var password: String) {
    var age = 0
    var firstName = ""
    var lastName = ""
    // Use Option for setting type for uninitialized var
    var address = None : Option[Address]
  }

  case class Address(city: String, state: String, zip: String)

  val u = User("aoi", "pass")
  u.address = Some(Address("Munich", "B", "88888"))


  // ##########10 Handling constructor params when extending a class

  class Person(var name: String, var address: Address)
  // Leave var/val declaration off since getter and setter are already generated in the
  // parent class.
  class Customer(name: String, address: Address, val id: Int) extends Person(name, address)

  val customer = new Customer("Aoi", Address("Munich", "B", "22"), 22)
  customer.address


  // ##########11 Calling a superclass constructor
  class Animal (var name: String, var age: Int) {
    // Auxiliary constructor
    def this(name: String) {
      this(name, 3)
    }
  }

  class Dog(name: String) extends Animal(name) {

    // Auxiliary constructor
    // There is no way for this aux. constructor to call superclass aux. constructor
    // Because it needs to call some other constructor in it own class (Dog) first.
    def this() {
      this(name)
    }

    // Therefore all aux constructors will eventually call the same superclass constructor
    // that's called from the subclass's primary constructor
  }
}