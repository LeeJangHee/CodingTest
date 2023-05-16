package baekjoon

import java.util.*

class BOJ1261 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private val INF = 1e9.toInt()
    private val dx = intArrayOf(1, -1, 0, 0)
    private val dy = intArrayOf(0, 0, 1, -1)

    init {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val arr = Array(M) { IntArray(N) }
        for (i in 0 until M) {
            br.readLine().forEachIndexed { j, c ->
                arr[i][j] = c.digitToInt()
            }
        }

        solve(N, M, arr)
        br.close()
        bw.flush()
    }

    private fun solve(n: Int, m: Int, arr: Array<IntArray>) {

        fun dijkstra() {
            val q = PriorityQueue<Node>()
            q.offer(Node(0, 0, 0))
            val d = Array(m) { IntArray(n) { INF } }
            d[0][0] = 0
            while (q.isNotEmpty()) {
                val (x, y, cost) = q.poll()

                for (i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if (nx !in 0 until m || ny !in 0 until n)
                        continue

                    val nCost = d[x][y] + arr[nx][ny]
                    if (nCost < d[nx][ny]) {
                        d[nx][ny] = nCost
                        q.offer(Node(nx, ny, nCost))
                    }
                }
            }

            bw.appendLine("${d.last().last()}")
        }

        dijkstra()
    }

    private data class Node(
        val i: Int,
        val j: Int,
        val cost: Int
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.cost - other.cost
        }
    }
}

private fun main() {
    BOJ1261()
}