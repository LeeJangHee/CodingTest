package kr.baekjoon

import java.util.*

object BOJ4485 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var count = 0

    private data class Node(
        val x: Int,
        val y: Int,
        val cost: Int
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.cost - other.cost
        }
    }

    fun solve() {

        while (true) {
            val n = br.readLine().toInt()
            if (n == 0) break

            count += 1
            val arr = Array(n) { IntArray(n) }
            for (i in 0 until n) {
                br.readLine().split(Regex("\\s"))
                    .forEachIndexed { j, s ->
                        val num = s.toInt()
                        arr[i][j] = num
                    }
            }

            dijkstra(n, arr)

        }

        br.close()
        bw.flush()
    }

    private val dx = intArrayOf(0, 1, 0, -1)
    private val dy = intArrayOf(1, 0, -1, 0)
    private fun dijkstra(n: Int, arr: Array<IntArray>) {
        val pq = PriorityQueue<Node>()
        val visited = Array(n) { BooleanArray(n) }
        val distance = Array(n) { IntArray(n) { 10e7.toInt() } }
        pq.offer(Node(0, 0, arr[0][0]))
        distance[0][0] = arr[0][0]

        while (pq.isNotEmpty()) {
            val (x, y, now) = pq.poll()

            if (visited[x][y]) continue
            visited[x][y] = true

            for (k in 0..3) {
                val nx = x + dx[k]
                val ny = y + dy[k]

                if (nx !in 0 until n || ny !in 0 until n) continue

                if (!visited[nx][ny]) {
                    val next = distance[x][y] + arr[nx][ny]
                    if (next < distance[nx][ny]) {
                        distance[nx][ny] = next
                        pq.offer(Node(nx, ny, next))
                    }
                }
            }
        }

        bw.appendLine("Problem $count: ${distance.last().last()}")

    }
}

private fun main() {
    BOJ4485.solve()
}