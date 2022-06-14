package graph;

import java.util.*;

public class CourseScheduleii {

    public void prepareAdjList(int[][] prerequisites, Map<Integer, List<Integer>> graph){
        for(int i=0; i<prerequisites.length; i++){
            if(!graph.containsKey(prerequisites[i][0]))graph.put(prerequisites[i][0], new ArrayList<>());
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
    }

    public boolean isPossibleToFinishCourse(Map<Integer, List<Integer>> graph,
                                            int node, boolean[] isVisited, boolean[] isBeingVisited){
        isBeingVisited[node] = true;
        isVisited[node] = true;
        if(graph.get(node) != null){
            for(Integer i: graph.get(node)){
                if(!isVisited[i] && isPossibleToFinishCourse(graph, i, isVisited, isBeingVisited))return true;
                if(isBeingVisited[i])return true;
            }
        }
        isBeingVisited[node] = false;
        return false;
    }

    public void findTopologicalSort(Map<Integer, List<Integer>> graph,
                                    int node, Stack<Integer> stk,
                                    boolean [] isVisited){
        isVisited[node] = true;
        if(graph.get(node) != null){
            for(Integer i: graph.get(node)){
                if(!isVisited[i]){
                    findTopologicalSort(graph, i, stk, isVisited);
                }
            }
        }
        stk.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            int n = 0;
            int[] orderArray = new int[numCourses];
            while(n < numCourses){
                orderArray[n] = n;
                n++;
            }
        }
        boolean [] visited = new boolean[numCourses];
        boolean[] isBeingVisited = new boolean[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>(numCourses);
        if(numCourses > 1 && prerequisites.length > 0)prepareAdjList(prerequisites, graph);
        System.out.println(graph);
        var findTopologicalSort = true;
        if(numCourses > 1 && prerequisites.length > 0){
            for(Map.Entry<Integer, List<Integer>> mapSet: graph.entrySet()){
                if(!visited[mapSet.getKey()]){
                    findTopologicalSort = isPossibleToFinishCourse(graph, mapSet.getKey(), visited, isBeingVisited);
                    if(findTopologicalSort){
                        break;
                    }
                }
            }
        }
        Arrays.fill(visited, false);
        Stack<Integer> order = new Stack<Integer>();
        if(!findTopologicalSort && numCourses > 1 && prerequisites.length > 0){
            for(Map.Entry<Integer, List<Integer>> mapSet: graph.entrySet()){
                if(!visited[mapSet.getKey()])findTopologicalSort(graph, mapSet.getKey(), order, visited);
            }
        }
        if(findTopologicalSort){
            int[] n = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                n[i] = i;
            }
            return n;
        }
        int arrSize = order.size();
        if(arrSize < numCourses)arrSize = numCourses;
        int[] orderArray = new int[arrSize];
        var sett = new HashSet<>(arrSize);
        int k = order.size()-1;
        int temp = order.size()-1;
        while(!order.isEmpty()){
            int kt = order.pop();
            orderArray[k--] = kt;
            sett.add(kt);
        }

        if(temp < arrSize){
            for(int i=0; i<numCourses; i++){
                if(!sett.contains(i)){
                    orderArray[temp++] = i;
                }
            }
        }
        if(numCourses == 1)return new int[]{0};
        int n = 0;
        if(prerequisites.length == 0){
            orderArray = new int[numCourses];
            while(n < numCourses){
                orderArray[n] = n;
                n++;
            }
        }
        return orderArray;
    }

    public static void main(String[] args){
        int[][] prerequisites = {
//                {2, 0},
//                {1, 0},
//                {3, 1},
//                {3, 2},
//                {1, 3}
        };
        CourseScheduleii schedule = new         CourseScheduleii();
        var t = schedule.findOrder(1, prerequisites);
        System.out.println(Arrays.toString(t));
    }

}
