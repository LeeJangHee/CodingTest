package kr.baekjoon

@Deprecated("작은 단위의 부분으로 나누는 생각이 굉장히 어렵다. dp 를 많이 연습해야할듯.")
object BOJ16500 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val S = br.readLine()
        val N = br.readLine().toInt()

        val arr = Array(N) { String() }
        for (i in 0 until N) {
            arr[i] = br.readLine()
        }

        val dp = IntArray(101)

        for (i in S.indices) {
            if (dp[i] == 1 || i == 0) {
                for (j in 0 until N) {
                    val len = arr[j].length
                    if (i + len > S.length) continue

                    var flag = true
                    for (k in 0 until len) {
                        if (arr[j][k] != S[i + k]) {
                            flag = false
                            break
                        }
                    }

                    if (flag) {
                        dp[i + len] = 1
                    }
                }
            }
        }

        bw.appendLine("${dp[S.length]}")

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ16500.solve()
}