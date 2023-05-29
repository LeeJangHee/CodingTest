package baekjoon

import java.util.*

object BOJ10026 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private const val R = 'R'
    private const val G = 'G'
    private const val B = 'B'

    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)

    fun solve() {
        val N = br.readLine().toInt()
        val arr = Array(N) { CharArray(N) }
        for (i in 0 until N) {
            br.readLine().forEachIndexed { j, c ->
                arr[i][j] = c
            }
        }

        var cnt = 0
        var sameRGCnt = 0

        val visited = Array(N) { BooleanArray(N) }
        val visitedRG = Array(N) { BooleanArray(N) }

        fun bfsRGB(a: Int, b: Int) {
            val init = arr[a][b]
            val q = LinkedList<Pair<Int, Int>>()
            q.offer(a to b)
            visited[a][b] = true

            while(q.isNotEmpty()) {
                val (x, y) = q.poll()
                for (i in 0..3) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if (nx !in 0 until N || ny !in 0 until N) continue

                    if (init != arr[nx][ny]) continue

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true
                        q.offer(nx to ny)
                    }
                }
            }
        }

        fun bfsRGAndB(a: Int, b: Int) {
            val init = arr[a][b]
            val q = LinkedList<Pair<Int, Int>>()
            q.offer(a to b)
            visitedRG[a][b] = true
            while(q.isNotEmpty()) {
                val (x, y) = q.poll()
                for (i in 0..3) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if (nx !in 0 until N || ny !in 0 until N) continue

                    if (init == B) {
                        if (arr[nx][ny] != B) continue
                    } else {
                        if (arr[nx][ny] == B) continue
                    }

                    if (!visitedRG[nx][ny]) {
                        visitedRG[nx][ny] = true
                        q.offer(nx to ny)
                    }
                }
            }
        }

        for (i in 0 until N) {
            for (j in 0 until N) {
                if (!visited[i][j]) {
                    // 색약 아닌사람
                    bfsRGB(i, j)
                    cnt += 1
                }

                if (!visitedRG[i][j]) {
                    // 색약인 사람
                    bfsRGAndB(i, j)
                    sameRGCnt += 1
                }
            }
        }

        bw.appendLine("$cnt $sameRGCnt")


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ10026.solve()
}