import scala.collection.mutable.HashMap



//other possible solutions (from forum): could work from base upwards, and set each parent cost to the max of each   
object Problem18 {
  
  val INFINITY = 10000000
  val numberOfLevels = 100;
  val numberOfNodes = (numberOfLevels * (numberOfLevels + 1)) / 2
  val numberOfEdges = ((numberOfLevels - 1) * (numberOfLevels)) //so there are 14 levels of nodes with 2 edges each
  var vertexArray = new Array[TreeNode](numberOfNodes)
  var edgeArray =  new Array[(TreeNode,TreeNode, Int)](numberOfEdges)
  var edgeMap = new HashMap[TreeNode, List[TreeNode]]

  def main(args: Array[String]): Unit = {
    loadData
    loadEdges
    //edgeArray.foreach{case(t1,t2,cost) => println(t1.cost, t2.cost, cost)}
    println(dagLongestPath + vertexArray(0).cost)
    
  }

  //note: longest path is normally NP-hard, but since this is an acyclic, directed graph it can
  //be reduced to a polynomial time problem. It can be solved either by negating weights and using 
  //shortest path algorithm (because minimizing a negative leads to the greatest absolute value) such as Djikstra's
  //or using linear time dag-longest-path algorithm
  def dagLongestPath : Int = {
    var lengthTo = Array.fill(vertexArray.length) { 0 }
    for (vertex <- vertexArray) {
      var childCounter = 0
      if(vertex.position >= numberOfEdges / 2) {
            return lengthTo.reduceLeft((n1,n2) => if(n2 > n1) n2 else n1  )
      }
      for (child <- edgeMap.get(vertex).get) {
        var childPosition = vertex.position + vertex.level + childCounter
        if (lengthTo(childPosition) <= lengthTo(vertex.position) + child.cost) {
          lengthTo(childPosition) = lengthTo(vertex.position) + child.cost
        }

        childCounter += 1
      }

    }
    //note, doesn't count the cost to get to first code
    return lengthTo.reduceLeft((n1,n2) => if(n2 > n1) n2 else n1  )
  }
  
  def loadEdges = {
    //go to leaf nodes. This is a little rough, and definitely prone to array out of bounds exceptions....
   // var edgeCounter = 0;
    for(i<- 0 to (numberOfNodes-numberOfLevels-1))
    {
      var leftChild = vertexArray(vertexArray(i).level + i)
      var rightChild = vertexArray(vertexArray(i).level + i + 1)
      edgeMap += vertexArray(i) -> List(leftChild, rightChild)
      //println(vertexArray(i).cost, leftChild.cost,rightChild.cost)
      
      /*
      edgeArray(edgeCounter) = (vertexArray(i),leftChild, leftChild.cost)
      edgeCounter += 1
      edgeArray(edgeCounter) = (vertexArray(i), rightChild, rightChild.cost)
      edgeCounter +=1     
      */ 
    }
  }

  def loadData = {
    var lines = io.Source.fromFile("/Users/duncanrenfrow-symon/git/ProjectEulerRepository/ProjectEulerProblems/src/triangle").getLines
    var tempArray = lines.next().split(" ")
    var level = 1;
    for (i <- 0 to (numberOfNodes - 1)) {
      val node = new TreeNode()
      node.cost = Integer.parseInt(tempArray(i))
      //sets level of node, this is probably not the best way to do it...
      if (i + 1 > (level * (level + 1) / 2)) {
        level += 1
      }
      node.level = level
      node.position = i
      vertexArray(i) = node
    }

   // vertexArray.foreach(x => println(x.cost, x.level, x.position))
  }
}



class TreeNode {

  //note: in Scala public variables are actually functions, so these have get/set methods built in
  var level: Int = -1
  var cost: Int = -1
  var position : Int = -1
}
