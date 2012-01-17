object Problem29 {

  def main(args: Array[String]): Unit = {
    var termList = List[Double]()
    var term = 0d;

    for (
      a <- 2 to 100;
      b <- 2 to 100
    ) {
      term = Math.pow(a.toDouble, b.toDouble)
      println(a, b, term)
      termList = termList ++ List(term)
    }
    //convert list to set (which allows only distinct elements)
    println(termList.toSet.size)

  }

}