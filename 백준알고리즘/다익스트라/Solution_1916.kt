package baekjoon.barkingdog

import java.util.*

class Solution_1916 {
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

    private val arr: Array<ArrayList<Node>>
    private val dist: IntArray

    init {
        val N = br.readLine().toInt()
        val M = br.readLine().toInt()

        arr = Array(N + 1) { arrayListOf() }
        dist = IntArray(N + 1) { Int.MAX_VALUE }

        for (i in 1..M) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            arr[a].add(Node(b, c))
        }

        val (st, en) = br.readLine().split(" ").map { it.toInt() }
        dijkstra(st)

        bw.appendLine("${dist[en]}")
        br.close()
        bw.flush()
    }

    /*
    1 -> 5 이동 경로
    1 -> 3 -> 5
     */
    private fun dijkstra(st: Int) {
        val pq = PriorityQueue<Node>()
        pq.offer(Node(st, 0))
        dist[st] = 0
        while (pq.isNotEmpty()) {
            val (now, cost) = pq.poll()
            // 현재 노드가 처리된 적 있는지 확인
            if (dist[now] < cost) continue

            // 인접 노드 확인
            for (node in arr[now]) {
                val nCost = dist[now] + node.cost
                // 다음 노드의 index 테이블의 거리보다 작으면 다시 셋
                if (nCost < dist[node.idx]) {
                    dist[node.idx] = nCost
                    pq.offer(Node(node.idx, nCost))
                }
            }
        }
    }
}

private fun main() {
    Solution_1916()
}