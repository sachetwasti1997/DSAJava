package greedy

class Jumps {
    fun jump(nums: IntArray): Int {
        var l = 0
        var r = 0
        var res = 0
        while(r < nums.size - 1){
            var farthest = 0
            for(i in l..r step 1){
                farthest = Integer.max(farthest, i + nums[i]);
            }
            l = r+1;
            r = farthest;
            res += 1
        }
        return res;
    }

}