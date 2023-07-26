package baekjoon.barkingdog

object BOJ2230 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val (n, m) = br.readLine().split(Regex("\\s")).map { it.toLong() }

        val arr = LongArray(n.toInt())
        for (i in arr.indices) {
            arr[i] = br.readLine().toLong()
        }

        arr.sort()

        var lt = 0
        var rt = 0
        var minValue = Long.MAX_VALUE
        while (lt < n && rt < n) {
            val sub = arr[rt] - arr[lt]
            if (sub < m) {
                rt += 1
            } else {
                minValue = minOf(minValue, sub)
                lt += 1
            }
        }

        bw.appendLine("$minValue")


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ2230.solve()
}