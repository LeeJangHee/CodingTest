package baekjoon.barkingdog

class Solution_15657 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private val ans: IntArray
    init {

        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        ans = IntArray(M)
        val arr = br.readLine()
            .split(" ")
            .map { it.toInt() }
            .sorted()

        backtracking(arr, N, M, 0, 0)

        br.close()
        bw.flush()
    }

    private fun backtracking(arr: List<Int>, n: Int, m: Int, start: Int, target: Int) {
        if (target == m) {
            ans.forEach {
                bw.append("$it ")
            }
            bw.appendLine()
            return
        }

        for (i in start until n) {
            ans[target] = arr[i]
            backtracking(arr, n, m, i, target + 1)
        }
    }
}

private fun main() {
    Solution_15657()
}