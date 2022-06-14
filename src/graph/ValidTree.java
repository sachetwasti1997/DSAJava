package graph;
import java.util.*;

public class ValidTree {

    public Map<Integer, List<Integer>> returnAdjacencyList(int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            if(!graph.containsKey(edges[i][0]))graph.put(edges[i][0], new ArrayList<>());
            if(!graph.containsKey(edges[i][1]))graph.put(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }

    public boolean detectCycleInUndirectedGraph(Map<Integer, List<Integer>> graph, int parent, int node, boolean[] visited){
        visited[node] = true;
        if(graph.get(node) != null){
            for(int i: graph.get(node)){
                if(!visited[i]){
                    if(detectCycleInUndirectedGraph(graph, node, i, visited))return true;
                }else if(parent != i){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = returnAdjacencyList(edges);
        System.out.println(graph);
        int count = 0;
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                count ++;
               if(detectCycleInUndirectedGraph(graph, -1, i, visited))return false;
            }
        }
        return count == 1 ? true : false ;
    }

    public static void main(String[] args){
        ValidTree tree = new ValidTree();
        int [][] edges = {{0, 1}, {2,3}};
        System.out.println(tree.validTree(4, edges));
    }

}
