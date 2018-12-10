//package chapter6_c
//package object packageExample {
//
//  // ##########7 Putting common code in package objects
//  // Make the code available to all classes within a package
//
//  val MAGIC_NUM = 42
//  def echo(a: Any)= println(a)
//
//  // Enumeration
//  object Margin extends Enumeration {
//    type Margin = Value
//    val TOP, BOTTOM, LEFT, RIGHT = Value
//  }
//
//  // Type definition
//  type MutableMap[K, V] = scala.collection.mutable.Map[K, V]
//  val MutableMap = scala.collection.mutable.Map
//
//}

object chapter6_c {
  // Above package object can be accessed from other classes/traits/objects
  // in package com./../whereAbovePackageObjectIs.packageExample

  // ##########8 Create object instances w/o using the "new" keyword

  // two ways to do it
  // Create a companion object and define an apply method there
  class Person {
    var name: String = _
  }

  object Person {
    def apply(name: String): Person = {
      var p = new Person
      p.name = name
      p
    }
  }
  val Tom = Person("Tom")

  // Or just use case class
  case class Plant(name: String)
  val Baj = Plant("Baj")


  // ##########9 Implement the factory method with apply
  trait Animal {
    def speak = println("who am i")
  }

  object Animal {
    private class Dog extends Animal {
      override def speak: Unit = println("woof")
    }

    private class Cat extends Animal {
      override def speak: Unit = println("meow")
    }

    // The factory method
    def apply(s: String): Animal = s match {
      case "dog" => new Dog
      case _ => new Cat
    }
  }

  val doggo = Animal("dog")
  doggo.speak
  val kitten = Animal("cat")
  kitten.speak
}