class Solution_2960 {

    init {
        val br = System.`in`.bufferedReader()

        val (N, K) = br.readLine().split(" ").map { it.toInt() }

        val visited = BooleanArray(N + 1) { false }
        primaryNumberOf(visited, N, K)

        br.close()
    }

    private fun primaryNumberOf(visited: BooleanArray, n: Int, k: Int) {
        var count = 0
        for (i in 2..n) {
            if (!visited[i]) {
                for (j in i..n step i) {
                    if (visited[j]) continue
                    visited[j] = true
                    count++
                    if (count == k) {
                        println(j)
                        return
                    }
                }
            }
        }
    }
}

fun main() {
    Solution_2960()
}
