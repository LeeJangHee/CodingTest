package kr.baekjoon

class Solution_10844 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {
        val N = br.readLine().toInt()
        val sum = countStairNumbers(N)
        bw.appendLine("$sum")

        br.close()
        bw.flush()
    }

    private fun countStairNumbers(n: Int): Long {
        // 길이가 1인 경우 계단 수는 9이다.
        if (n == 1) return 9L

        // DP 배열을 초기화한다.
        // dp[i][j]는 길이가 i이고 j로 끝나는 계단 수의 개수이다.
        val dp = Array(n + 1) { LongArray(10) }
        // 초기 값 설정
        for (i in 1..9) dp[1][i] = 1L

        // 점화식을 이용해 DP 배열을 채운다.
        for (i in 2..n) {
            for (j in 0..9) {
                dp[i][j] = when (j) {
                    0 -> dp[i-1][1]
                    9 -> dp[i-1][8]
                    else -> dp[i-1][j-1] + dp[i-1][j+1]
                }
                dp[i][j] %= MOD
            }
        }

        // DP 배열에서 길이가 n이고 인접한 자리의 차이가 1인 계단 수의 총 개수를 반환한다.
        return dp[n].sum() % MOD
    }

    companion object {
        private const val MOD: Long = 1000000000
    }
}

private fun main() {
    Solution_10844()
}