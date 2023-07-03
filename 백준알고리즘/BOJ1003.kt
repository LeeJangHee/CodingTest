package kr.baekjoon

object BOJ1003 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private infix fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> {
        return this.first + other.first to this.second + other.second
    }

    private fun Pair<Int, Int>.print(): String {
        return "$first $second"
    }

    fun solve() {
        var t = br.readLine().toInt()

        val dp = Array(41) { Pair(0, 0) }
        dp[0] = Pair(1, 0)
        dp[1] = Pair(0, 1)
        for (i in 2..40) {
            dp[i] = dp[i-1] plus dp[i-2]
        }
        while (t-- > 0) {
            val n = br.readLine().toInt()
            bw.appendLine(dp[n].print())
        }

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ1003.solve()
}