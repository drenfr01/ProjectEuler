object Problem27 {

  var primeArray = Array[Boolean]()
  
  def main(args: Array[String]): Unit = {
    calculatePrime(10000)
  
  }

  
  //using sieve of Erastosthenes
  def calculatePrime(n: Int): Unit = {
    primeArray = new Array[Boolean](n + 1)
    for (i <- 1 to n) {
      primeArray(i) = true;
    }

    for (i <- 2 to n / 2) {
      if (primeArray(i) == true) {
        var constant = 2;
        var j = constant * i;
        while (j <= n) {
          primeArray(j) = false
          constant += 1
          j = constant * i
        }
      }
    }
  }
}