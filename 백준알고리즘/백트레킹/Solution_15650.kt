package kr.baekjoon

class Solution_15650 {

    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var arr: IntArray
    init {

        val (N, M) = br.readLine().split(" ").map { it.toInt() }

        arr = IntArray(M)
        backtracking(N, M, 1, 0)

        br.close()
        bw.flush()
    }

    private fun backtracking(n: Int, m: Int, start: Int, target: Int) {
        if (target == m) {
            arr.forEach {
                bw.append("$it ")
            }
            bw.appendLine()
            return
        }

        for (i in start..n) {
            arr[target] = i
            backtracking(n, m, i + 1, target + 1)
        }
    }
}

private fun main() {
    Solution_15650()
}