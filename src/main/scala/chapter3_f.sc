import java.io.FileNotFoundException

import scala.annotation.tailrec

object chapter3_f {

  // ########## 16 catch one or more exception in a try/catch
  val someFile = "document.txt"
  def openAndReadFile(filename: String) = {
    println("something")
  }

  try {
    openAndReadFile(someFile)
  } catch {
    case e: FileNotFoundException => println("File not found!")
    case e: IndexOutOfBoundsException => println("some IO exception")
  }

  // to catch all the exceptions
  try {
    openAndReadFile(someFile)
  } catch {
    case t: Throwable => t.printStackTrace()
  }

  // Unlike Java it doesn't require specifying a method throws the exception
  def toInt(s: String): Option[Int] =
    try {
      Some(s.toInt)
    } catch {
      case e: Exception => throw e
    }

  // but also specify like java as follows
  @throws(classOf[NumberFormatException])
  def toInt2(s: String): Option[Int] =
    try {
      Some(s.toInt)
    } catch {
      case e: NumberFormatException=> throw e
    }


  // ########## 17 use an object in a try block and access it in the finally

  object VarInTryCatch {
    var s = None: Option[String]

    try {
      s = Some("updated")
    } catch {
      case e: Exception => e.printStackTrace
    } finally {
      println("Finally here!")
      if (s.isDefined) println("It was defined")
    }
  }

  val ob = VarInTryCatch


  // ######### 18 Create own control structure
  def whilst(testCondition: => Boolean)(codeblock: => Unit) = {
    while(testCondition) {
      codeblock
    }
  }

  // Or without using while loo
  @tailrec
  def whilst2(testCondition: => Boolean)(codeblock: => Unit)  {
    if (testCondition) {
      codeblock
      whilst2(testCondition)(codeblock)
    }
  }
}