package kr.baekjoon

class Solution_2668 {

    private var visited: BooleanArray
    private var pools: IntArray

    private var answer = arrayListOf<Int>()

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val N = br.readLine().toInt()
        visited = BooleanArray(N + 1)
        pools = IntArray(N + 1)

        for (i in 1..N) {
            pools[i] = br.readLine().toInt()
        }

        for (i in 1..N) {
            visited[i] = true
            dfs(i, i)
            visited[i] = false
        }

        bw.appendLine("${answer.size}")
        answer.forEach {
            bw.appendLine(it.toString())
        }


        br.close()
        bw.flush()
    }

    private fun dfs(start: Int, target: Int) {
        if (!visited[pools[start]]) {
            visited[pools[start]] = true
            dfs(pools[start], target)
            visited[pools[start]] = false
        }

        if (pools[start] == target) {
            answer.add(target)
        }
    }
}

private fun main() {
    Solution_2668()
}