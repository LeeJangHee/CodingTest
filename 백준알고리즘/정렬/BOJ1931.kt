package baekjoon

import java.util.*

object BOJ1931 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private data class Node(
        val start: Int,
        val end: Int
    ) : Comparable<Node> {
        override fun compareTo(o: Node): Int {
            return when {
                this.end == o.end -> {
                    this.start - o.start
                }
                else -> this.end - o.end
            }
        }
    }

    fun solve() {
        val N = br.readLine().toInt()
        val pq = PriorityQueue<Node>()

        for (i in 1..N) {
            val (s, e) = br.readLine()
                .split(" ")
                .map { it.toInt() }

            pq.offer(Node(s, e))
        }

        var prev = pq.poll()
        var cnt = 1

        while (pq.isNotEmpty()) {
            val now = pq.poll()
            if (now.start >= prev.end) {
                cnt += 1
                prev = now
            }
        }

        bw.appendLine("$cnt")

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ1931.solve()
}