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
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var current = head
        var next = current?.next
        while(current?.next != null){
            next = current?.next // 6
            val d = greatestCommonDivisor(current?.`val`!!, next?.`val`!!) // 
            val newNode = ListNode(d) // 6 -> 6
            newNode.next = next
            current?.next = newNode // 18 -> 6 -> 6
            current = newNode.next
        }
        return head
    }

    fun greatestCommonDivisor(first : Int, second: Int) :Int{
        if(first % second == 0){
            return second
        }else{
           return greatestCommonDivisor(second,first % second )
        }
    }
}