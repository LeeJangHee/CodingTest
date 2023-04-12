package kr.baekjoon

class Solution_1463 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {
        var N = br.readLine().toInt()

        val dp = IntArray(N + 1)
        for (i in 1..N) {
            if (i == 1) {
                dp[i] = 0
                continue
            }

            dp[i] = dp[i - 1] + 1
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1
            }
        }

        bw.appendLine("${dp[N]}")
        bw.flush()
        br.close()
    }
}

private fun main() {
    Solution_1463()
}