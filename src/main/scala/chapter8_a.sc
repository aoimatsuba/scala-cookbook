object chapter8_a {

  // TRAITs
  // #########1 Use a trait as an interface
  trait BaseSoundPlayer {
    def play
    def close
    def pause
    def stop
    def resume
  }

  trait Dog {
    def speak(say: String)
    def wagTail(isWagging: Boolean)
  }

  // If the class extends the trait, it must implement all the abstract trait
  // methods, unless the class is abstract
  class Hugo extends Dog {
    override def speak(say: String): Unit = println("say")

    override def wagTail(isWagging: Boolean): Unit = {
      if (isWagging) println("Hugo is happy") else println("Meh")
    }
  }

  // abstract class
  abstract class Cat {
    def speak
    def wagTail
  }

  class Baj extends Cat {
    override def speak: Unit = println("BAJ")
    override def wagTail: Unit = println("NEVER")
  }


  // #########2 Use abstract and concrete fields in traits
  trait PizzaTrait {
    var numToppings: Int // abstract field
    var size = 14 // concrete field
    val maxNumOfToppings = 10 // concrete
  }

  class Pizza extends PizzaTrait {

    // Override keyword is not needed for abstract field
    var numToppings: Int = 8
    // BUT override necessary for val field
    override val maxNumOfToppings: Int = 9

    // Override and var is not needed for concrete field
    size = 2
  }


  // #########3 Use trait like an abstract class
  trait Pet {
    def speak = println("Hey") // concrete implementation
    def comeToMaster // abstract method
  }

  class Doggo extends Pet {
    // Doesn't need to implement speak
    override def comeToMaster: Unit = println("Comiiiiing")
  }

  class Catten extends Pet {
    // Or can override
    override def speak: Unit = println("Meh")
    override def comeToMaster: Unit = println("Not coming")
  }

  // Trait is used more often than abstract class because a class
  // can extend multiple trait but not class
}