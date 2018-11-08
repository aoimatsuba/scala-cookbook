object chapter4_b {

  // #########4 Private primary constructor

  class CustomerInfo private (var name: String, var number: Int)

  // Gets error: constructor in class cannot be accessed
  // val pass = new CustomerInfo("Baj", 124)

  // In order to enforce the Singleton pattern,
  object CustomerInfo {
    val aoi = new CustomerInfo("Aoi", 123)
    def getInstance = aoi
  }

  val customer = CustomerInfo.getInstance
  customer.name = "Baj"
  println(customer.number)
  customer.number = 999
  println(customer.number)


  // #########5 Provide default value for constructor parameters

  class Order(val numberOfPeople: Int, val eatIn: Boolean = true)
  // param with default value needs to be in the end?

  val o = new Order(4)
  o.eatIn

  class Order2(val numOfPeople: Int, val eatIn: Boolean)
  val o2 = new Order(7, eatIn = false)
  o2.eatIn

  // If specifying the param values when calling a constructor, order of
  // params doesn't matter
  val order = new Order(eatIn = false, numberOfPeople = 3)


  // #########6 Override default accessors and mutators

  // Attempt to create(override) setter and getter
  class Person(private var _name: String) {
    // This get error 'name is already defined in the scope'
    // Also overloaded method name needs result type
    //def name = name

    // This works => add _ to constructor param (convention)
    def name = _name

    def name_=(aName: String) {_name = aName} //setter
  }


  // ########7 Prevent getter and setter being generated automatically

  // var => getter + setter generated automatically
  // val => getter generated automatically

  class Stock {
    var displayedPrice: Double = _

    private var currentPrice: Double = _
  }

  val stock = new Stock
  stock.displayedPrice
  // stock.currentPrice doesn't work

  // Object-private fields

  class Stock2{

    // If the field is defined private with [this], the field can only be
    // accessed from the object that contains it, but not the other instances
    // of the same type
    private[this] var price: Double = _

    // access by the current instance
    def setPrice(p: Double) { price = p}

    // access from a different instance: ERROR
    def isHigher(that: Stock): Boolean = this.price > that.price
    // "^ value price is not a member of Stock"
  }
}