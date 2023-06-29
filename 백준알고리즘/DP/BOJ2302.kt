package kr.baekjoon

object BOJ2302 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private val dp = IntArray(44)

    // 정답 개수
    private var ans = 1L
    fun solve() {
        val N = br.readLine().toInt()
        val M = br.readLine().toInt()

        dp[0] = 1
        dp[1] = 1
        for (i in 2..N) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        var prev = 0
        for (i in 1..M) {
            val t = br.readLine().toInt()
            ans *= dp[t - prev - 1]
            prev = t
        }
        ans *= dp[N - prev]

        bw.appendLine("$ans")
        br.close()
        bw.flush()
    }

}

private fun main() {
    BOJ2302.solve()
}