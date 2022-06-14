package binary_search;

public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int lMin = 0, rMax = matrix[0].length-1;
        for(int i=0; i<matrix.length; i++){
            int l = 0, r = rMax;
            while(l <= r){
                int mid = (l+r)/2;
                if(matrix[i][mid] == target){
                    return true;
                }
                if(matrix[i][mid] > target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[]args){
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix, 61));
    }

}
