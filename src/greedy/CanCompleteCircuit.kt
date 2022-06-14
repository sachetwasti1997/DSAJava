package greedy

class CanCompleteCircuit {

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

        var res = 0
        var total = 0
        for(i in 0..gas.size-1 step 1){
            total += (gas[i] - cost[i])
            if (total < 0){
                total = 0
                res = i + 1
            }
        }
        return res
    }
    
}

fun main(args: Array<String>){
    var compl = CanCompleteCircuit()
    var arr = IntArray(3)
    var vaArr = IntArray(3)
    arr[0] = 2; arr[1] = 3; arr[2] = 4;
    vaArr[0] = 3; vaArr[1] = 4; vaArr[2] = 3;
    compl.canCompleteCircuit(arr, vaArr)
}