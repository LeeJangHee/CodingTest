package kr.baekjoon

object BOJ9657 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val n = br.readLine().toInt()

        val dp = BooleanArray(1001)
        dp[1] = true
        dp[3] = true
        dp[4] = true
        dp[5] = true
        for (i in 6..1000) {
            dp[i] = !dp[i-1] || !dp[i-3] || !dp[i-4]
        }
        val winner = if (dp[n]) "SK" else "CY"
        bw.appendLine(winner)

        br.close()
        bw.flush()
    }

}

private fun main() {
    BOJ9657.solve()
}