package baekjoon

import java.util.*

object BOJ1516 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val N = br.readLine().toInt()
        val arr = Array(N + 1) { arrayListOf<Int>() }
        val dp = IntArray(N + 1)
        val time = IntArray(N + 1)
        val indeg = IntArray(N + 1)
        for (i in 1..N) {
            val v = br.readLine()
                .split(Regex("\\s"))
                .filterNot { it.toInt() == -1 }
                .map { it.toInt() }


            time[i] = v[0]
            v.subList(1, v.size).forEach {
                arr[it].add(i)
                indeg[i] += 1
            }
        }

        fun topologySort() {
            val q = LinkedList<Int>()
            for (i in 1..N) {
                if (indeg[i] == 0) {
                    q.offer(i)
                    dp[i] = time[i]
                }
            }

            while (q.isNotEmpty()) {
                val now = q.poll()
                for (next in arr[now]) {
                    indeg[next] -= 1
                    dp[next] = maxOf(dp[next], dp[now] + time[next])
                    if (indeg[next] == 0) {
                        q.offer(next)
                    }
                }
            }
        }

        // execute
        topologySort()

        bw.appendLine(dp.drop(1).joinToString("\n"))

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ1516.solve()
}