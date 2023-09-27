package baekjoon


import java.util.*

object BOJ13549 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private const val MAX_DISTANCE = 100_001
    private const val INF = 10e7.toInt()

    private data class State(
        val pos: Int,
        val time: Int
    )

    fun solve() {
        // N: 10^5, K: 10^5
        val (N, K) = br.readLine().split(Regex("\\s")).map { it.toInt() }

        fun bfs(): String {
            val q = LinkedList<State>()
            val visited = IntArray(MAX_DISTANCE) { INF }
            q.offer(State(N, 0))
            visited[N] = 0

            while (q.isNotEmpty()) {
                val now = q.pop()

                val next1 = now.pos * 2
                if (isValidPosition(next1) && visited[next1] > now.time) {
                    visited[next1] = now.time
                    q.offer(State(next1, visited[next1]))
                }

                val next2 = now.pos + 1
                if (isValidPosition(next2) && visited[next2] > now.time + 1) {
                    visited[next2] = now.time + 1
                    q.offer(State(next2, visited[next2]))
                }

                val next3 = now.pos - 1
                if (isValidPosition(next3) && visited[next3] > now.time + 1) {
                    visited[next3] = now.time + 1
                    q.offer(State(next3, visited[next3]))
                }
            }

            return "${visited[K]}"
        }

        if (N >= K) {
            bw.appendLine("${N - K}")
        } else {
            bw.appendLine(bfs())
        }

        br.close()
        bw.flush()
    }

    private fun isValidPosition(target: Int): Boolean {
        return target in IntRange(0, MAX_DISTANCE - 1)
    }

}

private fun main() {
    BOJ13549.solve()
}