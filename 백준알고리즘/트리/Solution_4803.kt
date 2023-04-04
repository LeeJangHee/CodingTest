package kr.baekjoon

class Solution_4803 {

    private lateinit var visited: BooleanArray
    private lateinit var tree: Array<ArrayList<Int>>

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        var testCase = 0
        while (true) {
            testCase += 1
            var ans = 0
            val (N, M) = br.readLine().split(" ").map { it.toInt() }
            if (N == 0 && M == 0) break

            tree = Array(N) { arrayListOf() }
            visited = BooleanArray(N)
            for (i in 0 until M) {
                val (a, b) = br.readLine().split(" ").map { it.toInt() - 1 }
                tree[a].add(b)
                tree[b].add(a)
            }

            for (i in 0 until N) {
                if (!visited[i]) {
                    visited[i] = true
                    if (dfs(-1, i)) {
                        ans += 1
                    }
                }
            }

            val ansText = when (ans) {
                0 -> "No trees."
                1 -> "There is one tree."
                else -> "A forest of $ans trees."
            }

            bw.write("Case $testCase: $ansText")
            bw.newLine()
        }

        bw.flush()
        br.close()
    }

    private fun dfs(root: Int, num: Int): Boolean {
        for (i in tree[num]) {
            if (i == root) continue
            if (visited[i]) return false
            visited[i] = true
            if (!dfs(num, i)) return false
        }
        return true
    }
}

private fun main() {
    Solution_4803()
}