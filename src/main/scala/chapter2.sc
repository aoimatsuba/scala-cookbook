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

  //#########5 Compare floating point nums
  val c = 0.3
  val b = 0.1 + 0.2 //This is not exactly 0.3 -> see output
  val absoluteDiff = (a-b).abs

  def ~=(x: Double, y: Double, precision: Double) = {
    if ((x-y).abs < precision) true else false
  }

  ~=(c, b, 0.1)
  ~=(c, b, 0.00000000000000001)
  c == b //false


  //#########6 Handling large nums
  var bigNum = 1234567890
  var bigNum2 = 987654321

  var bigInt = BigInt(1234567890)
  var bigInt2 = BigInt(987654321)

  bigNum * bigNum2 //Doesn't work
  bigInt * bigInt2

  // there's positive/negative infinity(!)
  1.234559344832309E308 > Double.PositiveInfinity


  //#########7 Generating random nums
  val random = scala.util.Random
  random.nextInt
  random.nextInt(709) // can limit max value for next random number 0(incl.) to 100 (excl)

  random.nextDouble // value between 0.0 and 1.0
  random.nextPrintableChar()

  // Also can create range of a range of random range
  val range = 0 to random.nextInt(10)
  for (i <- range) yield i + 2
  for (i <- range) yield random.nextPrintableChar


  //#########8 Creating Range/List/Array of nums
  val range1 = 5 to 100  // 100 is inclusive
  val range1Until = 5 until 10 // exclusive
  val range1By4 = 5 to 100 by 4

  for (i <- range1By4) println(i)
  for (i <- range1Until) println(i)

  val range1InArray = range1.toArray // .toList as well
  val rangeList = 1 to 88 by 5 toList


  //#########9 Formatting nums
  val pi = scala.math.Pi

  f"$pi%1.4f"
  val formatter = java.text.NumberFormat.getIntegerInstance

  formatter.format(10000000) // adds commas
  // can pass locale to formatter to have localized formatting
  val localeDe = new java.util.Locale("de", "DE")
  val formatterDE = java.text.NumberFormat.getIntegerInstance(localeDe)
  formatterDE.format(10000000)

  val currencyFormatter = java.text.NumberFormat.getCurrencyInstance(localeDe)
  currencyFormatter.format(12039493)
  

}
