class Solution {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val prefixXor = prefixTable(arr)

        return IntArray(queries.size) {
            prefixXor[queries[it][0]] xor prefixXor[queries[it][1] + 1]
        }
    }

    fun prefixTable(arr: IntArray): IntArray {
        val result = IntArray(arr.size + 1)
        for (i in 0 until arr.size) {
            result[i + 1] = result[i] xor arr[i]
        }
        return result
    }
}