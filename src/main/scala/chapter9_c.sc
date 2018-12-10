object chapter9_c {

  // ###########7 Create a function that returns a function

  // This method returns a function that takes string and returns string
  def saySomething(prefix: String) = (s: String) => {
    prefix + " and " + s
  }

  val sayHello = saySomething("Hello") // String => String
  println(sayHello("Goodbye!"))

  // More useful example
  def greeting(language: String) = (name: String) => {
    language match {
      case "English" => s"Hello, $name"
      case "Japanese" => s"こんにちは、 $name"
      case _ => s"Hi, $name"
    }
  }

  val hello = greeting("English")
  val konnichiwa = greeting("Japanese")
  hello("Russell")
  konnichiwa("Aoi")


  // ###########8 Creating partial functions

  // partial function: a function that does not provide an answer for every
  // possible input value it can be given

  val divide = (x: Int) => 50 / x
  // if 0 is given it will throw an exception

  val dividePartial = new PartialFunction[Int, Int] {
    def apply(x: Int) = 50 / x
    def isDefinedAt(x: Int) = x != 0
  }

  dividePartial.isDefinedAt(2)
  if (dividePartial.isDefinedAt(5)) dividePartial(5)

  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 50 / d
  }
  // isDefinedAt is not explicitly defined but can still use
  divide2.isDefinedAt(0)

  // isDefinedAt allows to test dynamically if a value is in the domain
  // of function

  // collect method takes a partial function as an input and apply it to
  // all elements of list which the function is defined
  // List(0, 1, 2, 5).map(divide2) // this throws match error

  List(0, 1, 2, 4).collect(divide2)
  // above returns a new collection

}