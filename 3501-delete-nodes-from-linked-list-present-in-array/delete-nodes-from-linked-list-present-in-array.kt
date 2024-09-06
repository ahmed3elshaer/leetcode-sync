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
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
       val numsMap = mutableMapOf<Int,Boolean>() 

       for(num in nums){
            numsMap[num] = true
       }
       var res = head
       var currentNode = head
       var prevNode : ListNode? = null

       while(currentNode != null){
            if(numsMap.containsKey(currentNode.`val`)){
                if(prevNode == null){
                    res = currentNode?.next
                }
                prevNode?.next = currentNode?.next
            }else{
                prevNode = currentNode
            }
            currentNode = currentNode?.next
           
       }

        return res
    }
}