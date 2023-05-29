package baekjoon

import java.util.*

object BOJ4963 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private const val SEA = 0
    private const val LAND = 1

    private val dx = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
    private val dy = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)

    fun solve() {

        while (true) {
            val (W, H) = br.readLine().split(" ").map { it.toInt() }

            if (W == 0 && H == 0) break

            val arr = Array(H) { IntArray(W) }
            for (i in 0 until H) {
                br.readLine()
                    .split(" ")
                    .forEachIndexed { j, s ->
                        arr[i][j] = s.toInt()
                    }

            }

            val visited = Array(H) { BooleanArray(W) }

            fun bfs(a: Int, b: Int) {
                val q = LinkedList<Pair<Int, Int>>()
                q.offer(a to b)
                visited[a][b] = true
                while (q.isNotEmpty()) {
                    val (x, y) = q.poll()
                    for (i in 0..7) {
                        val nx = x + dx[i]
                        val ny = y + dy[i]

                        // 지도 밖
                        if (nx !in arr.indices || ny !in arr[x].indices) continue

                        // 바다인 경우
                        if (arr[nx][ny] == SEA) continue

                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true
                            q.offer(nx to ny)
                        }
                    }
                }
            }

            var cnt = 0
            for (i in 0 until H) {
                for (j in 0 until W) {
                    if (!visited[i][j] && arr[i][j] == LAND) {
                        bfs(i, j)
                        cnt += 1
                    }
                }
            }


            bw.appendLine("$cnt")
        }

        br.close()
        bw.flush()
    }

}

private fun main() {
    BOJ4963.solve()
}