package binary_search;

public class KoKoBananas {
//    public static int minEatingSpeed(int[] piles, int h) {
//        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
//        for(int i=0; i<piles.length; i++){
//            minValue = Integer.min(minValue, piles[i]);
//            maxValue = Integer.max(maxValue, piles[i]);
//        }
////        int [] kValues = new int[maxValue];
//        int j = 0;
////        for(int i=1; i<=maxValue; i++){
////            kValues[j++] = i;
////        }
//        int totalTime = Integer.MAX_VALUE, hour = 0, toth = h;
//        for(int i=1; i<=maxValue; i++){
//            toth = h;
//            for(j = 0; j<piles.length; j++){
//                hour = piles[j] / i;
//                if(piles[j] % i != 0){
//                    hour += 1;
//                }
//                toth -= hour;
//            }
//            if(toth >= 0){
//                totalTime = Integer.min(i, totalTime);
//            }
//        }
        public static int minEatingSpeed(int[] piles, int h) {
            int r = Integer.MIN_VALUE;
            for(int i=0; i<piles.length; i++){
                r = Integer.max(r, piles[i]);
            }
            int l = 1;
            int j = 0;
            int totalTime = Integer.MAX_VALUE, hour = 0, toth = h;
            while(l <= r){
                int mid = (l+r)/2;
                toth = h;
                for(j = 0; j<piles.length; j++){
                    hour = piles[j] / mid;
                    if(piles[j] % mid != 0){
                        hour += 1;
                    }
                    toth -= hour;
                }
                if(toth >= 0){
                    totalTime = Integer.min(mid, totalTime);
                }
                if(toth == 0){
                    r = mid - 1;
                }
                else if(toth < 0){
                    l = mid+1;
                }else{
                    r = mid - 1;
                }
            }

            return totalTime;
        }
//        return totalTime;
//    }
    public static void main(String[]args){
        int[] p ={312884470};
        int h = 312884469;
        System.out.println(minEatingSpeed(p, h));
    }
}
