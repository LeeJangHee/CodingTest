package baekjoon

import java.util.*

object BOJ2623 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val arr = Array(N + 1) { arrayListOf<Int>() }
        val indeg = IntArray(N + 1)
        for (i in 1..M) {
            val a = br.readLine()
                .split(" ")
                .filterIndexed { idx, _ -> idx != 0 }
                .map { it.toInt() }

            for (j in 1 until a.size) {
                val idx = a[j-1]
                val deg = a[j]
                arr[idx].add(deg)
                indeg[deg] += 1
            }
        }


        val ans = arrayListOf<Int>()
        fun topologySort(): Boolean {
            val q = LinkedList<Int>()
            for (i in 1 until indeg.size) {
                if (indeg[i] == 0) {
                    q.offer(i)
                }
            }

            while (q.isNotEmpty()) {
                val now = q.poll()
                ans.add(now)
                for (nx in arr[now]) {
                    indeg[nx] -= 1
                    if (indeg[nx] == 0) {
                        q.offer(nx)
                    }
                }
            }

            return indeg.sum() == 0
        }

        if (topologySort()) {
            bw.appendLine(ans.joinToString(separator = "\n"))
        } else {
            bw.appendLine("0")
        }


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ2623.solve()
}