package baekjoon

object BOJ4673 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private val MAX_SELF = 10_000
    private val selfArr = BooleanArray(MAX_SELF + 1)
    fun solve() {

        for (i in 1..MAX_SELF) {
            val n = d(i)
            if (n <= MAX_SELF) {
                selfArr[n] = true
            }
        }

        for (i in 1 until selfArr.size) {
            if (!selfArr[i]) {
                bw.appendLine("$i")
            }
        }

        br.close()
        bw.flush()
    }

    private fun d(num: Int): Int {
        var sum = num
        var n = num
        while (n != 0) {
            sum += n % 10
            n /= 10
        }
        return sum
    }
}

private fun main() {
    BOJ4673.solve()
}