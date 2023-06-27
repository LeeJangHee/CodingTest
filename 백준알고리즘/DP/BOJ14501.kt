package kr.baekjoon

object BOJ14501 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private data class Value(
        val t: Int,
        val p: Int
    )

    private lateinit var dp: IntArray

    fun solve() {
        val N = br.readLine().toInt()
        val arr = Array<Value>(N) { Value(0, 0) }
        for (i in 0 until N) {
            val (t, p) = br.readLine()
                .split(Regex("\\s"))
                .map { it.toInt() }
            arr[i] = Value(t, p)
        }

        dp = IntArray(N + 1)

        for (i in 0 until N) {
            val cur = arr[i]
            for (j in i + cur.t..N) {
                dp[j] = maxOf(dp[j], dp[i] + cur.p)
            }
        }

        bw.appendLine("${dp.last()}")

        br.close()
        bw.flush()
    }

}

private fun main() {
    BOJ14501.solve()
}