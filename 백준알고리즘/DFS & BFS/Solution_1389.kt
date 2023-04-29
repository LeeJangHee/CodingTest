package kr.baekjoon

import java.util.*

class Solution_1389 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private val relationship: Array<ArrayList<Int>>
    private val kevinBacon: IntArray

    init {
        // N: 유저 수
        // M: 친구 관계 수
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        relationship = Array(N + 1) { arrayListOf() }
        kevinBacon = IntArray(N + 1)
        for (i in 1..M) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            relationship[a].add(b)
            relationship[b].add(a)
        }

        for (i in 1..kevinBacon.lastIndex) {
            kevinBacon[i] = bfs(i, BooleanArray(N + 1))
        }

        bw.appendLine("${kevinBacon.minOfIndex()}")

        br.close()
        bw.flush()
    }

    private fun IntArray.minOfIndex(): Int {
        val minValue = this.filter { it != 0 }.minOf { it }
        this.forEachIndexed { index, i ->
            if (i == minValue) {
                return index
            }
        }
        return 0
    }

    private fun bfs(start: Int, visited: BooleanArray): Int {
        val distance = IntArray(kevinBacon.size)
        val q = LinkedList<Pair<Int, Int>>()
        q.offer(start to 0)
        visited[start] = true
        while (q.isNotEmpty()) {
            val (x, depth) = q.poll()
            for (i in 0 until relationship[x].size) {
                val nx = relationship[x][i]
                if (!visited[nx]) {
                    q.offer(nx to depth + 1)
                    visited[nx] = true
                    distance[nx] = depth + 1
                }
            }
        }
        return distance.sum()
    }
}

private fun main() {
    Solution_1389()
}