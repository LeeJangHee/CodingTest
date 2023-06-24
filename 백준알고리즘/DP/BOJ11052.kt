package kr.baekjoon

object BOJ11052 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val N = br.readLine().toInt()
        val arr = IntArray(N + 1)
        br.readLine()
            .split(Regex("\\s"))
            .forEachIndexed { index, s ->
                arr[index+1] = s.toInt()
            }

        val dp = IntArray(N + 1)
        for (i in arr.indices) {
            dp[i] = arr[i]
        }

        // 1 : dp[1] = dp[1], dp[0]+arr[1]
        // 2 : dp[2] = dp[2], dp[1]+arr[1], dp[0]+arr[2]
        // 3 : dp[3] = dp[3], dp[2]+arr[1], dp[1]+arr[2], dp[0]+arr[3]
        // 4 : dp[4] = dp[4], dp[3]+arr[1], dp[2]+arr[2], dp[1]+arr[3], dp[0]+arr[4]
        // ....
        // n : dp[n] = dp[n], dp[n-1]+arr[1], dp[n-2]+arr[2], ... dp[n-(n-1)]+arr[n-1], dp[n-n]+arr[n]
        for (i in 1..N) {
            for (j in 1..i) {
                dp[i] = maxOf(dp[i], dp[i-j] + arr[j])
            }
        }

        bw.appendLine("${dp.last()}")

        br.close()
        bw.flush()
    }

}

private fun main() {
    BOJ11052.solve()
}