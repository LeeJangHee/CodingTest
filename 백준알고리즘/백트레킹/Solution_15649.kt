package kr.baekjoon

class Solution_15649 {

    private var isUsed = BooleanArray(10)
    private var arr = IntArray(10)
    private var bw = System.out.bufferedWriter()
    init {
        val br = System.`in`.bufferedReader()

        val (N, M) = br.readLine().split(" ").map { it.toInt() }

        func(0, N, M)

        br.close()
        bw.flush()
    }

    private fun func(k: Int, n: Int, m: Int) {
        if (k == m) {
            for (i in 0 until m) {
                bw.append("${arr[i]} ")
            }
            bw.appendLine()
            return
        }

        for (i in 1..n) {
            if (!isUsed[i]) {
                arr[k] = i
                isUsed[i] = true
                func(k + 1, n, m)
                isUsed[i] = false
            }
        }
    }
}

private fun main() {
    Solution_15649()
}