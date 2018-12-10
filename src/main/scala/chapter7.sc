import java.util
// This whole chapter is about packaging and imports so not too much code

  // ##########1 packaging with curly braces style notation
  // In order to put multiple packages in one file, use curly braces
  package com.apple {
    class Foo {
      override def toString: String = "Foo is under apple"}
  }
  // THOSE APPLE AND SUN ARE ACTUALLY JUST FROM EXAMPLE
  package com.sun {
    class Foo {
      override def toString: String = "This foo is under sun!"
    }
  }

object chapter7 {
  //import com.apple.Foo
  //import com.sun.Foo
  // val f1 = new Foo
  // val f2 = new Foo


  // ###########2 Import one ore more members
  // Just import following way
  // import everything from a package
  import java.io._
  // Just pick certain things
  import java.io.{File, FileNotFoundException}


  // ###########3 Renaming members on imports

  // by renaming you can avoid namespace collisions
  import java.util.{ArrayList => JavaList}
  val list = new JavaList[String]
  // this case the original name cannot be used
  //val list2 = new ArrayList[String] => ERROR


  // ##########4 Hiding a class during the import process
  // Point the class name to wildcard by changing the name
  import java.util.{Random => _, _}
  // Now Random is not accessible, but others are still accessible
  // val r = new Random
  val a = new Hashtable[String, Int]
  // Needs to note that wildcard _ must be in the last position.


  // ###########5 Use static imports
  // Use wildcard
  import java.lang.Math._
  val b = cos(0)
  import java.awt.Color._
  println(RED)


  // ##########6 Use import statement anywhere
  // can place import anywhere in order to limit the scope
}

