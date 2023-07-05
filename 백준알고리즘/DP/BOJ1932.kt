package kr.baekjoon

object BOJ1932 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val N = br.readLine().toInt()
        val arr = Array(N) { listOf<Int>() }

        for (i in 0 until N) {
            arr[i] = br.readLine().split(Regex("\\s")).map { it.toInt() }
        }

        val dp = Array(N) { IntArray(N) }
        dp[0][0] = arr[0][0]

        for (i in 1 until N) {
            for (j in arr[i].indices) {
                dp[i][j] = when (j) {
                    0 -> maxOf(dp[i][j], dp[i-1][j]+arr[i][j])
                    arr[i].lastIndex -> maxOf(dp[i][j], dp[i-1][j-1]+arr[i][j])
                    else -> maxOf(dp[i][j], maxOf(dp[i-1][j], dp[i-1][j-1]) + arr[i][j])
                }
            }
        }

        bw.appendLine("${dp.last().maxOf { it }}")

        br.close()
        bw.flush()
    }

}

private fun main() {
    BOJ1932.solve()
}