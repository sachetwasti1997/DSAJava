package Heap;

import java.util.*;

class TaskSchedularImpl {

    static class TaskSchedular{
        char ch;
        int frequency;
        int time;
        TaskSchedular(char ch, int frequency, int time){
            this.ch = ch;
            this.frequency = frequency;
            this.time = time;
        }
    }
    public static int leastInterval(char[] tasks, int n) {
        var taskWithFreq = new PriorityQueue<TaskSchedular>((t1, t2) -> {
            return t2.frequency - t1.frequency;
        });
        var finishedTaskQue = new LinkedList<TaskSchedular>();
        var freq = new HashMap<Character, Integer>();
        for(int i=0; i<tasks.length; i++){
            if(!freq.containsKey(tasks[i]))freq.put(tasks[i], 1);
            else freq.put(tasks[i], freq.get(tasks[i]) + 1);
        }
        for(Map.Entry<Character, Integer>freqMap: freq.entrySet()){
            taskWithFreq.add(new TaskSchedular(freqMap.getKey(), freqMap.getValue(), 1));
        }
        int timeCount = 0;
        while(!taskWithFreq.isEmpty()||!finishedTaskQue.isEmpty()){
            timeCount++;
            if(!taskWithFreq.isEmpty()){
                var tempTask = taskWithFreq.remove();
                tempTask.time = timeCount + n;
                tempTask.frequency --;
                if(tempTask.frequency >= 1)finishedTaskQue.add(tempTask);
            }if(!finishedTaskQue.isEmpty() && finishedTaskQue.peek().time == timeCount){
                var task = finishedTaskQue.remove();
                if(task.frequency >= 1)taskWithFreq.add(task);
            }
        }
        return timeCount;
    }

    public static void main(String[] args){
        char[] task = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(leastInterval(task, 2));
    }

}
