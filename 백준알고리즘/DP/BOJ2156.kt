package baekjoon

object BOJ2156 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        /*
        1. 포도주 잔을 선택 = 모두 마시고 원래 자리
        2. 연속으로 3잔 마실 수 없음
        최대 10^4
        O(n^2) 까지 사용 가능
         */
        val N = br.readLine().toInt()
        val arr = IntArray(N + 1)
        for (i in 1..N) {
            arr[i] = br.readLine().toInt()
        }

        val dp = IntArray(N + 1)
        when (N) {
            1 -> bw.appendLine("${arr[1]}")
            2 -> bw.appendLine("${arr[1] + arr[2]}")
            else -> {
                dp[1] = arr[1]
                dp[2] = arr[1] + arr[2]

                for (i in 3 until arr.size) {
                    dp[i] = maxOfNumbers(
                        dp[i - 1],
                        dp[i - 2] + arr[i],
                        dp[i - 3] + arr[i - 1] + arr[i]
                    )
                }
                bw.appendLine("${dp.last()}")
            }
        }
        br.close()
        bw.flush()
    }

    private fun maxOfNumbers(vararg nums: Int): Int {
        return nums.maxOf { it }
    }
}

private fun main() {
    BOJ2156.solve()
}
