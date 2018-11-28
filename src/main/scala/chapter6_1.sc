object chapter6_1 {

  // #########1 Cast a class instance to a different type
  // use asInstance of

  val a = 19
  val b = a.asInstanceOf[Long]
  val c = a.asInstanceOf[Byte]


  // #########2 Scala equivalent of Java .class
  // Using classOf, class methods can be easily accessed
  val stringClass = classOf[String]
  stringClass.getMethods

  class Dog {
    def run = println("RUUUUUNN")
    def bark = println("Wan")
  }

  val dogClass = classOf[Dog]
  dogClass.getMethods


  // #########3 Determine the class of an object
  // Just use getClass method
  def printAll(nums: Int*) = {
    println("class: " + nums.getClass)
  }

  // class of arguments are different
  printAll(4,5,6).getClass
  printAll().getClass


}