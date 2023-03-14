package baekjoon.barkingdog

import kotlin.math.abs

class Solution_2470 {

    private var answer = Long.MAX_VALUE
    private var liquid = LongArray(2)

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val N = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toLong() }.sorted()
        arr.mix(0, N - 1)

        bw.write("${liquid[0]} ${liquid[1]}")

        br.close()
        bw.flush()
    }

    private fun List<Long>.mix(start: Int, end: Int) {
        var lt = start
        var rt = end
        while (lt < rt) {
            val sum = this[lt] + this[rt]
            if (answer > abs(sum)) {
                answer = abs(sum)
                liquid[0] = this[lt]
                liquid[1] = this[rt]

                if (sum == 0L) break
            }

            if (sum < 0) {
                lt += 1
            } else {
                rt -= 1
            }
        }
    }
}

private fun main() {
    Solution_2470()
}