package baekjoon.barkingdog

import kotlin.math.abs

class Solution_2467 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {
        val N = br.readLine().toInt()

        val liquid = br.readLine().split(" ").map { it.toInt() }.sorted()

        var lt = 0
        var rt = N -1
        val ans = intArrayOf(liquid[lt], liquid[rt])
        var minValue = abs(ans.sum())

        while (lt < rt) {
            val mix = liquid[lt] + liquid[rt]

            if (minValue >= abs(mix)) {
                minValue = abs(mix)
                ans[0] = liquid[lt]
                ans[1] = liquid[rt]
            }

            if (mix < 0) {
                // 산성: lt 증가
                lt += 1
            } else {
                // 알칼리성: rt 감소
                rt -= 1
            }
        }

        bw.appendLine(ans.joinToString(" "))

        br.close()
        bw.flush()
    }

}

private fun main() {
    Solution_2467()
}