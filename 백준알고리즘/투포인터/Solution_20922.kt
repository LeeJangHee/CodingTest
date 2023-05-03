package kr.baekjoon

import kotlin.math.max

class Solution_20922 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {
        val (N, K) = br.readLine().split(" ").map { it.toInt() }

        val seq = br.readLine().split(" ").map { it.toInt() }

        val counting = IntArray(100_001)

        var start = 0
        var end = 0
        var result = 0
        while (end < N) {
            if (counting[seq[end]] != K) {
                // end 이동
                counting[seq[end]] += 1
                end += 1
            } else {
                // start 이동
                counting[seq[start]] -= 1
                start += 1
            }

            result = max(result, end - start)
        }

        bw.appendLine("$result")


        br.close()
        bw.flush()
    }
}

private fun main() {
    Solution_20922()
}