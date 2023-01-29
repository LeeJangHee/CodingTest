package baekjoon.barkingdog

import java.lang.Integer.max

object Solution_1912 {

    private var answer = 0

    operator fun invoke() {
        val br = System.`in`.bufferedReader()

        val N = br.readLine().toInt()
        val arr = br.readLine().toString().split(" ").map { it.toInt() }

        val dp = IntArray(N) { Int.MIN_VALUE }
        dp[0] = arr[0]
        answer = dp[0]

        maxValue(N - 1, arr, dp)
        println(answer)

        br.close()
    }

    private fun maxValue(n: Int, arr: List<Int>, dp: IntArray): Int {

        if (dp[n] == Int.MIN_VALUE) {
            dp[n] = max(maxValue(n-1, arr, dp) + arr[n], arr[n])

            answer = max(dp[n], answer)
        }
        return dp[n]
    }

}

fun main() {
    Solution_1912()
}
