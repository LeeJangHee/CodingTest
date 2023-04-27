package kr.baekjoon

import java.util.*

class Solution_6118 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var barn: Array<ArrayList<Int>>
    private var visited: BooleanArray
    private var distance: IntArray

    init {
        // N: 헛간의 개수
        // M: 길의 개수
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        barn = Array(N + 1) { arrayListOf() }
        visited = BooleanArray(N + 1)
        distance = IntArray(N + 1)
        for (i in 1..M) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            barn[a].add(b)
            barn[b].add(a)
        }

        bfs()

        val depth = distance.maxOf { it }
        val answer = distance.findByDepth(depth)

        bw.appendLine("${answer.first()} $depth ${answer.size}")

        br.close()
        bw.flush()
    }

    private fun IntArray.findByDepth(depth: Int): List<Int> {
        val a = mutableListOf<Int>()
        forEachIndexed { index, i ->
            if (i == depth) {
                a.add(index)
            }
        }
        return a.toList()
    }

    private fun bfs() {
        val q = LinkedList<Pair<Int, Int>>()
        q.offer(1 to 0)
        visited[1] = true
        while (q.isNotEmpty()) {
            val (x, depth) = q.poll()
            for (i in 0 until barn[x].size) {
                val dx = barn[x][i]
                if (!visited[dx]) {
                    visited[dx] = true
                    q.offer(dx to depth + 1)
                    // 최초 방문한 거리가 최소 거리
                    distance[dx] = depth + 1
                }
            }
        }
    }
}

private fun main() {
    Solution_6118()
}