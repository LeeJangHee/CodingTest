package baekjoon

import java.util.*
import kotlin.math.min

class BOJ1504 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private data class Node(
        val idx: Int,
        val cost: Int
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.cost - other.cost
        }
    }

    private val INF by lazy { 1e9.toInt() }

    init {
        val (N, E) = br.readLine().split(" ").map { it.toInt() }
        val arr = Array(N + 1) { arrayListOf<Node>() }
        for (i in 1..E) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            arr[a].add(Node(b, c))
            arr[b].add(Node(a, c))
        }

        val (v1, v2) = br.readLine().split(" ").map { it.toInt() }

        solve(N, arr, v1, v2)

        br.close()
        bw.flush()
    }

    private fun solve(n: Int, arr: Array<ArrayList<Node>>, v1: Int, v2: Int) {
        var d = IntArray(n + 1) { INF }

        fun dijkstra(st: Int) {
            d = IntArray(n + 1) { INF }

            val pq = PriorityQueue<Node>()
            pq.offer(Node(st, 0))
            d[st] = 0

            while (pq.isNotEmpty()) {
                val (now, cost) = pq.poll()
                if (d[now] < cost) continue

                for (next in arr[now]) {
                    val nCost = d[now] + next.cost
                    if (nCost < d[next.idx]) {
                        d[next.idx] = nCost
                        pq.offer(Node(next.idx, nCost))
                    }
                }
            }
        }

        dijkstra(1)
        val stToV1 = d[v1]
        val stToV2 = d[v2]

        dijkstra(v1)
        val v1ToV2 = d[v2]
        val v1ToN = d[n]

        dijkstra(v2)
        val v2ToN = d[n]
        val v2ToV1 = d[v1]

        // 1 -> v1 -> v2 -> n
        val ans1 = if (stToV1 == INF || v1ToV2 == INF || v2ToN == INF) -1
                            else stToV1 + v1ToV2 + v2ToN

        // 1 -> v2 -> v1 -> n
        val ans2 = if (stToV2 == INF || v2ToV1 == INF || v1ToN == INF) -1
                            else stToV2 + v2ToV1 + v1ToN

        if (ans1 == -1 && ans2 == -1) bw.appendLine("-1")
        else bw.appendLine("${min(ans1, ans2)}")
    }
}

private fun main() {
    BOJ1504()
}