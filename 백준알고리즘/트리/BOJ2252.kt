package baekjoon

import java.util.*

object BOJ2252 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val arr = Array(N + 1) { arrayListOf<Int>() }
        val indeg = IntArray(N + 1)
        for (i in 1..M) {
            val (x, y) = br.readLine()
                .split(" ")
                .map { it.toInt() }

            arr[x].add(y)
            indeg[y] += 1
        }

        val ans = arrayListOf<Int>()
        fun topologySort() {
            val q = LinkedList<Int>()

            for (i in 1 until indeg.size) {
                if (indeg[i] == 0) {
                    q.offer(i)
                }
            }

            while (q.isNotEmpty()) {
                val x = q.poll()
                ans.add(x)
                for (nxt in arr[x]) {
                    indeg[nxt] -= 1
                    if (indeg[nxt] == 0) {
                        q.offer(nxt)
                    }
                }
            }
        }

        topologySort()

        bw.appendLine(ans.joinToString(separator = " "))

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ2252.solve()
}