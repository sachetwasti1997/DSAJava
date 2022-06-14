package arrays;

public class ContainerMostWater {

    public int maxArea(int[] height) {
        int res = 0;
        // for(int i=0; i<height.length; i++){
        //     for(int j=i+1; j<height.length; j++){
        //         int length = Integer.min(height[i], height[j]);
        //         int width = j - i;
        //         res = Integer.max(res, length * width);
        //     }
        // }
        // return res;
        int start = 0, end = height.length-1;
        while(start < end){
            int length = Integer.min(height[start], height[end]);
            int width = end - start;
            res = Integer.max(res, length * width);
            if(height[start] < height[end]) start++;
            else if(height[start] > height[end]) end --;
            else{
                start++;
            }
        }
        return res;
    }

}
