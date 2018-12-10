object chapter8_c {

  // #########7 Ensure a trait can only added to a type with a specific method
  // Use self type syntax again
  trait Grape {
    // self type method can be multiple as well
    this: { def canMakeWine: Unit } =>
  }

  class Wine extends Grape {
    def canMakeWine: Unit = println("Good wine was made.")
  }

  // This self type method is called "structural type"


  // ##########8 Add a trait to an object instance
  // Just add a trait to an object instance when the object is created
  class Cat

  trait Angry {
    println("Grrrrr")
  }
  // with trait
  val Baj = new Cat with Angry
  // without trait
  val Noot = new Cat


  // ###########9 Extend a java interface like a trait
  // java
  /*
  public interface Animal { public void speak(); }
  public interface Wagging { public void wag(); }
   */

  // then just in scala
  /*
  class Dog extends extends Animal with Wagging {
  def speak {...}
  def wag {...}
  }
  */
}