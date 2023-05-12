package baekjoon.barkingdog

import java.util.*

/**
 * MST 문제, 최소 신장 트리
 * 크루스칼, 프림 알고리즘
 */
class Solution_1647 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private val arr: Array<ArrayList<Node>>
    private val visited: BooleanArray

    data class Node(
        val idx: Int,
        val cost: Int
    ): Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.cost - other.cost
        }
    }

    init {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        arr = Array(N + 1) { arrayListOf() }
        visited = BooleanArray(N+1)

        for (i in 1..M) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            arr[a].add(Node(b, c))
            arr[b].add(Node(a, c))
        }
        bw.appendLine("${prim()}")

        br.close()
        bw.flush()
    }


    private fun prim(): Int {
        // 가장 큰 값
        var max = 0
        // 현재 비용 총 합
        var mCost = 0
        val pq = PriorityQueue<Node>()
        pq.offer(Node(1, 0))
        while (pq.isNotEmpty()) {
            val (now, cost) = pq.poll()

            if (!visited[now]) {
                visited[now] = true
                max = maxOf(cost, max)
                mCost += cost

                for (i in arr[now].indices) {
                    val next = arr[now][i]
                    if (!visited[next.idx]) {
                        pq.offer(next)
                    }
                }
            }
        }

        return mCost - max
    }


}

private fun main() {
    Solution_1647()
}