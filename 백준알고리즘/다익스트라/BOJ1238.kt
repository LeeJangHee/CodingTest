package baekjoon

import java.util.*

class BOJ1238 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private data class Node(
        val index: Int,
        val dist: Int
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.dist - other.dist
        }
    }

    private val INF: Int = 1e9.toInt()

    init {
        val (N, M, X) = br.readLine().split(" ").map { it.toInt() }
        val arr = Array(N + 1) { arrayListOf<Node>() }
        for (i in 1..M) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            arr[a].add(Node(b, c))
        }

        solve(N, M, X, arr)

        br.close()
        bw.flush()
    }

    private fun solve(n: Int, m: Int, x: Int, arr: Array<ArrayList<Node>>) {
        var ans = 0
        for (i in 1..n) {
            val dist = dijkstra(arr, i, x, IntArray(n + 1) { INF }) +
                    dijkstra(arr, x, i, IntArray(n + 1) { INF })
            if (ans < dist) {
                ans = dist
            }
        }
        bw.appendLine("$ans")
    }

    private fun dijkstra(
        arr: Array<ArrayList<Node>>,
        st: Int,
        en: Int,
        d: IntArray
    ): Int {
        val pq = PriorityQueue<Node>()
        pq.offer(Node(st, 0))
        d[st] = 0
        while (pq.isNotEmpty()) {
            val (now, cost) = pq.poll()
            // 현재 정점의 거리 크기 비교
            if (d[now] < cost) continue

            for (node in arr[now]) {
                // 다음 값 확인
                val nCost = d[now] + node.dist
                if (nCost < d[node.index]) {
                    d[node.index] = nCost
                    pq.offer(node)
                }
            }
        }
        return d[en]
    }
}

private fun main() {
    BOJ1238()
}