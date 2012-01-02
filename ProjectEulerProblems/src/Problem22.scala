import scala.io.Source

object Problem22 {

  val nameList = new java.util.ArrayList[String]
  var nameSum = 0d;
  
  def main(args : Array[String]) : Unit = {
    
    var input = Source.fromFile("/Users/duncanrenfrow-symon/Documents/workspace/ProjectEulerProblems/src/names.txt").getLines().toList.toString()
    var nameList = input.split(",")
    nameList(0) = "\"MARY\""
    nameList(5162) = "\"ALONSO\""
    nameList = nameList.sorted
    println(calculateNameScore(nameList))
    
  }
  
  def calculateNameScore(list : Array[String]) : Double = {
    var counter = 1;
    for(name <- list)
    {
   
      var nameScore = 0d;
      name.toCharArray().foreach(x =>  if(x != '"') nameScore = nameScore + (x.toInt-64) )
      nameScore = nameScore * counter
      nameSum = nameSum + nameScore
      counter+=1
      if(name == "\"AARON\"")
      {
        println(counter)
        println(nameScore)
      }
      
    }
    
    return nameSum
  }
  
 

}