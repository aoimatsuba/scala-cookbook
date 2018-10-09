object chapter2 {
  //#########1  Convert string to a numeric type
  val number = "134"
  number.toInt
  number.toDouble
  number.toLong

  // or use BigInt or BigDecimal to directly pass a string
  BigInt("65")
  BigDecimal("63")

  // Use java.lang.Integer to parseInt
  Integer.parseInt("101", 2) // 101 in binary number is 5
  Integer.parseInt("13", 16) // hexadecimal number

  // For scala it doesn't have checked NumberFormantException
  // java
  val notNum = "something"
  //notNum.toInt // -> java.lang.NumberFormatException
  // scala
  def toInteger(s: String) = s.toInt
  //val result = toInteger(notNum)

  def toIntWithException(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: NumberFormatException => None
    }
  }

  val result2 = toIntWithException(notNum)


  //#########2 Convert one numeric number to another (casting)
  number.toDouble
  3.toDouble
  124.5.toInt
  126.9.toInt

  // Can check whether the value is valid for casting to a specific type
  val a = 1000L
  a.isValidLong
  a.isValidByte
  a.isValidInt


  //#########3 Override default numeric type
  val num = 23 // -> Int
  val numD = 23d // -> Double
  val numL = 23L // -> Long

  // Another annotation
  val numDouble = 24 : Double
  val numByte = 11 : Byte
  val numDouble0 = 0 : Double

  // or just
  val numDoublee : Double = 0


  //#########4 Increment/Decrement numbers w/o using ++/--
  var numVar = 23
  numVar += 1
  println(numVar)
  numVar -= 2
  println(numVar)

  // num += 2 will get coompiler error: "value += is not a member of Int"

}
