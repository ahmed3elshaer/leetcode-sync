class Solution {
    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        // mean = (x + m )/count
        // x = (mean * count) - sum
        val target = (mean * (n+rolls.size)) - rolls.sum()
        if(target > 6 * n || target < n)
            return intArrayOf()
        val base = (target / n).toInt()
        var extra = target % n
        val result = IntArray(n) { base }
        
        for (i in 0 until extra) {
            result[i]++
        }
        
        return result

    }
}