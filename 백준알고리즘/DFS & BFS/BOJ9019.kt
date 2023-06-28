package kr.baekjoon

import java.util.*

object BOJ9019 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        var t = br.readLine().toInt()

        while (t-- > 0) {
            val (init, complete) = br.readLine().split(Regex("\\s")).map { it.toInt() }

            val visited = BooleanArray(10_000)
            // bfs
            val q = LinkedList<Pair<String, Int>>()
            q.offer("" to init)

            while (q.isNotEmpty()) {
                val (ans, now) = q.poll()
                if (now == complete) {
                    bw.appendLine(ans)
                    break
                }

                fun setOrNot(key: String, value: Int) {
                    if (!visited[value]) {
                        visited[value] = true
                        q.offer(ans + key to value)
                    }
                }

                val d = if (now * 2 > 9999) now * 2 % 10_000 else now * 2
                setOrNot("D", d)

                val s = if (now == 0) 9999 else now - 1
                setOrNot("S", s)

                val l = (now % 1_000) * 10 + (now / 1_000)
                setOrNot("L", l)

                val r = (now / 10) + (now % 10) * 1_000
                setOrNot("R", r)

            }

        }

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ9019.solve()
}
