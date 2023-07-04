package kr.baekjoon

object BOJ9655 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val n = br.readLine().toInt()

        val dp = IntArray(1001)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 1
        for (i in 4..1000) {
            dp[i] = minOf(dp[i - 1] + 1, dp[i - 3] + 1)
        }

        val winner = if (dp[n] % 2 == 0) "CY" else "SK"
        bw.appendLine(winner)

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ9655.solve()
}