package graph;

import java.util.*;

public class CScheduleii {

    public void makeAdjList(Map<Integer, List<Integer>> graph, int[][] prerequisites){
        for(int i=0; i<prerequisites.length; i++){
            if(!graph.containsKey(prerequisites[i][0])){
                graph.put(prerequisites[i][0], new ArrayList<>());
            }
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
    }

    public boolean isCyclePresent(Map<Integer, List<Integer>> graph,
                                  boolean[] visited, boolean[] recStk, int node){
        recStk[node] = true;
        visited[node] = true;
        if(graph.get(node) != null){
            for(Integer child: graph.get(node)){
                if(!visited[child] && isCyclePresent(graph, visited, recStk, child)){
                    return true;
                }
                if(recStk[child]){
                    return true;
                }
            }
        }
        recStk[node] = false;
        return false;
    }

    public boolean isCycleHelper(int numCourses, Map<Integer, List<Integer>> graph){
        boolean[] visited = new boolean[numCourses];
        boolean[] recStk = new boolean[numCourses];

        for(Map.Entry<Integer, List<Integer>> graphSet:graph.entrySet()){
            if(!visited[graphSet.getKey()]){
                var t = isCyclePresent(graph, visited, recStk, graphSet.getKey());
                if(t){
                    return true;
                }
            }
        }

        return false;
    }

    public void topologicalSort(Map<Integer, List<Integer>> graph, boolean[] visited,
                                int node, Stack<Integer> topSort){
        visited[node] = true;
        if(graph.get(node) != null){
            for(Integer child: graph.get(node)){
                if(!visited[child]) topologicalSort(graph, visited, child, topSort);
            }
        }
        topSort.add(node);
    }

    public int[] topSortHelper(int numCourses,Map<Integer, List<Integer>> graph){
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stkTopSort = new Stack<Integer>();
        for(Map.Entry<Integer, List<Integer>> graphSet:graph.entrySet()){
            if(!visited[graphSet.getKey()]){
                topologicalSort(graph, visited, graphSet.getKey(), stkTopSort);
            }
        }
        int[] orderArray = new int[stkTopSort.size()];
        int n = stkTopSort.size() - 1;
        while(n >= 0){
            orderArray[n--] = stkTopSort.pop();
        }
        return orderArray;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] orderArray;
        if(prerequisites.length == 0){
            int n = 0;
            orderArray = new int[numCourses];
            while(n < numCourses){
                orderArray[n] = n;
                n++;
            }
            return orderArray;
        }

        var graph = new HashMap<Integer, List<Integer>>(numCourses);

        makeAdjList(graph, prerequisites);

        var isCycle = isCycleHelper(numCourses, graph);

        if(isCycle){
            return new int[]{};
        }

        int[] resOrder = topSortHelper(numCourses, graph);
        System.out.println(Arrays.toString(resOrder));
        Set<Integer> set = new HashSet<>();
        Arrays.stream(resOrder).forEach(t -> set.add(t));
        if(resOrder.length < numCourses){
            int[] finalOrder = new int[numCourses];
            for(int i=0; i<resOrder.length; i++){
                finalOrder[i] = resOrder[i];
            }
            int n = resOrder.length;
            for(int i=0; i<numCourses && n < numCourses; i++){
                if(!set.contains(i))finalOrder[n++] = i;
            }
            return finalOrder;
        }

        return resOrder;

    }

    public static void main(){}

}
