package baekjoon

import java.util.*

object BOJ1158 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {

        val (N, K) = br.readLine().split(Regex("\\s")).map { it.toInt() }
        val q: Deque<Int> = ArrayDeque(N)
        for (i in 1..N) {
            q.offer(i)
        }

        val sb = StringBuilder()
        sb.append("<")

        var count = 1
        while (q.isNotEmpty()) {
            val num = q.poll()
            if (count == K) {
                count = 1
                if (q.isEmpty()) {
                    sb.append("$num")
                } else {
                    sb.append("$num, ")
                }
            } else {
                q.offer(num)
                count += 1
            }
        }
        sb.append(">")
        bw.appendLine(sb.toString())

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ1158.solve()
}