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
   fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        var matrix = Array<IntArray>(m) { IntArray(n) { -1 } }
        matrix[0][0] = head!!.`val`
        var node = head.next
        var curr = MPoint(0, 0, m, n)
        var dirs = listOf({curr.mRight()}, {curr.mDown()},{curr.mLeft()},{curr.mUp()})
        var dir = 0
        var visited = hashSetOf(0 to 0)
        while (node != null) {
            dir %= 4
            if (dirs[dir]() == null) dirs[(++dir)%4]()
            if (curr.row to curr.col in visited) {
                dirs[(dir + 2) % 4]()
                dirs[(++dir)%4]()
            }
            visited.add(curr.row to curr.col)
            matrix[curr.row][curr.col] = node.`val`
            node = node.next
        }
        return matrix
    }
    class MPoint(var row: Int, var col: Int, var gridRows: Int, var gridCols: Int) {
        fun mRight(x: Int = 1): MPoint? {
            if (col + x >= gridCols) return null
            else { col += x; return this }
        }
        fun mLeft(x: Int = 1): MPoint? {
            if (col - x < 0) return null
            else { col -= x; return this }
        }
        fun mUp(x: Int = 1): MPoint? {
            if (row - x < 0) return null
            else { row -= x; return this }
        }
        fun mDown(x: Int = 1): MPoint? {
            if (row + x >= gridRows) return null
            else { row += x; return this }
        }
        fun move(x: IntArray): MPoint? {
            if (row + x[0] in 0 until gridRows && col + x[1] in 0 until gridCols) {
                row += x[0]
                col += x[1]
                return this
            } else return null
        }
        
        override fun equals(other: Any?): Boolean {
            if (other == null) return false
            if (other !is MPoint) return false
            return other.col == col && other.row == row
        }
        
        override fun hashCode(): Int {
            var result = row
            result = 31 * result + col
            return result
        }
    }
}