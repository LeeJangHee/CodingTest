package kr.baekjoon

import java.util.*

object BOJ2636 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var cheese: Int = 0
    private lateinit var arr: Array<IntArray>
    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)
    fun solve() {

        val (N, M) = br.readLine().split(Regex("\\s")).map { it.toInt() }
        arr = Array(N) { IntArray(M) }

        for (i in 0 until N) {
            br.readLine().split(Regex("\\s")).forEachIndexed { j, s ->
                arr[i][j] = s.toInt()
                if (arr[i][j] == 1) cheese += 1
            }
        }

        var count = 0
        var time = 0
        while (cheese != 0) {
            count = cheese
            time += 1
            bfs(N, M)
        }

        bw.appendLine("$time")
            .appendLine("$count")

        br.close()
        bw.flush()
    }


    private fun bfs(n: Int, m: Int) {
        val q = LinkedList<Pair<Int, Int>>()
        val visited = Array(n) { BooleanArray(m) }
        q.offer(0 to 0)
        visited[0][0] = true

        while (q.isNotEmpty()) {
            val (x, y) = q.pop()
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx !in arr.indices || ny !in arr[x].indices) continue

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true
                    if (arr[nx][ny] == 0) {
                        // 치즈가 아니면 다음으로 넘어감
                        q.offer(nx to ny)
                    } else {
                        // 치즈인 경우
                        // 치즈를 녹이고 치즈 개수를 줄임.
                        arr[nx][ny] = 0
                        cheese -= 1
                    }
                }
            }
        }
    }
}

private fun main() {
    BOJ2636.solve()
}