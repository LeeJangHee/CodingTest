package kr.programmers.challenge3

@Deprecated(message = "10^9 * 10^9 완전 탐색이 불가능. 좌표를 사각형으로 생각하고 query 를 역순으로 ?!")
class BallMovementSimulation {
    // x축 이동 방향, 역방향 고려
    private val dx = intArrayOf(0, 0, 1, -1)

    // y축 이동 방향, 역방향 고려
    private val dy = intArrayOf(1, -1, 0, 0)


    fun solution(n: Int, m: Int, x: Int, y: Int, queries: Array<IntArray>): Long {

        var startX = x
        var startY = y
        var endX = x
        var endY = y

        fun calcNextRange(start: Int, end: Int, move: Int, max: Int): Pair<Int, Int> {
            val nStart = if (start == 0 && move > 0) 0 else start + move
            val nEnd = if (end == max - 1 && move < 0) max - 1 else end + move

            return if (nStart !in 0 until max) {
                if (nEnd !in 0 until max) {
                    // 1. 시작 + 종료 모두 범위 밖
                    -1 to -1
                } else {
                    // 2. 시작점만 범위 밖
                    0 to nEnd
                }
            } else {
                if (nEnd !in 0 until max) {
                    // 3. 종료점만 범위 밖
                    nStart to max - 1
                } else {
                    // 4. 둘 다 범위 이내 인 경우
                    nStart to nEnd
                }
            }

        }

        for (i in queries.lastIndex downTo 0) {
            val dir = queries[i][0]
            val cnt = queries[i][1]

            if (dir == 0 || dir == 1) {
                // y 좌표
                val p = calcNextRange(startY, endY, cnt * dy[dir], m)
                if (p.first == -1) return 0
                startY = p.first
                endY = p.second
            } else {
                // x 좌표
                val p = calcNextRange(startX, endX, cnt * dx[dir], n)
                if (p.first == -1) return 0
                startX = p.first
                endX = p.second
            }

        }
        return (endX - startX + 1).toLong() * (endY - startY + 1).toLong()
    }
}

private fun main() {
    val t = BallMovementSimulation()
    val bw = System.out.bufferedWriter()

    val arr1 = arrayOf(intArrayOf(2, 1), intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(0, 1), intArrayOf(2, 1))
    bw.appendLine("${t.solution(2, 2, 0, 0, arr1)}")    // 4
    val arr2 = arrayOf(intArrayOf(3, 1), intArrayOf(2, 2), intArrayOf(1, 1), intArrayOf(2, 3), intArrayOf(0, 1), intArrayOf(2, 1))
    bw.appendLine("${t.solution(2, 5, 0, 1, arr2)}")    // 2

    bw.flush()
}