package baekjoon.barkingdog

class Solution_15666 {
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

        backtracking(arr, N, M, 0, 0)

        br.close()
        bw.flush()
    }

    private fun backtracking(arr: List<Int>, n: Int, m: Int, start: Int, depth: Int) {
        if (depth == m) {
            val tmp = StringBuffer()
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

        for (i in start until n) {
            ans[depth] = arr[i]
            backtracking(arr, n, m, i, depth + 1)
        }
    }
}

private fun main() {
    Solution_15666()
}