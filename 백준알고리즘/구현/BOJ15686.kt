package baekjoon

object BOJ15686 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private const val HOME = 1
    private const val STORE = 2
    private const val INF = 1e9.toInt()

    fun solve() {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }

        val home = arrayListOf<Pair<Int, Int>>()
        val store = arrayListOf<Pair<Int, Int>>()
        for (i in 0 until N) {
            br.readLine()
                .split(" ")
                .forEachIndexed { j, s ->
                    when (s.toInt()) {
                        HOME -> home.add(i to j)
                        STORE -> store.add(i to j)
                    }
                }
        }

        var ans = INF
        val selectedStore = Array(M) { Pair(0, 0) }

        fun selectStore(st: Int, count: Int) {
            if (count == M) {
                // 거리 계산
                var dist = 0
                for ((x2, y2) in home) {
                    var m = INF
                    for ((x1, y1) in selectedStore) {
                        m = minOf(m, Math.abs(x1 - x2) + Math.abs(y1 - y2))
                    }
                    dist += m
                }
                ans = minOf(ans, dist)
                return
            }

            for (i in st until store.size) {
                selectedStore[count] = store[i]
                selectStore(i + 1, count + 1)
            }
        }

        // 조합
        selectStore(0, 0)
        bw.appendLine("$ans")

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ15686.solve()
}