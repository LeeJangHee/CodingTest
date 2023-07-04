package kr.baekjoon

object BOJ10942 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private lateinit var dp: Array<BooleanArray>

    fun solve() {
        val N = br.readLine().toInt()
        val arr = mutableListOf(0)
        arr.addAll(br.readLine().split(Regex("\\s")).map { it.toInt() })

        dp = Array(N + 1) { BooleanArray(N + 1) }

        for (i in 1..N) {
            if (i < N && arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true
            }
            dp[i][i] = true
        }

        arr.palindrome()

        val M = br.readLine().toInt()
        for (i in 0 until M) {
            val (st, en) = br.readLine().split(" ").map { it.toInt() }
            val flag = if (dp[st][en]) "1" else "0"
            bw.appendLine(flag)
        }


        br.close()
        bw.flush()
    }

    private fun List<Int>.palindrome() {
        for (i in lastIndex-1 downTo 1) {
            for (j in i+2..lastIndex) {
                println("i: $i | j: $j")
                if (this[i] == this[j] && dp[i + 1][j - 1]) {
                    println("true")
                    dp[i][j] = true
                }
            }
        }
    }
}

private fun main() {
    BOJ10942.solve()
}