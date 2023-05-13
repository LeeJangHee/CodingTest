package baekjoon

object Solution_10835 {
    private val bw = System.out.bufferedWriter()

    fun backtracking(N: Int, A: List<Int>, B: List<Int>) {

        var point = 0

        fun play(left: Int, right: Int, p: Int) {
            // 3. 게임 종료
            if (left == N || right == N) {
                point = maxOf(p, point)
                return
            }
            val rf = B[right]
            val lf = A[left]

            // 2번 규칙
            // 오른쪽만 버리기
            if (rf < lf) {
                play(left, right + 1, p + rf)
            } else {
                // 1번 규칙
                // 왼쪽 버리기 먼저
                play(left + 1, right, p)

                // 왼 + 오 둘다 버리기
                play(left + 1, right + 1, p)
            }

        }

        play(0, 0, 0)
        bw.appendLine("$point")
        bw.flush()
    }

    fun solveDP(N: Int, A: List<Int>, B: List<Int>) {
        val dp = Array(N + 1) { IntArray(N + 1) { -1 } }
        fun solve(l: Int, r: Int): Int {
            if (l == N || r == N) {
                return 0
            }

            if (dp[l][r] != -1) {
                return dp[l][r]
            }

            dp[l][r] = 0
            if (B[r] < A[l]) {
                dp[l][r] += solve(l, r + 1) + B[r]
            } else {
                dp[l][r] += maxOf(solve(l + 1, r + 1), solve(l + 1, r))
            }

            return dp[l][r]
        }

        bw.appendLine("${solve(0, 0)}")
        bw.flush()
    }
}

private fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val A = br.readLine().split(" ").map { it.toInt() }
    val B = br.readLine().split(" ").map { it.toInt() }
    // 64점
//    Solution_10835.backtracking(N, A, B)
    // 100점
    Solution_10835.solveDP(N, A, B)
    br.close()
}
