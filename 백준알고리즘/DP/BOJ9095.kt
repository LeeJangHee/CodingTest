package baekjoon

object BOJ9095 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()


    fun solve() {
        val t = br.readLine().toInt()
        val testCase = mutableListOf<Int>()
        for (i in 1..t) {
            testCase.add(br.readLine().toInt())
        }

        val dp = IntArray(12)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        for (i in 4 until dp.size) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
        }

        testCase.forEach {
            bw.appendLine("${dp[it]}")
        }
        br.close()
        bw.flush()
    }

}

private fun main() {
    BOJ9095.solve()
}