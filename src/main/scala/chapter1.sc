object chapter1 {
  // #1 Compare two strings to see if they are 'equal'. (contains the same sequence of chars)

  val s1 = "hello"
  val s2 = "HeLlo"
  val s3 = "morning"
  val s4 = s2.toLowerCase()

  s1 == s2
  s1 == s3
  s1 == s4

  s1.equalsIgnoreCase(s2)


  // #2 Create multiline strings
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

  // #3 Split a string into parts based on separator.
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

  
}