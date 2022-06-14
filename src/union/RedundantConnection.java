package union;

import java.util.*;

public class RedundantConnection {
    class ExtraEdgesStore{
        int node1;
        int node2;
        ExtraEdgesStore(int node1, int node2){
            this.node1 = node1;
            this.node2 = node2;
        }
    }

    public void createAdjacencyList(Map<Integer, List<Integer>> map, int[][] edges){
        int rows = edges.length, cols = edges[0].length;
        for(int i=0; i<rows; i++){
            if(!map.containsKey(edges[i][0])){
                map.put(edges[i][0], new ArrayList<>());
            }
            if(!map.containsKey(edges[i][1])){
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
    }

    public boolean dfs(int parent, int node, List<ExtraEdgesStore> res,
                       Map<Integer, List<Integer>> graph, Map<Integer, Boolean> visited){
        visited.put(node, true);
        if(graph.get(node) != null){
            for(Integer i: graph.get(node)){
                if(visited.get(i) == null){
                    if(dfs(node, i, res, graph, visited)){
                        return true;
                    }
                }
                else if(visited.get(i) == true && i != parent){
                    res.add(new ExtraEdgesStore(i, node));
                    return true;
                }
            }
        }
        return false;
    }

    public void dfsHelper(Map<Integer, List<Integer>> graph,
                          List<ExtraEdgesStore> res, Map<Integer, Boolean> visited){
        for(Map.Entry<Integer, List<Integer>>tempGraph: graph.entrySet()){
            if(visited.get(tempGraph.getKey()) == null)
                if(dfs(-1, tempGraph.getKey(), res, graph, visited)){
                    return;
                }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        var edgeMap = new HashMap<Integer, List<Integer>>();
        createAdjacencyList(edgeMap, edges);
        List<ExtraEdgesStore> resultStore = new ArrayList<>();
        var visited = new HashMap<Integer, Boolean>(edges.length);
        dfsHelper(edgeMap, resultStore, visited);
        if(resultStore.size() == 0){
            return new int[]{};
        }
        int[] res = new int[2];
        var temp = resultStore.get(resultStore.size()-1);
        resultStore.forEach(re -> System.out.println(re.node1+" "+re.node2));
        res[0] = temp.node1;
        res[1] = temp.node2;
        return res;
    }
}
