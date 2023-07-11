package kr.baekjoon

object BOJ9461 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        var t = br.readLine().toInt()
        val dp = LongArray(101)
        dp[1] = 1
        dp[2] = 1
        for (i in 3..100) {
            dp[i] = dp[i - 2] + dp[i - 3]
        }

        while (t-- > 0) {
            val n = br.readLine().toInt()
            bw.appendLine("${dp[n]}")
        }

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ9461.solve()
}