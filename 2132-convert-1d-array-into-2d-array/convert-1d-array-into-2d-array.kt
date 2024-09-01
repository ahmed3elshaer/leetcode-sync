class Solution {
      fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        return if (original.size != n * m) emptyArray()
        else Array(m) { row ->
                IntArray(n) { col ->
                    original[row * n + col]
                }
            }
    }
}