package graph;

import java.util.*;

public class CourseSchedule {
    public Map<Integer, List<Integer>> getAdjList(int[][] prerequisites){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0;i<prerequisites.length; i++){
            if(!graph.containsKey(prerequisites[i][0]))graph.put(prerequisites[i][0], new ArrayList<>());
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        return graph;
    }
    public boolean hasCycle(Map<Integer, List<Integer>> graph,boolean[] visited,boolean[] isBeingVisited, int node){
        visited[node] = true;
        isBeingVisited[node] = true;
        if(graph.get(node) != null){
            for(int i: graph.get(node)){

                if(!visited[i] && hasCycle(graph, visited, isBeingVisited, i)){
                    return true;
                }
                if(isBeingVisited[i]){
                    return true;
                }
            }
        }
        isBeingVisited[node] = false;

        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            return true;
        }
        Map<Integer, List<Integer>> graph = getAdjList(prerequisites);
        boolean[] isBeingVisited = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        System.out.println(graph);
        var t = false;
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                t = hasCycle(graph, visited, isBeingVisited, i);
                if(t){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[][] prerequisites = {{2, 0},
                {1, 0},
                {3, 1},
                {3, 2},
                {1, 3}};
        CourseSchedule courseSchedule = new CourseSchedule();
        var t = courseSchedule.canFinish(4, prerequisites);
        System.out.println(t);
    }
}
