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

  // #4 Variable substitution to a string
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

}