object chapter1 {
  // ##########1 Compare two strings to see if they are 'equal'. (contains the same sequence of chars)

  val s1 = "hello"
  val s2 = "HeLlo"
  val s3 = "morning"
  val s4 = s2.toLowerCase()

  s1 == s2
  s1 == s3
  s1 == s4

  s1.equalsIgnoreCase(s2)


  // ###########2 Create multiline strings
  val multilineString =
    """some
      multi
      line
    """
  println(multilineString) //have weired indentation here

  val multilineStringMargin =
    """some
      |multi
      |line
    """.stripMargin

  println(multilineStringMargin)


  // ###########3 Split a string into parts based on separator.
  val longString = "Apple Orange Udon"
  longString.split(" ") // split will return Array of splitted strings
  longString.split("X") // if separator doesn't exist, just return Array of the original string

  longString.split(" ").foreach(x => println(x.toUpperCase))

  // Note for usecase for CSV files etc
  val longStringWithComma = "Apple, Orange, Udon"
  longStringWithComma.split(",") // this will have extra space
  longStringWithComma.split(",").map(_.trim)

  "something".split("e") // This split is from String.java
  "something".split('e') // This split is from StringLike.scala


  // ##########4 Variable substitution to a string
  val name = "Aoi"
  val age = 26
  val company = "AutoScout24"

  println(s"$name at age $age is working at $company.")
  // Finding from above: if you try to include val in the string, it will automatically add `s` for you in the front.
  println(s"Next year, $name will be ${age + 1}")

  // 's' is actually a method
  // There are other string interpolator methods like 'f' and 'raw'
  println(raw"something\nsomething")
  println("something\nsomething")


  // ############5 Iterate through each character in a string
  company.map(c => c.toUpper)
  company.map(_.toUpper)

  for (c <- name) println(c)

  // map and for/yield transform one collection to another
  val brabra = for (c <- company) yield c.toUpper
  val brabrabra = for {
    c <- company
    if c != 'u'
  } yield c.toUpper

  // where as foreach operates on each element w/o returning the result
  val braforeach = company.foreach(c => c.toUpper)

  def toUpper(c: Char) = c.toUpper
  "somethingsomething".map(toUpper)


  // ############6 Determine if a String contains a regular expression

  // Can create Regex object by invoking .r method
  val numberRegex = "[0-9]+".r // -> scala.util.matching.Regex

  val sentenceWithNum = "My address is 24 Buelow street. Apt is on 2nd floor."

  numberRegex.findFirstIn(sentenceWithNum)
  numberRegex.findAllIn(sentenceWithNum).foreach(println)
  numberRegex.findAllIn(sentenceWithNum).toArray

  // Other way to Create Regex: just import Regex class
  import scala.util.matching.Regex
  val numRegex = new Regex("[0-9]+")
  numRegex.findAllIn(sentenceWithNum).toVector
  val sentenceWithoutNum = "Something something"
  numRegex.findAllIn(sentenceWithoutNum)
  numRegex.findAllIn(sentenceWithoutNum).toArray
  numRegex.findFirstIn(sentenceWithoutNum)


  // ############7 Find Regex pattern in string and replace them

  numberRegex.replaceAllIn(sentenceWithNum, "***")


  // ############8 Extract one or more parts of string that match Regex pattern

  val someNumAndLetter = "([0-9]+) ([A-Za-z]+)".r
  // Extract each regex as different params
  val someNumAndLetter(number, alphabet) = "24 Buelow"
  // In order to avoid scala.MatchError, spacing and regex must be exactly the same
  // It is NOT that it will extract all the patterns from the sentence







}