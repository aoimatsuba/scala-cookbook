import scala.collection.mutable.ArrayBuffer

object chapter9_b {

  // ##########4 More complex method that takes functions
  // Using functions as parameter, it makes it easier to swap in
  // interchangeable algorithms.
  def exec(callback: Int => Unit): Unit = {
    callback(1)
  }

  // define functions that match the signature
  val plusOne = (i: Int) => {println(i+1)}
  val plusTen = (i: Int) => {println(i+10)}

  exec(plusOne)
  exec(plusTen)

  // Can also pass method what the function param needs for its param
  def execTwoNum(f: (Int, Int) => Int, x: Int, y: Int): Unit = {
    val res = f(x, y)
    println(res)
  }

  val add = (x: Int, y: Int) => x + y
  val multiply = (x: Int, y: Int) => x * y

  execTwoNum(add, 5, 6)
  execTwoNum(multiply, 5, 6)


  // ###########5 Using closures and scopes
  def exec(f: (String) => Unit, name: String): Unit = {
    f(name)
  }

  // Imagine following code is in a different scope from exec method
  var hello = "Hello"
  def sayHello(name: String) { println(s"$hello, $name!!") }

  // sayHello method reference the variable hello from within the exec
  // method of a different scope
  exec(sayHello, "Aoi")

  hello = "こんにちは"

  // And it even picks up the change to the hello variable
  exec(sayHello, "Raseru")

  // *Closure: a function together with a referencing environment for the non
  // local variables of that function

  val fruits = ArrayBuffer("apple")
  val addToBasket = (fruit: String) => {
    fruits += fruit
    println(fruits.mkString(","))
  }

  // imagine this method is in another class
  def buyStuff(f: String => Unit, fruit: String) {
    f(fruit)
  }

  // It will still refer to the same fruits val from other class
  buyStuff(addToBasket, "Banana")
  buyStuff(addToBasket, "pomegs")


  // ##########6 Using partially applied functions
  val sum = (a: Int, b: Int, c: Int) => a + b + c
  // Following will be a partially applied function because not all the params
  // are provided
  val f = sum(1, 2, _: Int) // Int => Int

  f(5)

  val sumP = (a: Int, d: Int) => println(a + d)
  sumP(5, _:Int) // not printing anything, just another function Int => Unit


}