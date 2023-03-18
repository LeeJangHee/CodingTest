package baekjoon.barkingdog

class Solution_11727 {

    private var dp = IntArray(1001)

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val n = br.readLine().toInt()

        dp[1] = 1
        dp[2] = 3

        for (i in 3..n) {
            dp[i] = dp[i - 1] + (2 * dp[i - 2])
            dp[i] %= 10007
        }

        bw.write("${dp[n]}")

        br.close()
        bw.flush()
    }
}

private fun main() {
    Solution_11727()
}