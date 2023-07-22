package kr.baekjoon

object BOJ1475 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()


    fun solve() {
        var n = br.readLine().toInt()
        val sortArr = IntArray(9)

        do {
            var index = n % 10
            if (index == 9) {
                index = 6
            }
            sortArr[index] += 1
            n /= 10
        } while (n != 0)

        sortArr[6] -= sortArr[6] / 2

        bw.appendLine("${sortArr.maxOf { it }}")


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ1475.solve()
}