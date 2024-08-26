/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    fun postorder(root: Node?): List<Int> {
        val stack = Stack<Node>()
        val res = mutableListOf<Int>()
        if(root!=null){
            stack.push(root)
        }
        
        while(stack.isNotEmpty()){
            val node = stack.pop()
            node.children.forEach{ stack.push(it) }
            res.add(0,node.`val`)
        }
        return res
    }
}