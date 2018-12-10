object chapter6_b {

  // ########4 Launch an application with an Object

  // Either, define an object that extends the App trait
  object Hello extends App {
    println("Hello, object")
  }

  // or define an object properly defined main method
  object Hello2 {
    def main(args: Array[String]): Unit = {
      println("Hello, object!!")
    }
  }


  // #########5 Create singletons with object
  // singleton objects are created with 'object' keyword

  object Cashier {
    def open {println("opened")}
    def close {println("closed")}
  }

  Cashier.close
  Cashier.open

  // this type of pattern is common when creating utility methods.
  object DateUtils {
    def getCurrentDate: String = System.currentTimeMillis.toString//java.util.Calendar.DATE.toString

    def getCurrentTime: String = java.util.Calendar.HOUR_OF_DAY.toString
  }

  DateUtils.getCurrentDate
  DateUtils.getCurrentTime


  // ##########6 Create static members with companion objects

  // Define nonstatic members in the class, and define members that you want to make
  // "static" as an object that has the same name as the class

  class Pizza(var crustType: String) {
    override def toString: String = "Crust type is " + crustType
  }

  // Companion object
  object Pizza {
    val CRUST_TYPE_THIN = "thin"
    val CRUST_TYPE_THICK = "thick"
    def getFoo = "Foo"
  }

  // Since it is "static", there is no need to create an instance of the class
  // to access the variables/methods
  println(Pizza.CRUST_TYPE_THICK)
  println(Pizza.getFoo)

  val p = new Pizza(Pizza.CRUST_TYPE_THIN)
  println(p)

  // It is important to know that a class and its companion object can access
  // each other's private members

  // C.Object accesses class
  class Woman {
    private val weight = 300
  }

  object Woman {
    // need to pass a class instance
    def secret(woman: Woman) = println(s"Her weight is ${woman.weight} pound!!")
  }

  val w = new Woman
  // w.woman doesn't work
  println(Woman.secret(w))


  // Class accesses C. Object
  class Man {
    def secret = println(s"His age is ${Man.age}")
  }

  object Man {
    private val age = 58
  }

  val m = new Man
  m.secret
}