package kr.baekjoon

object BOJ11057 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()
    private val MOD = 10_007L

    private var sum = 10L
    fun solve() {

        // 숫자의 자리수
        val N = br.readLine().toInt()
        val dp = Array(N + 1) { LongArray(10) }

        for (i in 0..9) {
            dp[1][i] = 1L
        }

        for (i in 2..N) {

            for (j in 0..9) {
                if (j == 0) {
                    dp[i][0] = 1
                    continue
                }

                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j])
                dp[i][j] %= MOD
            }
        }

        bw.appendLine("${dp.last().sumOf { it } % MOD}")

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ11057.solve()
}