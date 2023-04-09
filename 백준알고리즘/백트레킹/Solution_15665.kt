package baekjoon.barkingdog

class Solution_15665 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var ans: IntArray
    private val set = HashSet<String>()

    init {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        ans = IntArray(M)
        val arr = br.readLine()
            .split(" ")
            .map { it.toInt() }
            .sorted()

        backtracking(arr, N, M, 0)

        br.close()
        bw.flush()
    }

    private fun backtracking(arr: List<Int>, n: Int, m: Int, depth: Int) {
        if (depth == m) {
            val tmp = StringBuilder()
            ans.forEach {
                tmp.append(it).append(' ')
            }

            if (!set.contains(tmp.toString())) {
                set.add(tmp.toString())
                tmp.appendLine()
                bw.write(tmp.toString())
            }

            return
        }

        for (value in arr) {
            ans[depth] = value
            backtracking(arr, n, m, depth + 1)
        }
    }
}

private fun main() {
    Solution_15665()
}