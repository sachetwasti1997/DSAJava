package union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionFind {

    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] par;
    static int[] rank;

    public int find(int node){
        int p = par[node];
        while(par[p] != p){
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    public boolean add(int i, int j){
        int parent1 = par[i];
        int parent2 = par[j];
        if (parent1 == parent2)return false;
        if(rank[parent1] > rank[parent2]){
            par[parent2] = parent1;
            rank[parent1] += rank[parent2];
        }else {
            par[parent1] = parent2;
            rank[parent2] += rank[parent1];
        }
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        par = new int[edges.length+1];
        rank = new int[edges.length+1];
        List<Pair> newEdges = new ArrayList<>(edges.length);
        Arrays.fill(rank, 1);
        for (int i=0; i<=edges.length; i++)par[i] = i;
        for(int i=0; i<edges.length; i++){
            if(!add(edges[i][0], edges[i][1])){
                newEdges.add(new Pair(edges[i][0], edges[i][1]));
            }
        }
        if (newEdges.size() == 0){
            return new int[]{};
        }
        var pair = newEdges.get(newEdges.size()-1);
        return new int[]{pair.x, pair.y};
    }

    public static void main(String[] args){
        par = new int[3];
        rank = new int[3];
        UnionFind unionFind = new UnionFind();
        int[][] edges = {{7,8},{2,6},{2,8},{1,4},{9,10},{1,7},{3,9},{6,9},{3,5},{3,10}};
        var arr = unionFind.findRedundantConnection(edges);
        System.out.println(Arrays.toString(arr));
    }
}
