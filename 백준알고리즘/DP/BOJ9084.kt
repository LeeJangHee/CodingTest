package kr.baekjoon

object BOJ9084 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        var t = br.readLine().toInt()
        while (t-- > 0) {
            val N = br.readLine().toInt()
            val arr = br.readLine().split(Regex("\\s")).map { it.toInt() }
            val M = br.readLine().toInt()
            val dp = IntArray(M + 1)
            dp[0] = 1

            arr.forEach {
                for (i in 1..M) {
                    if (i >= it) {
                        dp[i] += dp[i - it]
                    }
                }
            }

            bw.appendLine("${dp[M]}")
        }

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ9084.solve()
}