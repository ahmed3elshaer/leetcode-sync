class Solution {

    fun getLucky(s: String, k: Int): Int {
        var number = convert(s)

        var k = k
        while (k > 1) {
            number = cache[sum(number)]
            k--
        }
        return sum(number)
    }

    private inline fun convert(s: String): String {
        val builder = StringBuilder()
        for (c in s) {
            builder.append(cache[c - '`'])
        }
        return builder.toString()
    }

    private fun sum(string: String): Int {
        var sum = 0
        for (c in string) {
            sum += c - '0'
        }
        return sum
    }

    companion object {
        val cache = Array<String>(1001) { it.toString() }
    }
}