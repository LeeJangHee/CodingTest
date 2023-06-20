package baekjoon

object BOJ1629 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {

        val (a, b, c) = br.readLine()
            .split(Regex("\\s"))
            .map { it.toInt() }

        fun power(x: Long): Long {
            if (x == 0L) return 1
            // 나머지 정리
            // (x * y) % z = ((x % z) * (y % z)) % z
            if (x == 1L) return a % c.toLong()

            // 분할 정복
            val k = power(x / 2) % c
            // 지수 법칙
            return if (x % 2 == 0L) {
                // 짝수
                // x^(y/2) * x^(y/2)
                k * k % c
            } else {
                // 홀수
                // x^(y/2) * x^(y/2+1)
                k * k % c * a % c
            }
        }

        bw.appendLine("${power(b.toLong())}")

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ1629.solve()
}