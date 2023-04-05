package kr.baekjoon

class Solution_15651 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var arr: IntArray

    init {

        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        arr = IntArray(M)
        backtracking(N, M, 0)

        br.close()
        bw.flush()
    }

    private fun backtracking(n: Int, m: Int, target: Int) {
        if (target == m) {
            arr.forEach {
                bw.append("$it ")
            }
            bw.appendLine()
            return
        }

        for (i in 1..n) {
            arr[target] = i
            backtracking(n, m, target + 1)
        }


    }
}

private fun main() {
    Solution_15651()
}