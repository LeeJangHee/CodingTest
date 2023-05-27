package baekjoon

object BOJ12865 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val (N, K) = br.readLine()
            .split(" ")
            .map { it.toInt() }

        val dp = Array(N + 1) { IntArray(K + 1) }
        for (i in 1..N) {
            val (w, v) = br.readLine()
                .split(" ")
                .map { it.toInt() }
            // knapsack 알고리즘
            // 가방에 들어갈 수 있는 최대 가치를 찾기 위해 1~K 까지 가방 사이즈를
            // 변경하며서 1개씩 비교한다.
            for (j in 1..K) {
                if (j < w) {
                    // 현재 가방 사이즈가 물건의 무게 보다 작으면 이전 값을 넣는다.
                    dp[i][j] = dp[i - 1][j]
                } else {
                    // 가방사이즈가 큰 경우
                    // 이전 값의 가치와 이전 값의 무게를 뺀 가치와 지금 가치를 더한 것 중
                    // 더 큰 값을 현재 값으로 설정한다.
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - w] + v)
                }
            }

        }
        /*
        1 6 = 13
        1 7 = max(dp[0][7], dp[0][1] + 13) = 13

        2 4 = 8
        2 5 = max(dp[1][4], dp[1][1] + 8) = 8
        2 6 = max(dp[1][6], dp[1][2] + 8) = 13
        2 7 = max(dp[1][7], dp[1][3] + 8) = 13

        3 3 = 6
        3 4 = max(dp[2][4], dp[2][1] + 6) = 8
        3 5 = max(dp[2][5], dp[2][2] + 6) = 8
        3 6 = max(dp[2][6], dp[2][3] + 6) = 13
        3 7 = max(dp[2][7], dp[2][4] + 6) = 14

        4 3 = 6
        4 8 = 8
        4 5 = max(dp[3][5], dp[3][0] + 12) = 12
        4 6 = max(dp[3][6], dp[3][1] + 12) = 13
        4 7 = max(dp[3][7], dp[3][2] + 12) = 14
         */
        bw.appendLine("${dp[N][K]}")

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ12865.solve()
}