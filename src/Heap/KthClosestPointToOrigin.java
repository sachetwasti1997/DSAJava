package Heap;

import java.util.*;

public class KthClosestPointToOrigin {

    static class InitPoints{
        int x;
        int y;
        int distance;

        public InitPoints(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<InitPoints> pointsPQ = new PriorityQueue<>(new Comparator<InitPoints>(){
            @Override
            public int compare(InitPoints o1, InitPoints o2) {
                return (int)o1.distance - (int)o2.distance;
            }
        });

        for(int i=0; i< points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int distance = (int)Math.pow(x, 2) + (int)Math.pow(y, 2);
            InitPoints points1 = new InitPoints(x, y, distance);
            pointsPQ.add(points1);
        }

        int i = 0;
        int[][] res = new int[k][k];
        while(i < k){
            var temp = pointsPQ.remove();
            res[i] = new int[]{temp.x, temp.y};
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        KthClosestPointToOrigin pointToOrigin = new KthClosestPointToOrigin();
        var temp = pointToOrigin.kClosest(points, 2);
        Arrays.stream(temp).forEach(t -> System.out.println(Arrays.toString(t)));
    }

}
