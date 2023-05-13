package baekjoon

object BOJ1527 {
    private val bw = System.out.bufferedWriter()
    fun solution(a: Int, b: Int) {
        var ans = 0
        fun findGumminsoo(num: Long) {
            if (num > b) return
            if (num >= a) {
                ans += 1
            }
            findGumminsoo(num * 10 + 4)
            findGumminsoo(num * 10 + 7)
        }

        findGumminsoo(4)
        findGumminsoo(7)

        bw.appendLine("$ans")
        bw.flush()
    }

}

private fun main() {
    val br = System.`in`.bufferedReader()
    val (A, B) = br.readLine().split(" ").map { it.toInt() }
    BOJ1527.solution(A, B)
}