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
}
