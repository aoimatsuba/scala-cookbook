object chapter9_a {

  // ###########1 Use function literals (anonymous functions)
  val x = List.range(1, 10)
  val even = x.filter((i: Int) => i % 2 == 0) // filter take Int => Boolean
  // this case it the function literal can be simplified as:
  val odd = x.filter(_ % 2 == 1)

  x.foreach((i: Int) => println(i))
  // can be simplified
  x.foreach(i => println(i))
  x.foreach(println(_))
  // If a function literal consists of a single statement that takes a single
  // argument, the argument doesn't not need to be explicitly specified
  x.foreach(println)


  // ###########2 Use functions as variables
  val double = (i: Int) => { i * 2 }
  // this double is an instance of function known as a function value
  double(40)
  double(9)
  // can also passed to methods
  x.map(double) // map takes an input param of typeA and returns typeB

  // can also explicitly declare return type
  val tripleFunction: Int => Double = _ * 3
  tripleFunction(4)
  // implicit
  val add = (x: Int, y: Int) => { x + y }
  // explicit
  val minus: (Int, Int) => Int = (x, y) => { x - y }

  def tripleMethod(i: Int): Double = i * 3

  // The difference between tripleMethod and tripleFunction is that tripleMethod
  // is a method defined in a class, where as tripleFunction is a function that is
  // assigned to a variable and is "an instance of the Function1 trait"
  // Function1 trait defines a function that takes one argument

  // existing method/function can be also assigned to a function variable
  // partially applied function
  val t = tripleFunction
  t(5)
  val tM = tripleMethod(_)
  tM(3)


  // ###########3 Define a method that accepts a simple function parameter
  def execFunction(callback: () => Unit) {
    callback()
  }

  val hello = () => println("Hello") // () => Unit

  execFunction(hello)
}