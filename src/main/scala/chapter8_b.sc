object chapter9_b {

  // #########4 Use trait as a simple mixins
  // multiple traits can be mixed into a class to provide robust design
  trait Tail {
    def wagTail{println("tail is wagging")}
    def stopTail { println("tail is stopped")}
  }

  abstract class Pet (var name: String) {
    def speak
    def ownerIsHome {println("Happy")}
    def jumpForJoy {println("jumping")}
  }

  class Dog(name: String) extends Pet(name) with Tail {
    override def speak: Unit = println("Woof")

    override def ownerIsHome: Unit = {
      wagTail // from trait
      stopTail
    }
  }


  // ##########5 Limit which classes can use a trait by inheritance
  class StarfleetComponent
  trait StarfleetWarpCore extends StarfleetComponent
  class RomulanStuff
  // This means only classes that extend StarfleetComponent class can
  // extend StarfleetWarpCore trait
  class Starship extends StarfleetComponent with StarfleetWarpCore

  // Following doesn't compile because Warbird does not have StarfleetComponent
  // as its superclass
  // class Warbird extends RomulanStuff with StarfleetWarpCore


  // ##########6 Mark traits so they can only be used by subclasses of a type

  // To make sure a trait is only mixed into a class that is a subclass of a type,
  class Fruit {}

  trait Grape {
    // do following syntax to make sure grape is only mixed into a subclass of Fruit
    // "Self Type" of trait
    this: Fruit =>
    def isSweet
    def isSour
  }

  class Wine extends Fruit with Grape {
    override def isSour: Unit = println("sour!")
    override def isSweet: Unit = println("not sweet")
  }

  // Following doesn't work
  // class Banana extends Grape {} :ERROR illegal inheritance!


}