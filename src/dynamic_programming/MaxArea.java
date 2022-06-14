package dynamic_programming;

public class MaxArea {

    public int doDfs(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1){
            return 0;
        }if(grid[row][col] == 0){
            return 0;
        }
        grid[row][col] = 0;
        int t = 1+doDfs(grid, row + 1, col)+doDfs(grid, row, col + 1)+doDfs(grid, row - 1, col)+doDfs(grid, row, col - 1);
        return t;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int res = Integer.MIN_VALUE;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Integer.max(res, doDfs(grid, i, j));
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        MaxArea ar = new MaxArea();
//        ar.maxAreaOfIsland();
    }

}
