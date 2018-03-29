/**
 * Node
 *  variables:
 *    connected nodes list
 *  methods:
 *    connect to
 *
 * Graph
 *  variables:
 *    node list
 *  methods:
 *    create new node
 *
 */
class Graph {
  class Node {
    var connectedNodes = List[Node]()
    def connectTo(node: Node) {
      if (connectedNodes.find(node.equals).isEmpty) {
        connectedNodes = node :: connectedNodes
      }
    }
    def showRelation() {
      connectedNodes.foreach(print)
    }
  }
  var nodes = List[Node]()
  def newNode(): Node = {
    val node = new Node
    nodes = node :: nodes
    node
  }
  def display() {
    nodes.foreach(node => (print(node + " => "), node.showRelation(), println))
  }
}

object InnerClasses extends App {
  val graph1: Graph = new Graph
  val node1: graph1.Node = graph1.newNode
  val node2: graph1.Node = graph1.newNode
  val node3: graph1.Node = graph1.newNode
  node1.connectTo(node2)
  node3.connectTo(node1)
  graph1.display;
}
