package baekjoon.barkingdog

class Solution_1822 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {
        val (A, B) = br.readLine().split(" ").map { it.toInt() }

        val setA = br.readLine().split(" ").map { it.toInt() }.sorted()
        val setB = br.readLine().split(" ").map { it.toInt() }.sorted()

        val ans = mutableListOf<Int>()
        for (elA in setA) {
            var st = 0
            var en = B - 1
            var flag = true
            while (st <= en) {
                val mid = (st + en) / 2

                if (setB[mid] > elA) {
                    en = mid - 1
                } else if (setB[mid] < elA) {
                    st = mid + 1
                } else {
                    flag = false
                    break
                }
            }

            if (flag) {
                ans.add(elA)
            }
        }
        bw.appendLine("${ans.size}")
            .appendLine(ans.joinToString(separator = " "))

        br.close()
        bw.flush()
    }


}

private fun main() {
    Solution_1822()
}