package baekjoon

object BOJ14889 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val N = br.readLine().toInt()
        val arr = Array(N) { IntArray(N) }
        for (i in 0 until N) {
            br.readLine()
                .split(" ")
                .forEachIndexed { j, s ->
                    arr[i][j] = s.toInt()
                }
        }
        val visited = BooleanArray(N)

        // 완전탐색
        // 팀을 나눈다.
        // 모든 경우의 수를 구해야함
        var ans = Int.MAX_VALUE

        fun backtracking(idx: Int, depth: Int) {
            if (depth == N / 2) {
                val point = visited.totalPoint(arr)
                ans = minOf(ans, point)
                return
            }

            for (i in idx until arr.size) {
                if (!visited[i]) {
                    visited[i] = true
                    backtracking(i + 1, depth + 1)
                    visited[i] = false
                }
            }
        }

        // 모든 경우의 수
        // nCn/2 --> n! / (n-r)! * r!
        // n! / (n-n/2)! * (n/2)!
        // 4! / 2! * 2!
        // 20! / 10! * 10!
        backtracking(0, 0)
        bw.appendLine("$ans")

        br.close()
        bw.flush()
    }

    private fun BooleanArray.totalPoint(arr: Array<IntArray>): Int {
        var start = 0
        var link = 0
        forEachIndexed { i, ib ->
            forEachIndexed { j, jb ->
                if (ib && jb) {
                    start += arr[i][j]
                }
                if (!ib && !jb) {
                    link += arr[i][j]
                }
            }
        }
        return Math.abs(start - link)
    }
}

private fun main() {
    BOJ14889.solve()
}