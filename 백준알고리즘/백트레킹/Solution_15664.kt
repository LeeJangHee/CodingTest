package baekjoon.barkingdog

class Solution_15664 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var ans: IntArray
    private var visited: BooleanArray
    private val set = HashSet<String>()

    init {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        ans = IntArray(M)
        visited = BooleanArray(N)
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

        for (i in start until n) {
            if (!visited[i]) {
                visited[i] = true
                ans[target] = arr[i]
                backtracking(arr, n, m, i, target + 1)
                visited[i] = false
            }
        }
    }
}

private fun main() {
    Solution_15664()
}