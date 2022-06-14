package graph;

import java.util.*;

public class RottonOranges {

    static class Position{
        int i;
        int j;
        int time;
        public Position(int i, int j, int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    // public void doDfs(int[][] grid, int i, int j, int sec){
    //     if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] != 3 && grid[i][j] != 0){
    //             time.sec = sec;
    //             sec++;
    //         grid[i][j] = 3;
    //         doDfs(grid, i + 1, j, sec);
    //         doDfs(grid, i, j + 1, sec);
    //         doDfs(grid, i - 1, j, sec);
    //         doDfs(grid, i, j - 1, sec);
    //     }
    // }

    public int orangesRotting(int[][] grid) {
        var queue = new LinkedList<Position>();
        int oneCount = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Position(i, j, 0));
                }
                if(grid[i][j] == 1){
                    oneCount ++;
                }
            }
        }
        if(oneCount == 0){
            return 0;
        }
        int resTime = 0;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            var temp = queue.remove();
            int row = temp.i, col = temp.j, time = temp.time;
            for(int i=0; i<dir.length; i++){
                int r = dir[i][0] + row, c = dir[i][1] + col;
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1){
                    grid[r][c] = 2;
                    queue.add(new Position(r, c, time+1));
                    oneCount--;
                }
            }
            resTime = Integer.max(resTime, time);
        }
        if(oneCount > 0) return -1;
        return resTime;
    }

}
