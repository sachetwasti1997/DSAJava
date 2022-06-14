package dynamic_programming

import java.util.Arrays

class BuySellStockWithCooldown {

    fun maxProfit(prices: IntArray): Int {
        val arr = Array(prices.size){IntArray(2){-1} }
        fun dfsMaxProfit(index: Int, buying: Int): Int{
            if(index >= prices.size){
                return 0;
            }
            if(arr[index][buying] != -1){
                return arr[index][buying]
            }
            var cooldown = dfsMaxProfit(index+1, buying)
            if(buying == 0){
                var buy: Int = dfsMaxProfit(index+1, 1) - prices[index]
                arr[index][buying] = maxOf(buy, cooldown)
            }else{
                var sell: Int = dfsMaxProfit(index+2, 0) + prices[index]
                arr[index][buying] = maxOf(sell, cooldown)
            }
            return arr[index][buying]
        }
        Arrays.stream(arr).forEach {  println(Arrays.toString(it))}
        var t = dfsMaxProfit(0, 0)
        Arrays.stream(arr).forEach {  println(Arrays.toString(it))}
        return t
    }

}

fun main() {
    var b: BuySellStockWithCooldown = BuySellStockWithCooldown()
    var t = b.maxProfit(intArrayOf(1, 2, 3, 0, 2))
    println(t)
}