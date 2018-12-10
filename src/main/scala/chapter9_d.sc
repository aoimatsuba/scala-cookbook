object chapter9_d {

  // ##########9 Real-world example of functional programming
  object NewtonsMethod {

    def driver: Unit = {
      val fx = (x: Double) => 3*x + math.sin(x) - math.pow(math.E, x)
      val fxPrime = (x: Double) => 3 + math.cos(x) - math.pow(math.E, x)

      val initialGuess = 0.0
      val tolerance = 0.00005

      //pass fx and fxPrime to the newton's method function
      val answer = newtonsMethod(fx, fxPrime, initialGuess, tolerance)
      println(answer)
    }

    def newtonsMethod(fx: Double => Double, fxPrime: Double => Double,
                      x: Double, tolerance: Double): Double = {
      var x1: Double = 1
      var xNext = newtonsMethodHelper(fx, fxPrime, x1)

      while(math.abs(xNext-x1) > tolerance) {
        x1 = xNext
        println(xNext)
        xNext = newtonsMethodHelper(fx, fxPrime, x1)
      }
      xNext
    }

    def newtonsMethodHelper(fx: Double => Double, fxPrime: Double => Double,
                            x: Double): Double = {
      x - fx(x) / fxPrime(x)
    }
  }

}