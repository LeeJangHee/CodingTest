package baekjoon


object BOJ11053 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {

        val N = br.readLine().toInt()
        val dp = IntArray(N) { 1 }
        val arr = br.readLine()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()


        for (i in 1 until N) {
            for (j in 0 until i) {
                if (arr[i] > arr[j]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }

        bw.appendLine("${dp.maxOrNull()}")
        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ11053.solve()
}