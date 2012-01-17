object Problem38 {

  def main(args: Array[String]): Unit = {
    
    var maxConcatProduct = "0"
    //since we have i * 1, we know i must not have any repeated digits
    for (i <- 1 to 100000000 if(hasNoRepeatedDigits(i.toString()))) {
      var n = 1;
      var concatProduct = (i * n).toString()
      
      while (concatProduct.length() < 9) {
        n += 1
        var product = i * n
        concatProduct = concatProduct + product.toString()
        
      }
      if (isPandigital(concatProduct) && concatProduct.length == 9 && concatProduct.toInt > maxConcatProduct.toInt) {
        println(concatProduct)
        maxConcatProduct = concatProduct
      }
    }
  }

  
  def hasNoRepeatedDigits(digits: String): Boolean = {
    val boolArray = Array.fill(10) { false };
    for (i <- 0 to (digits.size - 1)) {
      var temp = Integer.parseInt(digits.substring(i,i+1))
  
     if (boolArray(temp) == true) {
        return false
      }
     boolArray(temp) = true
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