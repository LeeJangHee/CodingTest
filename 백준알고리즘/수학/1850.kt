package kr.baekjoon

import java.lang.Long.max
import java.lang.Long.min

class Solution_1850 {

    init {
        val br = System.`in`.bufferedReader()

        val (A: Long, B: Long) = br.readLine().split(" ").map { it.toLong() }

        val gcd = gcd(min(A, B), max(A, B))
        val str = StringBuilder()
        repeat(gcd.toInt()) {
            str.append("1")
        }
        println(str.toString())

        br.close()
    }

    private fun gcd(a: Long, b: Long): Long {
        if (b == 0L) return a
        return gcd(b, a % b)
    }
}

private fun main() {
    Solution_1850()
}
