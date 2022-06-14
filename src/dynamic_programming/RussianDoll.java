package dynamic_programming;
import java.util.*;
public class RussianDoll {
    class WH{
        int width;
        int height;
        WH(int width, int height){
            this.width = width;
            this.height = height;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        List<WH> list = new ArrayList(envelopes.length);
        for(int i=0; i<envelopes.length; i++){
            list.add(new WH(envelopes[i][0], envelopes[i][1]));
        }
        Collections.sort(list, new Comparator<WH>() {
            @Override
            public int compare(WH o1, WH o2) {
                if(o1.width > o2.width){
                    return 1;
                }
                return -1;
            }
        });
        int[] resList = new int[envelopes.length];
        Arrays.fill(resList, 1);
        int max = 0;
        for(int i=list.size()-1; i>=0; i--){
            for (int j=i+1; j<list.size(); j++){
                if(list.get(i).height < list.get(j).height && list.get(i).width < list.get(j).width){
                    resList[i] = Integer.max(resList[i], 1+resList[j]);
                }
                if (max < resList[i]){
                    max = resList[i];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] en = {{1,1},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}};
        RussianDoll doll = new RussianDoll();
        doll.maxEnvelopes(en);
    }
}
