package baekjoon

import java.util.*

object BOJ1197 {
    private val bw = System.out.bufferedWriter()

    data class Node(
        val idx: Int,
        val cost: Int
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.cost - other.cost
        }

    }

    private lateinit var visited: BooleanArray
    fun solve(v: Int, e: Int, arr: Array<ArrayList<Node>>) {
        visited = BooleanArray(v + 1)

        fun prim() {
            var total = 0L
            val pq = PriorityQueue<Node>()
            pq.offer(Node(1, 0))
            while(pq.isNotEmpty()) {
                val (now, cost) = pq.poll()
                if (visited[now]) continue

                total += cost

                visited[now] = true
                for (node in arr[now]) {
                    if (!visited[node.idx]) {
                        pq.offer(node)
                    }
                }
            }
            bw.appendLine("$total")
        }

        prim()

        bw.flush()
    }

}


private fun main() {
    val br = System.`in`.bufferedReader()
    val (V, E) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(V + 1) { arrayListOf<BOJ1197.Node>() }
    for (i in 1..E) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        arr[a].add(BOJ1197.Node(b, c))
        arr[b].add(BOJ1197.Node(a, c))
    }
    BOJ1197.solve(V, E, arr)
}