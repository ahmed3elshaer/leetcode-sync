/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val size = getSize(head)
        val count = size / k
        val greater = size % k

        val result = Array<ListNode?>(k) { null }
        var node = head
        for (i in 0 until k) {
            result[i] = node
            node = split(node, if (i < greater) count + 1 else count)
        }
        return result
    }

    private fun split(node: ListNode?, count: Int): ListNode? {
        var count = count
        var node = node
        while (--count > 0) {
            node = node?.next
        }
        val next = node?.next
        node?.next = null
        return next
    }

    private fun getSize(head: ListNode?): Int {
        var count = 0
        var node = head
        while (node != null) {
            count++
            node = node.next
        }
        return count
    }
}