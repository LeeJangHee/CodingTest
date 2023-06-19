package baekjoon

object BOJ1992 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private lateinit var arr: Array<IntArray>
    private var ans = StringBuffer()
    fun solve() {
        val N = br.readLine().toInt()
        arr = Array(N) { IntArray(N) }
        for (i in 0 until N) {
            br.readLine()
                .forEachIndexed { j, s ->
                    arr[i][j] = s.digitToInt()
                }
        }

        quadTree(0, 0, N)
        bw.appendLine("$ans")

        br.close()
        bw.flush()
    }

    private fun quadTree(x: Int, y: Int, t: Int) {
        if (check(x, y, t)) {
            ans.append(arr[x][y])
            return
        }
        ans.append("(")
        // top + left
        quadTree(x, y, t / 2)
        // top + right
        quadTree(x, y + (t / 2), t / 2)
        // bottom + left
        quadTree(x + (t / 2), y, t / 2)
        // bottom + right
        quadTree(x + (t / 2), y + (t / 2), t / 2)
        ans.append(")")

    }

    private fun check(x: Int, y: Int, t: Int): Boolean {
        if (t == 1) return true

        for (i in x until x + t) {
            for (j in y until y + t) {
                if (arr[x][y] != arr[i][j]) return false
            }
        }

        return true
    }
}

private fun main() {
    BOJ1992.solve()
}