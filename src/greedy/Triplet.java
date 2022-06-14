package greedy;
import java.util.*;
public class Triplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int count = 0;
        var set = new HashSet<Integer>();
        for(int i=0;i <triplets.length; i++){
            if(triplets[i][0] > target[0]
                    || triplets[i][1] > target[1]
                    || triplets[i][2] > target[2]){
                continue;
            }
            for(int j=0; j<3; j++){
                if(target[j] == triplets[i][j]){
                    set.add(target[j]);
                }
            }
        }
        return set.size() == 3;
    }

    public static void main(String[] args) {
        int[][] temp = {{2,5,3},{2,3,4},{1,2,5},{5,2,3}};
        int[] target = {5, 5, 5};
        Triplet t = new Triplet();
        t.mergeTriplets(temp, target);
    }
}
