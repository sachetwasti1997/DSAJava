package graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortestPathUnweightedGraph {

    public static void findShortestDistance(Map<Integer, Set<Integer>> graph, int node){
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(node);
        distanceMap.put(node, 0);
        visited.add(node);
        while (!queue.isEmpty()) {
            Integer tempNode = queue.remove();
            if (graph.get(tempNode) == null)continue;
            int tempDistance = distanceMap.get(tempNode) + 1;
            for (int i: graph.get(tempNode)){
                if (!visited.contains(i)){
                    distanceMap.put(i, tempDistance);
                    visited.add(i);
                    queue.add(i);
                }
            }
        }
        System.out.println(distanceMap);
    }

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.put(0, Stream.of(1, 2, 4).collect(Collectors.toSet()));
        graph.put(1, Stream.of(0, 3).collect(Collectors.toSet()));
        graph.put(2, Stream.of(0, 3, 4).collect(Collectors.toSet()));
        graph.put(3, Stream.of(1, 2, 5).collect(Collectors.toSet()));
        graph.put(5, Stream.of(3, 4).collect(Collectors.toSet()));
        graph.put(4, Stream.of(0, 2, 5).collect(Collectors.toSet()));
        findShortestDistance(graph, 0);
    }

}
