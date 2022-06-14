package graph;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class CloneGraph {

    static PrintStream print = System.out;
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
//                    ", neighbors=" + neighbors +
                    '}';
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null)return null;
        Map<Integer, Node> newNodeMap = new HashMap<>();
        Queue<Node> nodeQue = new LinkedList<>();
        nodeQue.add(node);
        while(!nodeQue.isEmpty()){
            var nodeRetrived = nodeQue.remove();
            if(!newNodeMap.containsKey(nodeRetrived.val)){
                newNodeMap.put(nodeRetrived.val, new Node(nodeRetrived.val));
            }
            for(Node n: nodeRetrived.neighbors){
                if(!newNodeMap.containsKey(n.val)){
                    Node childNode = new Node(n.val);
                    nodeQue.add(n);
                    newNodeMap.get(nodeRetrived.val).neighbors.add(childNode);
                    newNodeMap.put(n.val, childNode);
                }else{
                    newNodeMap.get(nodeRetrived.val).neighbors.add(newNodeMap.get(n.val));
                }
            }
        }
        return newNodeMap.get(node.val);
    }

    public static void main(String[]args){

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph gr = new CloneGraph();

        var node = gr.cloneGraph(node1);

        print.println(node.neighbors);
        node = node.neighbors.get(0);
        print.println(node.neighbors);
        node = node.neighbors.get(1);
        print.println(node.neighbors);
        node = node.neighbors.get(1);
        print.println(node.neighbors);

    }

}
