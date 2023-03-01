package kr.baekjoon

import java.util.*

class Solution_2573 {

    private var minYear: Int = 0

    private var iceberg: Array<Array<Int>>
    private var N: Int
    private var M: Int

    private val dx = intArrayOf(-1, 1, 0, 0)
    private val dy = intArrayOf(0, 0, -1, 1)

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        N = n; M = m

        iceberg = Array(N) { Array(M) { 0 } }
        for (i in 0 until N) {
            br.readLine().split(" ").map { it.toInt() }.forEachIndexed { j, v ->
                iceberg[i][j] = v
            }
        }

        while (true) {
            val result = counting()

            if (result >= 2) {
                break
            } else if (result == 0) {
                minYear = 0
                break
            }

            meltIceberg()
            minYear += 1
        }

        bw.write("$minYear")


        br.close()
        bw.flush()
        bw.close()
    }

    private fun createVisited(): Array<Array<Boolean>> {
        return Array(N) { Array(M) { false } }
    }

    private fun counting(): Int {
        val visited = createVisited()
        var count = 0
        iceberg.forEachIndexed { i, ints ->
            ints.forEachIndexed { j, v ->
                if (v != 0 && !visited[i][j]) {
                    isDivideIceberg(i, j, visited)
                    count += 1
                }
            }
        }

        return count
    }

    private fun isDivideIceberg(x: Int, y: Int, visited: Array<Array<Boolean>>) {
        visited[x][y] = true

        for (k in 0 until 4) {
            val dx = x + dx[k]
            val dy = y + dy[k]
            // 범위를 벗어난 경우
            if (dx < 0 || dy < 0 || dx >= N || dy >= M)
                continue

            if (iceberg[dx][dy] != 0 && !visited[dx][dy]) {
                isDivideIceberg(dx, dy, visited)
            }
        }
    }

    private fun meltIceberg() {
        val q: Queue<Pair<Int, Int>> = LinkedList()

        val meltVisited = createVisited()
        iceberg.forEachIndexed { i, ints ->
            ints.forEachIndexed { j, v ->
                if (v != 0) {
                    q.offer(i to j)
                    meltVisited[i][j] = true
                }
            }
        }

        while (q.isNotEmpty()) {
            val (x, y) = q.poll()

            var seaCount = 0

            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue

                if (!meltVisited[nx][ny] && iceberg[nx][ny] == 0) {
                    seaCount += 1
                }
            }

            iceberg[x][y] -= seaCount
            if (iceberg[x][y] < 0)
                iceberg[x][y] = 0
        }

    }

}

private fun main() {
    Solution_2573()
}