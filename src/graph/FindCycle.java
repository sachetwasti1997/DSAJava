package graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindCycle {

//    public static boolean isCyclePresent(List<List<Integer>> graph, int node){
//        Set<Integer> isVisited = new HashSet<>();
//        Set<Integer> isBackwardEdge = new HashSet<>();
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(node);
//        isVisited.add(node);
//        while (!queue.isEmpty()){
//            int t = queue.remove();
//            for (int i: graph.get(t)){
//                if (isBackwardEdge.contains(i)){
//                    return true;
//                }
//                if (!isVisited.contains(i)){
//                    queue.add(i);
//                    isVisited.add(i);
//                }
//            }
//            isBackwardEdge.add(t);
//        }
//        return false;
//    }

    public static boolean isCyclePresent(List<List<Integer>> graph, Set<Integer> visited, int node, Set<Integer> beingVisited){
        visited.add(node);
        beingVisited.add(node);
        if (graph.get(node) != null){
            for (Integer i: graph.get(node)){
                if (!visited.contains(i)){
                    isCyclePresent(graph, visited, i, beingVisited);
                }
                if (beingVisited.contains(i))return true;
            }
        }
        beingVisited.remove(node);
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(0, Arrays.asList(1));
        graph.add(1, Arrays.asList(3, 2));
        graph.add(2, Arrays.asList(1, 3));
        graph.add(3, Arrays.asList(1, 2));
        Set<Integer> visited = new HashSet<>();
        Set<Integer> isBeingVisited = new HashSet<>();
        System.out.println(isCyclePresent(graph, visited, 0, isBeingVisited));
    }

}
