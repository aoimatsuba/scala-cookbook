object test {


  def Baj(name: Option[String], age: Int): Boolean = name match {
    case Some(_) => true
  }

  Baj(None, 4)
}