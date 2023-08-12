package baekjoon

object BOJ11656 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val S = br.readLine()

        val arr = mutableListOf<String>()

        for (i in S.indices) {
            val s = S.drop(i)
            arr.add(s)
        }

        bw.appendLine(arr.sorted().joinToString(separator = "\n"))

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ11656.solve()
}