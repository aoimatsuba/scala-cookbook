object chapter5_b {
  // ##########2 Call a method on a superclass
  class FourLeggedAnimal {
    def walk {println("walking")}
    def run {println("running")}
  }

  class Dog extends FourLeggedAnimal {
    def walkAndRun: Unit = {
      super.walk
      super.run
    }
  }

  val hugo = new Dog
  hugo.walkAndRun

  // If a class inherits from multiple traits and the class want to use
  // a method that is implemented for multiple traits, specify trait name
  trait Human {
    def hello = "I am human"
  }

  trait Female extends Human {
    override def hello = "I am Female"
  }

  trait Male extends Human {
    override def hello: String = "I am Male"
  }

  class Child extends Human with Female with Male {
    def printSuper = super.hello
    def printFemale = super[Female].hello
    def printMale = super[Male].hello
    def printHuman = super[Human].hello
  }

  val child = new Child
  println(child.printSuper) // output is "I am Male"
  println(child.printFemale)
  println(child.printMale)
  println(child.printHuman)

  // It cannot reach up through the parent class hierarchy unless you directly
  // extend the target class
  class Girl extends Female {
    def printFemale = super[Female].hello

    // This doesn't compile because Girl class doesn't directly extend Human class
    // (even thought Girl extends Female that extends Human
    //def printHuman = super[Human].hello
  }

  // ###########3 Set default values for method params

  class Cat {
    def introduce(name: String = "Noot", age: Int = 5, color: String = "Brown"): Unit = {
      println(s"My name is $name, and $age years old. I have nice $color hair.")
    }

    def introduce2(name: String = "Baji", size: Int): Unit = {
      println(s"I am $name, I am $size")
    }
    def introduce3(size: Int, name: String = "Baji"): Unit = {
      println(s"I am $name, I am $size")
    }
  }

  val cat = new Cat
  cat.introduce()
  cat.introduce("Baj")
  cat.introduce("Noonoo", 10)
  cat.introduce("Noonoo", 10, "Mixed")
  cat.introduce(age = 9)

  // To set default value to parameters partially, bring it to in the end
  cat.introduce2(size = 5) // Doesn't work unless specifying param name
  cat.introduce3(8)

  // ##########4 Using parameter names when calling a method
  // By specifying the name, you can call in any order
  cat.introduce(color="White", name = "Luna chan", age = 9)
}