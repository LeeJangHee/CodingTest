package kr.baekjoon

class Solution_12852 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {
        var N = br.readLine().toInt()
        val dp = IntArray(N + 1)

        for (i in 1..N) {
            if (i == 1) continue

            dp[i] = dp[i - 1] + 1
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1
            }
        }
        bw.appendLine("${dp[N]}")

        while (true) {
            bw.append("$N ")
            if (N == 1) {
                break
            }
            when {
                dp[N] == dp[N - 1] + 1 -> {
                    N -= 1
                }
                N % 3 == 0 && dp[N] == dp[N / 3] + 1 -> {
                    N /= 3
                }
                N % 2 == 0 && dp[N] == dp[N / 2] + 1 -> {
                    N /= 2
                }
            }
        }

        br.close()
        bw.flush()
    }
}

private fun main() {
    Solution_12852()
}