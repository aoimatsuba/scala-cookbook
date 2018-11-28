object chapter5_c {

  // #########5 Define a method hat returns multiple items
  // Can use tuple to return multiple items
  // For java you create wrapper class and return the class
  def getProfile = {
    ("Aoi", "26", "Japan")
  }
  // can call the method and assign values
  val (name, age, nationality) = getProfile
  nationality

  val result = getProfile
  result._2


  // #########6 Enforce getter/setter to have no parentheses when invoked

  class Pizza {
    def size = 12
    def sauce() = "tomato"
  }

  val p = new Pizza
  p.size
  p.sauce()
  p.sauce
  //p.size() // Error: does not take params


  // ###########7 Create methods that take variable-argument fields
  // Use varargs by adding a *
  def printAll(strings: String*): Unit = {
    strings.foreach(println)
  }

  printAll("Baj", "Noonoo", "Oskar san")

  val dogs = List("Hugo", "Jolly")
  // Use _* operator to adapt a sequence
  printAll(dogs: _*)

  // varargs must be at the last among the fields
  // --> a method can have only one varargs field
  // def foo(string: String*, num: Int) = {} compiler error
  // def foo(string: String*, nums: Int*) = {} error


  // ###########8 Declare method capable of throwing exception

  // Just use @throws if there are multiple, just stack up
  @throws(classOf[Exception])
  @throws(classOf[IndexOutOfBoundsException])
  def play: Unit = {}


  // ##########9 Support a "fluent" style programming

  // Fluent interface: is object oriented API based extensively on
  // METHOD CHAINING

  // use this.type as return type
  class Person {
    protected var fname = ""
    protected var lname = ""

    def setFirstName(firstName: String): this.type = {
      fname = firstName
      this
    }

    def setLastName(lastName: String): this.type = {
      lname = lastName
      this
    }
  }

  class Employee extends Person {

    protected var role = ""
    def setRole(role: String): this.type = {
      this.role = role
      this
    }

    override def toString: String = {
      s"$fname , $lname, position: $role"
    }
  }

  val employee = new Employee
  employee
    .setRole("engineer")
    .setFirstName("Aoi")
    .setLastName("Matsuba")
  println(employee)

}