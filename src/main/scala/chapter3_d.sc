object chapter3_d {
  // #########10 Accessing default case in match
  val i = 4

  i match {
    case 1 => print("number 1!")
    case 2 => print("number 2!")
    case default => print(s"You gave me $default! Denied!\n")
  }

  // #########11 Use pattern match in match expression
  case class Person(name: String, age: Int)

  def matchesAll(x: Any) = x match {
    // constants
    case "meh" => "meh"
    case  0 => "0"
    case true => "true"
    case Nil => "Nil"

    // sequences
    case List(0, _ , 2) => "List of 0, something, and 2"
    case List (1, _*) => "List of 1 and any num of elements"
    case Vector(9, 2, _*) => "Vector of 9, 2, and any num of elements"
    case (0, 2) => "tuple 0 and 2"

    // tuples
    case (6, 4, 2) => "tuple 6 and 4, and 2"
    case Person("Hugo", age) => s"This is Hugo of $age"

    // constructor pattern
    case Person("Noot", 12) =>  "Noot is 12"
    case something: String => s"$something is string"

    // type pattern (done before)
    case i: Int => s"$i is Integer"
    case p: Person => s"person: ${p.name}"
    case list: List[_] => s"$list is list of one element"

    // Cannot really do
    // case list: List(1, 5, _*) => s"$list"
    // Need to use "variable binding"
    case list3 @ List(5, 3, _*) => s"$list3 is list starts from 5"
  }

  println(matchesAll(4))
  println(matchesAll("meh"))
  println(matchesAll(true))
  println(matchesAll(Person("poke", 19)))
  println(matchesAll((6,4,2)))
  println(matchesAll(List(1, 4, 5, 6)))
  println(matchesAll(Vector(9, 2, 2, 4, 5, 6)))
  println(matchesAll("brah"))
  println(matchesAll(List(9)))

  println(matchesAll(List(5, 3, 5, 3,3)))

 // ##########12 match different case classes
  trait Animal
  case class Dog(name: String, size: String, color: String) extends Animal
  case class Cat(name: String, color: String) extends Animal
  case object Bird extends Animal
  case object Meh extends Animal

  def determineAnimalType(animal: Animal): String = animal match {
    case Dog(name, "Big", "golden") => s"$name is golden retriever!"
    case cat: Cat => s"Got some arbitrary $cat"
    case Bird => "Just a bird"
    case Dog(name, "Fwafwa", "black") => s"$name is fwafwa dog"
    case _ => "Some other animal"
  }

  println(determineAnimalType(Dog("Hugo", "Big", "golden")))
  println(determineAnimalType(Cat("Noonoo", "mix")))
  println(determineAnimalType(Bird))
  println(determineAnimalType(Dog("Sally", "Fwafwa", "black")))
  println(determineAnimalType(Meh))

}