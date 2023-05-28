package baekjoon

object BOJ14888 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {

        val N = br.readLine().toInt()
        val numbers = br.readLine()
            .split(" ")
            .map { it.toInt() }

        // oper[0] = +
        // oper[1] = -
        // oper[2] = *
        // oper[3] = /
        val oper = br.readLine()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()

        var maxValue = Int.MIN_VALUE
        var minValue = Int.MAX_VALUE
        fun backtracking(next: Int, value: Int) {
            if (next == N) {
                // 모든 숫자 선택 완료
                maxValue = maxOf(maxValue, value)
                minValue = minOf(minValue, value)
                return
            }


            if (oper[0] > 0) {
                oper[0] -= 1
                val sum = value + numbers[next]
                backtracking(next + 1, sum)
                oper[0] += 1
            }

            if (oper[1] > 0) {
                oper[1] -= 1
                val sub = value - numbers[next]
                backtracking(next + 1, sub)
                oper[1] += 1
            }

            if (oper[2] > 0) {
                oper[2] -= 1
                val mul = value * numbers[next]
                backtracking(next + 1, mul)
                oper[2] += 1
            }

            if (oper[3] > 0) {
                oper[3] -= 1
                val div = value / numbers[next]
                backtracking(next + 1, div)
                oper[3] += 1
            }

        }

        // 시작
        backtracking(1, numbers[0])

        bw.appendLine("$maxValue")
            .appendLine("$minValue")


        br.close()
        bw.flush()
    }


}

private fun main() {
    BOJ14888.solve()
}