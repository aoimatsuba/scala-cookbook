object chapter3_c {
  // ###########7 Use match statement as switch in Java
  def month (i: Int)= i match {
    case 1 => "January"
    case 2 => "February"
    case 3 => "March"
    case something => s"$something doesn't work"
  }

  month(23)

  val day = 4
  val dayString = day match {
    case 1 => "Monday"
    case 2 => "Tuesday"
    case 3 => "Wednesday"
    case 4 => "Thursday"
    case 5 => "Friday"
    case _ => "Weekend"
  }

  // Can also match the type
  def strOrNum(value : Any) = value match {
    case n : Int => "It is Integer"
    case s : String => "It is String!"
    case _ => "Something else!"
  }
  strOrNum(5)
  strOrNum("strombonbon")
  strOrNum(4.2)


  // match statement not really needed if you use Map
  val monthMap = Map(
    1 -> "Jan",
    2 -> "Feb",
    3 -> "March"
  )
  val monthString = monthMap(3)
  //val invalidMonth = monthMap(9) // No such element exception


  // ###########8 match with multiple conditions
  val m = 4
  val season = m match {
    case 12 | 1 | 2 => "winter"
    case 3 | 4 | 5 => "spring"
    case 6 | 7 | 8 => "summer"
    case 9 | 10 | 11 => "fall"
  }

  // this works for case objects too
  trait Command
  case object Start extends Command
  case object Go extends Command
  case object Stop extends Command
  case object Whoa extends Command

  def executeCommand(cmd: Command) = cmd match {
    case Go | Start => "start()"
    case Stop | Whoa => "stop()"
  }

  // ###########9 Assigning the result of match expression to var
  val quarter = m match {
    case 3 | 1 | 2 => println("quarter1")
    case 6 | 4 | 5 => println("quarter2")
    case 9 | 7 | 8 => println("quarter3")
    case 12 | 10 | 11 => println("quarter4")
  }
  quarter
  // Scala = expression-oriented programming (EOP) language
  // -> almost every construction is an expression thus yields a value
}