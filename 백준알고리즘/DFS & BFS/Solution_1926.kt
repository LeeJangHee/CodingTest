package kr.baekjoon

import java.util.*
import kotlin.math.max

class Solution_1926 {

    private val visited: Array<Array<Boolean>> = Array(501) { Array(500) { false } }
    private var biggestPicture: Int = 0
    private var pictureCount: Int = 0
    private val dx = intArrayOf(-1, 1, 0, 0)
    private val dy = intArrayOf(0, 0, -1, 1)

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val drawPaper = mutableListOf<List<Int>>()
        for (i in 0 until N) {
            drawPaper.add(br.readLine().split(" ").map { it.toInt() })
        }

        for (i in drawPaper.indices) {
            for (j in drawPaper[i].indices) {
                if (visited[i][j] || drawPaper[i][j] == 0) continue
                bfs(drawPaper, i, j)
            }
        }

        bw.write("$pictureCount\n$biggestPicture")

        br.close()
        bw.flush()
    }

    private fun bfs(drawPaper: MutableList<List<Int>>, i: Int, j: Int) {
        var count = 0
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.offer(i to j)
        visited[i][j] = true
        count += 1
        while (q.isNotEmpty()) {
            val (x, y) = q.poll()
            for (k in 0 until 4) {
                val nx = x + dx[k]
                val ny = y + dy[k]

                // index 벗어난 경우 무시
                if (nx < 0 || ny < 0 || nx >= drawPaper.size || ny >= drawPaper[i].size) continue

                // 그림이 아닌 경우 무시
                if (drawPaper[nx][ny] == 0) continue

                // 방문하지 않은 경우
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true
                    q.offer(nx to ny)
                    count += 1
                }
            }
        }
        if (count > 0) {
            pictureCount += 1
            biggestPicture = max(biggestPicture, count)
        }
    }
}

private fun main() {
    Solution_1926()
}