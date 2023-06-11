package baekjoon

object BOJ2096 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private lateinit var dp: Array<Array<IntArray>>
    private lateinit var arr: Array<IntArray>
    private var N: Int = 0

    fun solve() {

        N = br.readLine().toInt()
        arr = Array(N) { IntArray(3) }
        dp = Array(N) { Array(3) { IntArray(2) } }

        for (i in 0 until N) {
            br.readLine()
                .split(" ")
                .forEachIndexed { j, s ->
                    arr[i][j] = s.toInt()
                }
        }

        setValue()

        bw.append("${getMaxValue(dp[N-1][0][0], dp[N-1][1][0], dp[N-1][2][0])}")
            .append(' ')
            .appendLine("${getMinValue(dp[N-1][0][1], dp[N-1][1][1], dp[N-1][2][1])}")


        br.close()
        bw.flush()
        bw.close()
    }

    private fun setValue() {
        for (i in 0 until N) {
            for (j in 0..2) {
                if (i == 0) {
                    dp[i][j][0] = arr[i][j]
                    dp[i][j][1] = arr[i][j]
                } else {
                    val (prevMaxValue, prevMinValue) = when (j) {
                        0 -> {
                            Pair(
                                getMaxValue(dp[i - 1][0][0], dp[i - 1][1][0]),
                                getMinValue(dp[i - 1][0][1], dp[i - 1][1][1])
                            )
                        }

                        1 -> {
                            Pair(
                                getMaxValue(dp[i - 1][0][0], dp[i - 1][1][0], dp[i - 1][2][0]),
                                getMinValue(dp[i - 1][0][1], dp[i - 1][1][1], dp[i - 1][2][1])
                            )
                        }

                        else -> {
                            Pair(
                                getMaxValue(dp[i - 1][1][0], dp[i - 1][2][0]),
                                getMinValue(dp[i - 1][1][1], dp[i - 1][2][1])
                            )
                        }
                    }
                    val curValue = arr[i][j]
                    dp[i][j][0] = prevMaxValue + curValue
                    dp[i][j][1] = prevMinValue + curValue
                }
            }
        }
    }

    private fun getMaxValue(vararg data: Int): Int {
        var max = Int.MIN_VALUE
        data.forEach {
            max = maxOf(max, it)
        }

        return max
    }

    private fun getMinValue(vararg data: Int): Int {
        var min = Int.MAX_VALUE
        data.forEach {
            min = minOf(min, it)
        }

        return min
    }
}

private fun main() {
    BOJ2096.solve()
}