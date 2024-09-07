/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
     fun checkForNode(listNode: ListNode?, treeNode: TreeNode?): Boolean {
        if (listNode == null) return true
        if (treeNode == null) return false
        if (listNode.`val` != treeNode.`val`) return false
        return checkForNode(listNode.next, treeNode.left) || checkForNode(listNode.next, treeNode.right)
    }
    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        if(root == null) return false 
        if(checkForNode(head,root)) return true
        return isSubPath(head, root.left) || isSubPath(head, root.right)
    }
}