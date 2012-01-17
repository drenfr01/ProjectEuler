object Problem41 {


  def main(args: Array[String]) : Unit = {
    
    var maxPrime = 0
    //This isn't a very good solution....doesn't finish in one minute AND doesn't 
    //move through entire search space. Maybe use multi-threading?
    for(i <- 2 to 1000000000)
    {
      if(isPandigital(i.toString()) && calculatePrime(i))
      {
        println(i)
      }
    }
    
  }
  
  //don't use Sieve of Eratosthenes because it's easier to only calculate
  //primes for for the few circular numbers
  def calculatePrime(n: Int): Boolean = {
    for(i <- 2 to Math.sqrt(n).toInt)
    {
      if(n % i == 0)
        return false
    }
    
    return true
  }
  
  def isPandigital(digits: String): Boolean = {

    for (i <- 1 to digits.size) {
      if (!digits.contains(i.toString))
        return false
    }
    return true
  }
}