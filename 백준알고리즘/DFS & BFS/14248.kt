import java.util.*

class Solution_14248 {
    private var visited: BooleanArray
    private var N: Int
    private var Ai: IntArray
    private var S: Int

    init {
        val br = System.`in`.bufferedReader()

        N = br.readLine().toInt()
        val st = StringTokenizer(br.readLine())
        Ai = IntArray(N + 1)
        for (i in 1..N) {
            Ai[i] = st.nextToken().toInt()
        }
        S = br.readLine().toInt()

        visited = BooleanArray(N + 1)

        dfs(S)
        println(visited.count { it })

        br.close()
    }

    private fun dfs(pos: Int) {
        if (pos < 1 || pos > N || visited[pos])
            return

        visited[pos] = true
        dfs(pos + Ai[pos])
        dfs(pos - Ai[pos])
    }

}

private fun main() {
    Solution_14248()
}
