package baekjoon

object BOJ11660 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()


    fun solve() {

        val (N, M) = br.readLine().split(Regex("\\s")).map { it.toInt() }

        // N: max 2^10(10^3)
        // M: max 10^5
        val table = Array(N + 1) { IntArray(N + 1) }
        val dp = Array(N + 1) { IntArray(N + 1) }
        for (i in 1..N) {
            br.readLine().split(Regex("\\s"))
                .forEachIndexed { j, s ->
                    table[i][j+1] = s.toInt()
                }
        }

        for (i in 1..N) {
            for (j in 1..N) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1]) + table[i][j]
            }
        }


        for (i in 0 until M) {
            val (x1, y1, x2, y2) =
                br.readLine()
                    .split(Regex("\\s"))
                    .map { it.toInt() }

            val ans = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]
            bw.appendLine("$ans")
        }


        br.close()
        bw.flush()
    }
}


private fun main() {
    BOJ11660.solve()
}