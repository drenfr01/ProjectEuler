object Problem32 {

  def main(args: Array[String]): Unit = {

    var sum = 0
    var prodMap = scala.collection.immutable.HashMap.empty[Int, Boolean]
    println(isPandigital(2.toString()))
    //one can never make a pandigital number
    for (
      i <- 2 to 100 if isPandigital(i.toString());
      j <- 2 to 5 if isPandigital(j.toString())
    ) {
      println(i,j)
      val prod = i * j
      val digits = prod.toString() + i.toString() + j.toString()
      if (digits.size <= 10) {
        if (!prodMap.contains(prod)) {
          if (isPandigital(digits)) {
            println(i, j)
            sum += prod
            prodMap += prod -> true
          }
        }
      }
    }
    println(sum)

  }

  def isPandigital(digits: String): Boolean = {

    for (i <- 1 to digits.size) {
      if (!digits.contains(i.toString))
        return false
    }
    return true
  }

}