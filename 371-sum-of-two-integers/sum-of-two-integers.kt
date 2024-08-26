class Solution {
    fun getSum(a: Int, b: Int): Int {
        var carry = 0
        var count = 0

        for (i in 0..31){
            val mask = 1 shl i
            val bitA = a and mask
            val bitB = b and mask

            count = count xor bitA xor bitB xor carry
            carry = (bitA and bitB) or (bitA and carry) or (bitB and carry)
            carry = carry shl 1
        }
        return count
    }
}