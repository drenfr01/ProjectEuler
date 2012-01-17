object Problem35 {

  var primeArray = Array[Boolean]()

  def main(args: Array[String]): Unit = {
    var count = 0d;

    calculatePrime(1000000)

    for (n <- 2 to 1000000) {
      if (isPrime(n) && isCircular(n)) {
        println(n)
        count += 1
      }
    }
    print("Number of circular primes below 1,000,000 is : " + count)
  }

  def isPrime(n: Int): Boolean = {
    return primeArray(n)
  }

  //using Sieve of Eratosthenes
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

  //this is so iterative it hurts...
  def isCircular(n: Int): Boolean = {
    var originalPrime = n

    //For easy rotation, make it into char array
    var possiblePrimeNumber = "";
    var possiblePrime = n.toString().toCharArray()
    do {
      possiblePrimeNumber = "";
      var temp = possiblePrime(0)
      for (i <- 0 to (possiblePrime.length - 1)) {
        if ((i + 1) < possiblePrime.length) {
          possiblePrime(i) = possiblePrime(i + 1)
        } else {

          possiblePrime(i) = possiblePrime(0)
        }
      }
      possiblePrime(possiblePrime.length - 1) = temp

      possiblePrime.foreach(x => possiblePrimeNumber = possiblePrimeNumber + x)
      if (!isPrime(possiblePrimeNumber.toInt))
        return false
    } while (possiblePrimeNumber.toInt != originalPrime)
    return true
  }

}