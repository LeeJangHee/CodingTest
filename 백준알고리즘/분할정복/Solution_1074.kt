package baekjoon.barkingdog

import kotlin.math.pow

class Solution_1074 {

    private var x: Int = Int.MIN_VALUE
    private var y: Int = Int.MIN_VALUE

    private var result = 0

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val (N, r, c) = br.readLine().split(" ").map { it.toInt() }
        x = r; y = c

        try {
            matrix(2.toDouble().pow(N.toDouble()).toInt(), 0, 0)
        } catch (e: Exception) {
            bw.write(result.toString())
        }

        br.close()
        bw.flush()
    }

    @Throws(Exception::class)
    private fun matrix(n: Int, start: Int, end: Int) {
        if (start == x && end == y) {
            throw Exception()
        }
        if (x in start until (start + n) && y in end until (end + n)) {
            val half = n / 2
            matrix(half, start, end)
            matrix(half, start, end + half)
            matrix(half, start + half, end)
            matrix(half, start + half, end + half)
        } else {
            result += (n * n)
        }

    }

}

private fun main() {
    Solution_1074()
}