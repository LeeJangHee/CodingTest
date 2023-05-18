package baekjoon

import java.util.*

object BOJ2206 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    // visited[x][y][0] : 부수지 않고 방문
    // visited[x][y][1] : 벽을 부수고 방문
    private lateinit var visited: Array<Array<BooleanArray>>
    fun solve() {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val miro = Array(N) { IntArray(M) }
        visited = Array(N) { Array(M) { BooleanArray(2) } }
        for (i in 0 until N) {
            br.readLine().map { it.digitToInt() }.forEachIndexed { j, d ->
                miro[i][j] = d
            }
        }

        if (!miro.bfs(N, M)) {
            bw.appendLine("-1")
        }

        br.close()
        bw.flush()
    }


    private val dy = intArrayOf(1, -1, 0, 0)
    private val dx = intArrayOf(0, 0, 1, -1)
    private fun Array<IntArray>.bfs(n: Int, m: Int): Boolean {
        val q = LinkedList<List<Int>>()
        q.offer(listOf(0, 0, 0))
        visited[0][0][0] = true
        val result = Array(n) { IntArray(m) }
        result[0][0] = 1

        while (q.isNotEmpty()) {
            val (x, y, flag) = q.poll()

            // 마지막 도착
            if (x == n - 1 && y == m - 1) {
                bw.appendLine("${result[x][y]}")
                return true
            }

            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                // IndexOutOfBound
                if (nx !in 0 until n || ny !in 0 until m) {
                    continue
                }

                val nextCnt = result[x][y] + 1
                val isWall = this[nx][ny] == 1

                if (isWall) {
                    // 벽인 경우
                    if (flag == 0) {
                        // 부순 적이 없는지 확인
                        visited[nx][ny][1] = true
                        q.offer(listOf(nx, ny, 1))
                        result[nx][ny] = nextCnt
                    }
                } else {
                    // 벽이 아닌 경우
                    if (flag == 0 && !visited[nx][ny][0]) {
                        // 벽을 부순적 없는 경우
                        visited[nx][ny][0] = true
                        q.offer(listOf(nx, ny, 0))
                        result[nx][ny] = nextCnt
                    } else if (flag == 1 && !visited[nx][ny][1]) {
                        // 벽을 부순적이 있는 경우
                        visited[nx][ny][1] = true
                        q.offer(listOf(nx, ny, 1))
                        result[nx][ny] = nextCnt
                    }
                }

            }
        }
        return false
    }
}

private fun main() {
    BOJ2206.solve()
}