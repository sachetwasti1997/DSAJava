package graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NumberIslands {

    public void dfs(char[][] grid, int row, int col, boolean[][] isPositionVisited){
        if(row >= grid.length-1||col>=grid[0].length-1||row < 0||col < 0){
            return;
        }
        if(grid[row][col]=='0'){
            return;
        }
        isPositionVisited[row][col] = true;
        if(row < grid.length-1 && !isPositionVisited[row+1][col])dfs(grid, row+1, col, isPositionVisited);
        if(col < grid[0].length-1 && !isPositionVisited[row][col+1])dfs(grid, row, col+1, isPositionVisited);
        if(row > 0 && !isPositionVisited[row-1][col])dfs(grid, row-1, col, isPositionVisited);
        if(col > 0 && !isPositionVisited[row][col-1])dfs(grid, row, col-1, isPositionVisited);
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid[0] == null)return 0;
        boolean[][] isPositionVisited = new boolean[grid.length][grid[0].length];
            int islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !isPositionVisited[i][j]){
                    islands++;
                    dfs(grid, i, j, isPositionVisited);
                }
            }
        }
        return islands;
    }

    public static void main(String[]args){
        char[][] t = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','1','0'},
                {'0','0','0','0','1'}
        };
        NumberIslands num = new NumberIslands();
        System.out.println(num.numIslands(t));
    }

}
