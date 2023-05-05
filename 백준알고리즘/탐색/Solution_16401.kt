package baekjoon.barkingdog

class Solution_16401 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {
        val (M, N) = br.readLine().split(" ").map { it.toInt() }
        var maxValue = 0
        val arr = br.readLine().split(" ").map {
            maxValue = maxOf(maxValue, it.toInt())
            it.toInt()
        }

        /*
        4 3
        10 10 15
        작은 크기로 변경가능
        제일 짧게 분리 = 1
        제일 길게 분리 = 10
         */
        var result = 0
        // 최소값
        var lt = 1
        // 최대값
        var rt = maxValue
        while (lt <= rt) {
            val mid = (lt + rt) / 2
            val cnt = arr.sumOf { it / mid }

            if (cnt >= M) {
                result = mid
                lt = mid + 1
            } else {
                rt = mid - 1
            }

        }

        bw.appendLine("$result")

        br.close()
        bw.flush()
    }
}

private fun main() {
    Solution_16401()
}