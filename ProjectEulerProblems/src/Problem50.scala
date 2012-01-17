object Problem50 {

  var primeArray = Array[Boolean]()
  val PRIMELIMIT = 1000
		   
  def main(args: Array[String]): Unit = {
   
    var startTime = java.util.Calendar.getInstance().getTimeInMillis()
    
    var primeList = calculatePrimes(PRIMELIMIT)
    var endTime = java.util.Calendar.getInstance().getTimeInMillis()
    println(primeList)
    println(calculateSumOfMostConsecutivePrimes(primeList, 0, 0, 0))
    println("This took: "  + (endTime-startTime) / 1000 + " seconds")  

  
  }
  
  //can do this recursively
  //crap, the max substring doesn't have to start at 0, can be anywhere
  def calculateSumOfMostConsecutivePrimes(list : List[Int], sum : Int, maxSum : Int, listPosition : Int) : Int = {
    if(sum > PRIMELIMIT) {
       return maxSum
    }
    else {
      if(primeArray(sum) == true)
         calculateSumOfMostConsecutivePrimes(list, sum + list(listPosition), sum, listPosition + 1)
       else
    	 calculateSumOfMostConsecutivePrimes(list, sum + list(listPosition), maxSum, listPosition + 1)
    }
    	
  }

  //using Sieve of Eratosthenes
  def calculatePrimes(n: Int): List[Int] = {
    var primeList = List[Int]()
    primeArray = Array.fill(n+1) {true}


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

    for (i <- 2 to n) {
      if (primeArray(i) == true) {
        primeList = primeList ++ List(i)
      }
    }
    return primeList
  }
}