package kr.baekjoon

import java.lang.Integer.max

class Solution_2579 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var dp: IntArray

    init {
        val N = br.readLine().toInt()
        dp = IntArray(N)
        val stairs = arrayListOf<Int>()
        for (i in 0 until N) {
            stairs.add(br.readLine().toInt())
        }

        dp[0] = stairs[0]

        // dp[n] = max(dp[n-3] + stairs[n-1], dp[n-2]) + stairs[n]
        for (i in 1 until N) {
            dp[i] = when (i) {
                1 -> stairs[0] + stairs[1]
                2 -> max(stairs[0], stairs[1]) + stairs[2]
                else -> max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i]
            }
        }

        bw.write("${dp.last()}")


        br.close()
        bw.flush()
    }
}

private fun main() {
    Solution_2579()
}