private fun main() {
    Solution_13908()
}

class Solution_13908 {
    private var count = 0
    private val visited = BooleanArray(10) { false }

    init {
        val br = System.`in`.bufferedReader()

        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        if (M > 0) {
            br.readLine().split(" ").map { it.toInt() }.forEach {
                visited[it] = true
            }
        }


        backtracking(0, 0, N, M)
        println(count)
        br.close()
    }

    private fun backtracking(idx: Int, cnt: Int, N: Int, M: Int) {
        if (idx == N) {
            if (cnt == M) count++
            return
        }

        for (i in 0..9) {
            if (visited[i]) {
                visited[i] = false
                backtracking(idx + 1, cnt + 1, N, M)
                visited[i] = true
            } else {
                backtracking(idx + 1, cnt, N, M)
            }
        }

    }
}
