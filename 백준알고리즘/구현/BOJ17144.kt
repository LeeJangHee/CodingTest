package boj

import java.util.*

/**
 * 1 second = 10^8
 */
object BOJ17144 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)
    private lateinit var arr: Array<IntArray>
    private lateinit var airCleaner: ArrayList<Pair<Int, Int>>

    fun solve() {
        var (R, C, T) = br.readLine().split(Regex("\\s")).map { it.toInt() }

        arr = Array(R) { IntArray(C) }
        airCleaner = arrayListOf()

        for (i in 0 until R) {
            br.readLine()
                .split(Regex("\\s"))
                .forEachIndexed { j, data ->
                    arr[i][j] = data.toInt()
                    if (data.toInt() == -1) {
                        airCleaner.add(i to j)
                    }
                }
        }

        // 1. 미세먼지 확장
        // original : A(r,c) - (A(r,c)/5) * number of extended directions
        // extend : A(r,c)/5

        // 2. 공기 청정기 작동
        // 위: 시계 - (r, 0) -> (r, C) -> (0, C) -> (0, 0) -> (r, 0)
        // 아래: 반시계 - (r', 0) -> (r', C) -> (R, C) -> (R, 0) -> (r', 0)
        // 공기 청정기와 같은 위치를 가지면 미세먼지는 사라짐.
        while (T-- > 0) {
            dust(R, C)
            workAirCleaner(R, C)
        }

        var ans = 0
        for (i in 0 until R) {
            ans += arr[i].sum()
        }

        bw.appendLine("${ans + 2}")

        br.close()
        bw.flush()
    }

    private fun dust(r: Int, c: Int) {
        val q: Queue<Triple<Int, Int, Int>> = LinkedList()

        for (i in 0 until r) {
            for (j in 0 until c) {
                if (arr[i][j] > 0) {
                    q.offer(Triple(i, j, arr[i][j]))
                }
            }
        }

        while (q.isNotEmpty()) {
            val (x, y, d) = q.poll()

            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                // out of bounds
                if (nx !in 0 until r || ny !in 0 until c) {
                    continue
                }

                // air cleaner
                if (arr[nx][ny] == -1) {
                    continue
                }

                // dust
                arr[nx][ny] += d / 5
                arr[x][y] -= d / 5
            }
        }
    }

    private fun workAirCleaner(r: Int, c: Int) {

        val temp = Array(r) { IntArray(c) }
        for (i in 0 until r) {
            for (j in 0 until c) {
                temp[i][j] = arr[i][j]
            }
        }
        val (x1, y1) = airCleaner[0]
        val (x2, y2) = airCleaner[1]

        // 반시계방향
        arr[x1][1] = 0
        for (y in 2 until c) {
            arr[x1][y] = temp[x1][y - 1]
        }

        for (x in x1 - 1 downTo 0) {
            arr[x][c - 1] = temp[x + 1][c - 1]
        }

        for (y in c - 2 downTo 0) {
            arr[0][y] = temp[0][y + 1]
        }

        for (x in 1 until x1) {
            arr[x][0] = temp[x - 1][0]
        }

        // 시게방향
        arr[x2][1] = 0
        for (y in 2 until c) {
            arr[x2][y] = temp[x2][y - 1]
        }

        for (x in x2 + 1 until r) {
            arr[x][c - 1] = temp[x - 1][c - 1]
        }

        for (y in c - 2 downTo 0) {
            arr[r - 1][y] = temp[r - 1][y + 1]
        }

        for (x in r - 2 downTo x2 + 1) {
            arr[x][0] = temp[x + 1][0]
        }
    }

}

private fun main() {
    BOJ17144.solve()
}