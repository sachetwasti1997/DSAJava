package graph;

import java.util.*;
import java.util.stream.*;

public class Dfs {

    static void dfs(Map<Integer, Set<Integer>> graph, int node, Set<Integer> visited){
        System.out.print(node+" ");
        visited.add(node);
        if(graph.get(node) == null) return;
        for(int v: graph.get(node)){
            if(!visited.contains(v)){
                dfs(graph, v, visited);
            }
        }
    }

    public static void main(String[] args){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.put(3, Stream.of(2).collect(Collectors.toCollection(HashSet::new)));
        graph.put(2, Stream.of(1, 3).collect(Collectors.toCollection(HashSet::new)));
        graph.put(1, Stream.of(0, 2).collect(Collectors.toCollection(HashSet::new)));
        graph.put(0, Stream.of(1, 4).collect(Collectors.toCollection(HashSet::new)));
        graph.put(4, Stream.of(0, 5, 6).collect(Collectors.toCollection(HashSet::new)));
        graph.put(5, Stream.of(4, 6).collect(Collectors.toCollection(HashSet::new)));
        graph.put(6, Stream.of(4, 5).collect(Collectors.toCollection(HashSet::new)));

        Set<Integer> visited = new HashSet<>();
        dfs(graph, 0, visited);
    }

}
