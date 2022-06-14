package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UnionFind {

//    static class node{
//
//    } Not Required

    public int find(int[] parent, int n1){
        while(parent[n1] != n1){
            parent[n1] = parent[parent[n1]];
            n1 = parent[n1];
        }
        return n1;
    }

    public int union(int[] parent, int[] rank, int n1, int n2){
        int p1 = find(parent, n1);
        int p2 = find(parent, n2);
        if(p1 == p2){return 0;}
        else if(rank[p1] < rank[p2]){
            parent[n1] = p2;
            rank[p2]+=rank[p1];
        }else{
            parent[n2] = p1;
            rank[p1]+=rank[p2];
        }
        return 1;
    }

    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        int[] rank = new int[n];
        for(int i=0; i<n; i++){
            rank[i] = 1;
        }
        for(int i=0; i<edges.length; i++){
            n -= union(parents, rank, edges[i][0], edges[i][1]);
        }
        Arrays.stream(parents).forEach(i -> System.out.print(i+" "));
        System.out.println();
        Arrays.stream(rank).forEach(i -> System.out.print(i+" "));
        return n;
    }

    public static void main(String[] args) {
        int[][] edges = {{5,6},{0,2},{1,7},{5,9},{1,8},{3,4},{0,6},{0,7},{0,3},{8,9}};
        Arrays.stream(edges).forEach(i -> {
            for(int it: i){
                System.out.print(it+" ");
            }
            System.out.println();
        });
        UnionFind un = new UnionFind();
        int result = un.countComponents(10, edges);
        System.out.println(result);
    }

}
