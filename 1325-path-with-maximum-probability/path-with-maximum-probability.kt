class Solution {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
        val nodes = buildGraph(n, edges, succProb)
        return bfs(nodes[start], nodes[end])
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>, succProb: DoubleArray): Array<GraphNode1514> {
        val nodes = Array(n) { GraphNode1514() }
        for (i in 0 until edges.size) {
            val (from, to) = edges[i]
            nodes[from].linkTo(nodes[to], succProb[i])
        }
        return nodes
    }

    private fun bfs(start: GraphNode1514, target: GraphNode1514): Double {
        start.maxSuccess = 1.0
        pq.offer(start)

        while (pq.isNotEmpty()) {
            with(pq.poll()) {
                if (this === target) return@with
                for (i in 0 until links.size) {
                    val link = links[i]
                    val success = maxSuccess * link.success
                    if (success > link.node.maxSuccess) {
                        link.node.maxSuccess = success
                        pq.offer(link.node)
                    }
                }
            }
        }

        return target.maxSuccess
    }

    class GraphNode1514 {

        var maxSuccess: Double = 0.0
        val links = ArrayList<Link1514>()

        fun linkTo(node: GraphNode1514, success: Double) {
            links.add(Link1514(node, success))
            node.links.add(Link1514(this, success))
        }
    }

    class Link1514(val node: GraphNode1514, val success: Double)

    companion object {
        val pq = PriorityQueue(Comparator<GraphNode1514> { a, b -> b.maxSuccess.compareTo(a.maxSuccess) })
    }
}