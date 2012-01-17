object Problem33 {
  
  def main(args : Array[String]) : Unit = {
  
    for(i <- 10 to 99;
        j <- i+1 to 99)
    {
      var canceledFraction = cancelFraction((i.toString(), j.toString()))
    }
  }
  
  def cancelFraction(fraction : (String,String)) : (String,String) = {
    
    //need to figure out way to compare without lists
    var numerator = fraction._1.toList
    var denominator = fraction._2.toList
    
    var set = numerator - denominator(0) - denominator(1)
    if(set != numerator) {
       println(set, numerator,fraction)

    }
    
    return ("hello","world")
  }

}