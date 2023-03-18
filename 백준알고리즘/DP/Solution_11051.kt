package baekjoon.barkingdog

class Solution_11051 {

    private val dp = Array(1001) { IntArray(1001) }

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }

        binomial(n, k)

        bw.write("${dp[n][k]}")

        br.close()
        bw.flush()
    }

    private fun binomial(n: Int, k: Int) {
        // 이항계수 성질을 이용해 초기화
        for (i in 0..n) {
            dp[i][0] = 1
        }
        for (i in 0..k) {
            dp[i][i] = 1
        }

        for (i in 1..n) {
            for (j in 1..k) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
                dp[i][j] %= 10007
            }
        }
    }
}

private fun main() {
    Solution_11051()
}