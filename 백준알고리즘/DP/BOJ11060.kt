package baekjoon

import java.util.*

object BOJ11060 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private val INF = 1e9.toInt()
    private lateinit var dp: IntArray
    fun solve() {
        val N = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }
        dp = IntArray(N) { INF }

        val q = LinkedList<Int>()
        q.offer(0)
        dp[0] = 0
        while (q.isNotEmpty()) {
            val x = q.poll()
            for (nx in x..x + arr[x]) {
                if (nx < N && dp[nx] == INF) {
                    dp[nx] = dp[x] + 1
                    q.offer(nx)
                }
            }
        }

        if (dp.last() >= INF) {
            bw.appendLine("-1")
        } else {
            bw.appendLine("${dp.last()}")
        }


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ11060.solve()
}