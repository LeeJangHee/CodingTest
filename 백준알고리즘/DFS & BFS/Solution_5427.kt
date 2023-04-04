package kr.baekjoon

import java.util.*

class Solution_5427 {

    private val dx = intArrayOf(-1, 1, 0, 0)
    private val dy = intArrayOf(0, 0, -1, 1)

    private lateinit var q: Queue<Pair<Int, Int>>
    private lateinit var fire: Array<IntArray>
    private lateinit var visited: Array<IntArray>

    init {
        val br = System.`in`.bufferedReader()
        val testCase = br.readLine().toInt()

        for (t in 0 until testCase) {
            var currentPosition = Pair(0, 0)
            q = LinkedList()

            val (W: Int, H: Int) = br.readLine().split(" ").map { it.toInt() }
            val buildingMap: Array<CharArray> = Array(H) { CharArray(W) }
            fire = Array(H) { IntArray(W) }
            visited = Array(H) { IntArray(W) }
            for (i in 0 until H) {
                val str = br.readLine()
                for (j in 0 until W) {
                    visited[i][j] = Int.MAX_VALUE
                    fire[i][j] = Int.MAX_VALUE
                    buildingMap[i][j] = str[j]
                    when (buildingMap[i][j]) {
                        '*' -> {
                            q.add(i to j)
                            fire[i][j] = 0
                        }
                        '@' -> {
                            currentPosition = i to j
                            visited[i][j] = 0
                        }
                    }
                }
            }

            println(move(buildingMap, currentPosition))
            q.clear()
        }

        br.close()
    }


    private fun move(map: Array<CharArray>, startNode: Pair<Int, Int>): String {
        while (q.isNotEmpty()) {
            val (x, y) = q.poll()
            for (k in 0..3) {
                val nx = x + dx[k]
                val ny = y + dy[k]
                val cnt = fire[x][y] + 1
                if (nx !in map.indices || ny !in map[x].indices || map[nx][ny] == '#' || fire[nx][ny] <= cnt) {
                    continue
                }

                fire[nx][ny] = cnt
                q.add(nx to ny)
            }
        }

        q.add(startNode)
        var result = Int.MIN_VALUE
        while (q.isNotEmpty() && result == Int.MIN_VALUE) {
            val (x, y) = q.poll()
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                val cnt = visited[x][y] + 1

                if (nx !in map.indices || ny !in map[x].indices) {
                    result = cnt
                    break
                }

                if (map[nx][ny] == '#' || visited[nx][ny] <= cnt || fire[nx][ny] <= cnt) {
                    continue
                }

                visited[nx][ny] = cnt
                q.add(nx to ny)
            }
        }

        return if (result == Int.MIN_VALUE) {
            "IMPOSSIBLE"
        } else {
            result.toString()
        }
    }
}

private fun main() {
    Solution_5427()
}