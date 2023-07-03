package kr.baekjoon

object BOJ11659 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()


    fun solve() {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }

        val arr = IntArray(N + 1)

        br.readLine().split(Regex("\\s")).forEachIndexed { i, d ->
            arr[i + 1] = d.toInt()
        }

        val dp = IntArray(N + 1)
        dp[0] = arr[0]
        dp[1] = arr[1]
        for (i in 2..N) {
            dp[i] = dp[i-1] + arr[i]
        }

        for (i in 0 until M) {

            val (a, b) = br.readLine().split(" ").map { it.toInt() }

            bw.appendLine("${dp[b] - dp[a-1]}")
        }

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ11659.solve()
}