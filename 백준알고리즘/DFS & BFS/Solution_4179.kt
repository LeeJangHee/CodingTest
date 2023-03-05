package kr.baekjoon

import java.awt.Point
import java.util.*

class Solution_4179 {

    private val dx = intArrayOf(-1, 1, 0, 0)
    private val dy = intArrayOf(0, 0, -1, 1)
    private var startPoint: Point = Point(0, 0)
    private var q: Queue<Point> = LinkedList()

    private var miro: Array<CharArray>
    private var N: Int
    private var M: Int
    private var fire: Array<IntArray>
    private var visited: Array<IntArray>

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        N = n; M = m
        miro = Array<CharArray>(N) { CharArray(M) }
        fire = Array<IntArray>(N) { IntArray(M) { Int.MAX_VALUE } }
        visited = Array<IntArray>(N) { IntArray(M) { Int.MAX_VALUE } }

        for (i in 0 until N) {
            val str = br.readLine()
            for (j in 0 until M) {
                miro[i][j] = str[j]

                when (str[j]) {
                    'J' -> {
                        visited[i][j] = 0
                        startPoint = Point(i, j)
                    }
                    'F' -> {
                        fire[i][j] = 0
                        q.offer(Point(i, j))
                    }
                }
            }
        }

        burn()
        bw.write(bfs(startPoint.x, startPoint.y))

        br.close()
        bw.flush()
        bw.close()
    }

    private fun bfs(x: Int, y: Int): String {
        q.offer(Point(x, y))
        var result = Int.MIN_VALUE
        while (q.isNotEmpty() && result == Int.MIN_VALUE) {
            val p = q.poll()
            for (i in 0..3) {
                val nx = p.x + dx[i]
                val ny = p.y + dy[i]
                val cnt = visited[p.x][p.y] + 1

                if (nx !in 0 until N || ny !in 0 until M) {
                    result = cnt
                    break
                }

                if (miro[nx][ny] == '#' || visited[nx][ny] <= cnt || fire[nx][ny] <= cnt) {
                    continue
                }

                visited[nx][ny] = cnt
                q.offer(Point(nx, ny))
            }
        }
        return if (result == Int.MIN_VALUE) {
            "IMPOSSIBLE"
        } else {
            result.toString()
        }
    }


    private fun burn() {
        // 불 번지는 부분
        while (q.isNotEmpty()) {
            val p = q.poll()
            for (k in 0 until 4) {
                val nx = p.x + dx[k]
                val ny = p.y + dy[k]
                val cnt = fire[p.x][p.y] + 1

                if (nx !in miro.indices || ny !in miro[p.x].indices || miro[nx][ny] == '#' || fire[nx][ny] <= cnt) {
                    continue
                }

                q.offer(Point(nx, ny))
                fire[nx][ny] = cnt
            }
        }
    }
}

private fun main() {
    Solution_4179()
}