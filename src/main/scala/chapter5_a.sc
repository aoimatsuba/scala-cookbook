object chapter5_a {
package chapter5_a {
    // #########1 Control method scope

    class Foo {

      // Object-private
      private[this] def isFoo = true

      // private
      private def isBoo = false

      def doFooAndBoo(foo: Foo): Unit = {
        println(this.isFoo)
        //println(foo.isFoo) // ERROR: inaccessible from othe objects except this
        println(foo.isBoo) //This compiles
      }
    }

    val f = new Foo
    val b = new Foo
    f.doFooAndBoo(b)

    // In Java, protected methods can be accessed by other classes in same package
    // But in Scala, only child class can access

    class Animal {
      private def swim {}

      protected def breath {}
    }

    class Cat extends Animal {
      // swim // doesn't compile
      breath
    }


    // To make the methods available for other classes in the same package,
    // use private[<packageName>]
    class Algae {
      private[chapter5_a] def expand {}
    }

    class Plant {
      val animal = new Animal
      // animal.breath // doesn't compile like Java
      val algae = new Algae
      algae.expand // Accessible because it is in the same package
    }
    // if access modifier is not specified, it is public
  }

}