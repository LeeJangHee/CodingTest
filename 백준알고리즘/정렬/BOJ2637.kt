package baekjoon

import java.util.*

object BOJ2637 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var N = 0
    private lateinit var dp: Array<IntArray>

    fun solve() {
        N = br.readLine().toInt()
        val M = br.readLine().toInt()
        val indeg = IntArray(N + 1)
        dp = Array(N + 1) { IntArray(N + 1) }
        val arr = Array(N + 1) { arrayListOf<Pair<Int, Int>>() }

        for (i in 1..M) {
            val (x, y, k) = br.readLine()
                .split(" ")
                .map { it.toInt() }
            arr[x].add(Pair(y, k))
            indeg[y] += 1
        }

        fun topologySort() {
            val q = LinkedList<Int>()
            for (i in 1..N) {
                if (indeg[i] == 0) {
                    q.offer(i)
                }
            }

            while (q.isNotEmpty()) {
                val now = q.poll()

                for ((next, nextCnt) in arr[now]) {
                    indeg[next] -= 1

                    if (dp[now].all { it == 0 }) {
                        dp[next][now] += nextCnt
                    } else {
                        dp[next][N] += dp[now][N] * nextCnt
                    }

                    if (indeg[next] == 0) {
                        q.offer(next)
                    }
                }
            }
        }

        // execute
        topologySort()

        for (i in 1..N) {
            if (arr[i].isEmpty()) {
                bw.appendLine("$i ${dp[i][N]}")
            }
        }


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ2637.solve()
}