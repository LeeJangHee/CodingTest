package baekjoon.barkingdog

class Solution_15663 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private val ans: IntArray
    private val visited: BooleanArray
    private val set = HashSet<String>()
    init {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        ans = IntArray(M)
        visited = BooleanArray(N)
        val arr = br.readLine()
            .split(" ")
            .map { it.toInt() }
            .sorted()

        backtracking(arr, M, 0)

        br.close()
        bw.flush()
        set.clear()
    }

    private fun backtracking(arr: List<Int>, m: Int, depth: Int) {
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

        for (i in arr.indices) {
            if (visited[i]) continue
            visited[i] = true
            ans[depth] = arr[i]
            backtracking(arr, m, depth + 1)
            visited[i] = false
        }
    }
}

private fun main() {
    Solution_15663()
}