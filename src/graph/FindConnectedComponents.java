package graph;

import java.util.*;

public class FindConnectedComponents {

    public int dfs(Map<Integer, List<Integer>> graph){
        Set<Integer> visited = new HashSet<>();
        int connectedComponentCount = 0;
        for(Map.Entry<Integer, List<Integer>> graphTraverse: graph.entrySet()){
            if(!visited.contains(graphTraverse.getKey())){
                connectedComponentCount ++;
                dfsHelper(graph, graphTraverse.getKey(), visited);
            }
        }
        return connectedComponentCount;
    }

    public void dfsHelper(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited){
        visited.add(node);
        if(graph.get(node) == null)return;
        for(int i:graph.get(node)){
            if(!visited.contains(i)){
                dfsHelper(graph, i, visited);
            }
        }
    }

    public Map<Integer, List<Integer>> formAdjList(int[][] edges){
        Map<Integer, List<Integer>> adjList = new HashMap<>(edges.length);
        for(int i=0; i<edges.length; i++){
            if(!adjList.containsKey(edges[i][0]))adjList.put(edges[i][0], new ArrayList<>());
            if(!adjList.containsKey(edges[i][1]))adjList.put(edges[i][1], new ArrayList<>());
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        System.out.println(adjList);
        return adjList;
    }

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = formAdjList(edges);
        for(int i=0; i<n; i++){
            if(!graph.containsKey(i))graph.put(i, new ArrayList<>());
        }
        return dfs(graph);
    }

    public static void main(String[] args) {
        int[][] edges = {{2,3},{1,2},{1,3}};
        Arrays.stream(edges).forEach(i -> {
            for(int it: i){
                System.out.print(it+" ");
            }
            System.out.println();
        });
        FindConnectedComponents comp = new FindConnectedComponents();
        int result = comp.countComponents(5, edges);
        System.out.println(result);
    }

}
