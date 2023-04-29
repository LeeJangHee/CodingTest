package kr.baekjoon

import java.util.*

class Solution_2660 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private val relationship: Array<ArrayList<Int>>

    init {
        // N: 회원 수
        val N = br.readLine().toInt()
        relationship = Array(N + 1) { arrayListOf() }

        while (true) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            if (a == -1 && b == -1) break

            relationship[a].add(b)
            relationship[b].add(a)
        }

        val ceo = IntArray(N + 1)
        for (i in 1..N) {
            ceo[i] = bfs(i, BooleanArray(N + 1))
        }
        val minValue = ceo.filter { it != 0 }.minOf { it }
        val chairman = ceo.minOfIndices(minValue)
        bw.appendLine("$minValue ${chairman.size}")
            .appendLine(chairman.joinToString(separator = " "))

        br.close()
        bw.flush()
    }

    private fun IntArray.minOfIndices(minValue: Int): List<Int> {
        val list = mutableListOf<Int>()
        forEachIndexed { index, i ->
            if (i == minValue) {
                list.add(index)
            }
        }
        return list.sorted()
    }

    private fun bfs(start: Int, visited: BooleanArray): Int {
        val distance = IntArray(relationship.size)
        val q = LinkedList<Pair<Int, Int>>()
        q.offer(start to 0)
        visited[start] = true
        while (q.isNotEmpty()) {
            val (x, depth) = q.poll()
            for (i in relationship[x].indices) {
                val nx = relationship[x][i]
                if (!visited[nx]) {
                    visited[nx] = true
                    q.offer(nx to depth + 1)
                    distance[nx] = depth + 1
                }
            }
        }
        return distance.maxOf { it }
    }
}

private fun main() {
    Solution_2660()
}