package kr.baekjoon

class Solution_1699 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {
        val n = br.readLine().toInt()
        val dp = IntArray(n + 1)

        for (i in 1..n) {
            // 초기값 설정
            dp[i] = i

            var j = 1
            while(j * j <= i) {
                // dp[i] = dp[i - j^2] + 1
                // 13 -> (13 - 1), (13 - 4), (13 - 9) 의 최소 제곱수의 합
                // 중 가장 작은 값과 + 1
                if (dp[i] > dp[i - j * j] + 1) {
                    dp[i] = dp[i - j * j] + 1
                }
                j++
            }
        }

        bw.write("${dp.last()}")

        br.close()
        bw.flush()
    }
}

private fun main() {
    Solution_1699()
}