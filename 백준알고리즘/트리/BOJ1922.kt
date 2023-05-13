package baekjoon

import java.util.*

object BOJ1922 {
    private val bw = System.out.bufferedWriter()

    data class Node(
        val idx: Int,
        val cost: Int
    ): Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.cost - other.cost
        }
    }
    fun solve(n: Int, m: Int, arr: Array<ArrayList<Node>>) {
        val visited = BooleanArray(n + 1)
        var ans = 0

        fun prim() {
            val pq = PriorityQueue<Node>()
            pq.offer(Node(1, 0))

            while (pq.isNotEmpty()) {
                val (now, cost) = pq.poll()
                if (visited[now]) continue

                ans += cost
                visited[now] = true

                for (node in arr[now]) {
                    if (!visited[node.idx]) {
                        pq.offer(node)
                    }
                }

            }
        }

        prim()
        bw.appendLine("$ans")

        bw.flush()
    }
}

private fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val M = br.readLine().toInt()
    val arr = Array(N + 1) { arrayListOf<BOJ1922.Node>() }
    for (i in 1..M) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        arr[a].add(BOJ1922.Node(b, c))
        arr[b].add(BOJ1922.Node(a, c))
    }
    BOJ1922.solve(N, M, arr)

}