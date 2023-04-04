package kr.baekjoon

class Solution_6987 {

    companion object {
        private const val MAX_TEAM_COUNT = 6
        private const val WIN = 0
        private const val DRAW = 1
        private const val LOSE = 2
    }

    private var answer = IntArray(4)

    private var match = Array(MAX_TEAM_COUNT) { IntArray(3) }
    private var result = Array(MAX_TEAM_COUNT) { IntArray(3) }

    private val team1 = intArrayOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4)
    private val team2 = intArrayOf(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5)

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        for (i in 0 until 4) {
            val case = br.readLine().split(" ").map { it.toInt() }
            for (j in 0 until MAX_TEAM_COUNT) {
                val index = j * 3
                match[j][0] = case[index]
                match[j][1] = case[index + 1]
                match[j][2] = case[index + 2]
            }
            backtracking(i, 0)
        }

        answer.forEach {
            bw.append("$it ")
        }

        br.close()
        bw.flush()
    }

    private fun backtracking(testCount: Int, round: Int) {
        // 라운드 15개 경기 종료
        if (round == 15) {
            // 이미 가능한 경우
            if (answer[testCount] == 1) return

            for (i in 0 until MAX_TEAM_COUNT) {
                for (j in 0 until 3) {
                    // 예측이 맞지 않는 경우
                    if (match[i][j] != result[i][j]) return
                }
            }

            // 모든 예측이 일치
            answer[testCount] = 1
            return
        }

        val t1 = team1[round]
        val t2 = team2[round]

        // t1 W, t2 L
        result[t1][WIN] += 1; result[t2][LOSE] += 1
        backtracking(testCount, round + 1)
        result[t1][WIN] -= 1; result[t2][LOSE] -= 1

        // t1 D, t2 D
        result[t1][DRAW] += 1; result[t2][DRAW] += 1
        backtracking(testCount, round + 1)
        result[t1][DRAW] -= 1; result[t2][DRAW] -= 1

        // t1 L, t2 W
        result[t1][LOSE] += 1; result[t2][WIN] += 1
        backtracking(testCount, round + 1)
        result[t1][LOSE] -= 1; result[t2][WIN] -= 1
    }
}

private fun main() {
    Solution_6987()
}