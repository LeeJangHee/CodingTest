package baekjoon

object BOJ1309 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        // max value = 10^6
        val n = br.readLine().toInt()

        // 0 : 1
        // 1 : 3
        // 2 : 7 = 2*a[1]+a[0]
        // 3 : 17 = 2*a[2]+a[1]
        // 4 : 41 = 2*a[3]+a[2]
        val dp = IntArray(100001)
        dp[0] = 1
        dp[1] = 3
        for (i in 2..n) {
            dp[i] = (2*dp[i-1] + dp[i-2]) % 9901
        }

        bw.appendLine("${dp[n]}")


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ1309.solve()
}