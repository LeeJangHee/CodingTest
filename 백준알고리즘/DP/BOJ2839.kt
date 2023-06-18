package baekjoon

object BOJ2839 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        var N = br.readLine().toInt()
        val dp = IntArray(N + 1) { Int.MAX_VALUE }

        for (i in 1..N / 3) {
            if (N % (3 * i) == 0) {
                dp[3 * i] = minOf(dp[3 * i], i)
            }
            for (j in 1..N / 5) {
                val idx = (3 * i) + (5 * j)
                val idx5 = (5 * j)

                if (N % idx5 == 0) {
                    dp[idx5] = minOf(idx5, j)
                }

                if (idx <= N) {
                    dp[idx] = minOf(dp[idx], i + j)
                }

            }
        }

        if (dp[N] == Int.MAX_VALUE) {
            bw.appendLine("-1")
        } else {
            bw.appendLine("${dp[N]}")
        }

        br.close()
        bw.flush()
    }

    private fun minValueOf(vararg idx: Int): Int {
        return idx.minOf { it }
    }
}

private fun main() {
    BOJ2839.solve()
}