object chapter3_e {
  // #########13 Add guards to case statements

  val i = 4
  val j = 16
  val k = 22

  i match {
    case a if 0 to 9 contains a => println(s"less than 9: $a")
    case b if 10 to 19 contains b => println(s"less than 19: $b")
    case c if 20 to 29 contains c => println(s"less than 29: $c")
    case _ => println("meh")
  }

  case class Person(name: String)

  def findPerson(p: Person) = p match {
    case Person(name) if name == "Aoi" => "This is Aoi"
    case Person(name) if name == "Nooto" => "This is a Cat"
    case _ => "some other"
  }

  println(findPerson(Person("Nooto")))

  // can also put guard on the right side of case statements but not recommended
  // Not as simple as putting within left side
  def findPersonB(p: Person) = p match {
    case Person(name) =>
      if (name == "Aoi") "This is Aoi"
      else if (name == "Nooto") "This is a cat not a person"
    case _ => "some other"
  }
  println(findPersonB(Person("Nooto")))


  // ##########14 Use match expression instead of isInstanceOf
  // Instead of
  val aoi = Person("Aoi")
  if (aoi.isInstanceOf[Person]) {
    println("Aoi is human")
  } else {
    println("meh")
  }

  // use match
  aoi match {
    case p: Person => println("Aoi is Person!")
    case _ => println("something else")
  }

  // can use an object that extends a supertype as well
  trait Animal
  trait Mammal extends Animal
  case class Dog(name: String) extends Mammal
  case class Cat(name: String) extends Mammal

  def printAnimalInfo(animal: Animal)= animal match {
    case dog @ Dog(name) => println(s"Dog: ${dog.name}, woof")
    case cat @ Cat(name) => println(s"Cat: ${cat.name}, meow")
  }

  println(printAnimalInfo(Cat("Baji")))
  println(printAnimalInfo(Dog("Sally")))


  // ###########15 List in a match expression
  // two different ways to create a List
  val x = List(1,3,5, 7)
  val y = 2 :: 4 :: 6 :: 8 :: Nil

  // Useful for recursive functions
  def listToString(list: List[Int]): String = list match {
    case n :: rest => n + " " + listToString(rest)
    case Nil => ""
  }

  def sum(list: List[Int]): Int = list match {
    case n :: rest => n + sum(rest)
    case Nil => 0
  }

  listToString(y)
  val sum: Int = sum(x)
}