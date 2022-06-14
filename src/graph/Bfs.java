package graph;

import java.util.*;

public class Bfs {

    public static void bfs(Map<Integer, Set<Integer>> graph, Integer i){
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        que.add(i);
        visited.add(i);
        System.out.println(graph);
        while(!que.isEmpty()){
            Integer temp = que.remove();
            System.out.print(temp+" ");
            if(graph.get(temp) == null)continue;
            for(int t: graph.get(temp)) {
                if (!visited.contains(t)) {
                    que.add(t);
                    visited.add(t);
                }
            }
        }
    }

    public static void main(String[] args){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.put(0, new HashSet<>());
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(5);
        graph.put(2, new HashSet<>());
        graph.get(2).add(0);
        graph.get(2).add(4);
        graph.put(1, new HashSet<>());
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.put(3, new HashSet<>());
        graph.get(3).add(1);
        graph.get(3).add(5);
        graph.put(5, new HashSet<>());
        graph.get(5).add(0);
        graph.get(5).add(3);
        graph.get(5).add(4);
        graph.put(4, new HashSet<>());
        graph.get(4).add(2);
        graph.get(4).add(5);
        System.out.println(graph);
        bfs(graph, 0);
    }

}
