package stack;

import java.util.*;

public class DailyTemperatures {
    class TempIndx{
        int temp;
        int indx;
        TempIndx(int temp, int indx){
            this.temp = temp;
            this.indx = indx;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        var output = new int[temperatures.length];
        var tempOut = new Stack<TempIndx>();
        for(int i=0; i<temperatures.length; i++){
            if(tempOut.isEmpty() || tempOut.peek().temp > temperatures[i]){
                tempOut.add(new TempIndx(temperatures[i], i));
            }else{
                while(!tempOut.isEmpty() && tempOut.peek().temp < temperatures[i]){
                    var tI = tempOut.pop();
                    output[tI.indx] = i - tI.indx;
                }
                tempOut.add(new TempIndx(temperatures[i], i));
            }
        }
        return output;
    }
}
