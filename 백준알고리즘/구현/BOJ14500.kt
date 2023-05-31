package baekjoon

object BOJ14500 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private lateinit var arr: Array<IntArray>
    private lateinit var visited: Array<BooleanArray>

    private var ans = Int.MIN_VALUE
    fun solve() {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        visited = Array(N) { BooleanArray(M) }
        arr = Array(N) { IntArray(M) }
        for (i in 0 until N) {
            br.readLine()
                .split(" ")
                .forEachIndexed { j, s ->
                    arr[i][j] = s.toInt()
                }
        }

        for (i in 0 until N) {
            for (j in 0 until M) {
                visited[i][j] = true
                dfs(i, j, 0, 0)
                visited[i][j] = false
                extraDfs(i, j)
            }
        }

        bw.appendLine("$ans")

        br.close()
        bw.flush()
    }

    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)
    private fun dfs(x: Int, y: Int, depth: Int, value: Int) {
        // 조건2. 4칸을 확인한 경우 최대값 설정
        if (depth == 4) {
            ans = maxOf(ans, value)
            return
        }

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            // 조건1. 영역 밖 무시
            if (nx !in arr.indices || ny !in arr[x].indices) continue

            if (!visited[nx][ny]) {
                visited[nx][ny] = true
                dfs(nx, ny, depth + 1, value + arr[nx][ny])
                visited[nx][ny] = false
            }
        }
    }

    private val ex = arrayOf(
        intArrayOf(0, 0, 0, 1),
        intArrayOf(0, 1, 2, 1),
        intArrayOf(0, 0, 0, -1),
        intArrayOf(0, -1, 0, 1)
    )
    private val ey = arrayOf(
        intArrayOf(0, 1, 2, 1),
        intArrayOf(0, 0, 0, 1),
        intArrayOf(0, 1, 2, 1),
        intArrayOf(0, 1, 1, 1)
    )

    private fun extraDfs(x: Int, y: Int) {

        for (i in 0..3) {
            var isOut = false
            var sumValue = 0
            for (j in 0..3) {
                val nx = x + ex[i][j]
                val ny = y + ey[i][j]

                if (nx !in arr.indices || ny !in arr[x].indices) {
                    isOut = true
                    break
                }

                sumValue += arr[nx][ny]

            }

            if (!isOut) {
                ans = maxOf(ans, sumValue)
            }
        }
    }
}

private fun main() {
    BOJ14500.solve()
}