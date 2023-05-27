package baekjoon

object BOJ1149 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private const val RED = 0
    private const val GREEN = 1
    private const val BLUE = 2

    fun solve() {
        val N = br.readLine().toInt()
        val dp = Array(N + 1) { IntArray(N + 1) }

        for (i in 1..N) {
            val (r, g, b) = br.readLine()
                .split(" ")
                .map { it.toInt() }

            dp[i][RED] = minOf(dp[i-1][GREEN], dp[i-1][BLUE]) + r
            dp[i][GREEN] = minOf(dp[i-1][RED], dp[i-1][BLUE]) + g
            dp[i][BLUE] = minOf(dp[i-1][RED], dp[i-1][GREEN]) + b
        }

        bw.appendLine("${minOfNumbers(dp[N])}")


        br.close()
        bw.flush()
    }

    private fun minOfNumbers(n: IntArray): Int {
        return n.filter { it != 0 }.minOf { it }
    }
}

private fun main() {
    BOJ1149.solve()
}