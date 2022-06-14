package graph;

import java.util.*;

public class IslandNumber {

    static class Position{
        int i;
        int j;
        public Position(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public void doBFS(char[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;

        var que = new LinkedList<Position>();
        que.add(new Position(i, j));
        while(!que.isEmpty()){
            var temp = que.remove();
            grid[temp.i][temp.j] = '2';
            int r = temp.i, c = temp.j;
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int k = 0; k<directions.length; k++){
                int row = r + directions[k][0];
                int col = c + directions[k][1];
                if(row >= 0 && col >= 0 && row < rows && col < cols && grid[row][col] == '1'){
                    que.add(new Position(row, col));
                }
            }
        }
    }

    public void doDfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        if(grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        doDfs(grid, i + 1, j);
        doDfs(grid, i, j + 1);
        doDfs(grid, i - 1, j);
        doDfs(grid, i, j - 1);
    }

    public int numIslands(char[][] grid) {
        int connectedComponents = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    connectedComponents++;
                    doBFS(grid, i, j);
                }
            }
        }
        return connectedComponents;
    }

    public static void main(String[] args){
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        IslandNumber num = new IslandNumber();
        System.out.println(num.numIslands(grid));
    }

}
