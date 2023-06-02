package baekjoon

object BOJ10423 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private data class Town(
        val st: Int,
        val en: Int,
        val cost: Int
    ) : Comparable<Town> {
        override fun compareTo(other: Town): Int {
            return this.cost - other.cost
        }
    }

    private lateinit var parents: IntArray
    private lateinit var edgeList: ArrayList<Town>

    fun solve() {
        val (N, M, K) = br.readLine()
            .split(" ")
            .map { it.toInt() }

        parents = IntArray(N + 1) { it }

        val factory = br.readLine()
            .split(" ")
            .map { it.toInt() }

        factory.forEach {
            parents[it] = -1
        }

        edgeList = arrayListOf()
        for (i in 0 until M) {
            val (u, v, w) = br.readLine()
                .split(" ")
                .map { it.toInt() }
            edgeList.add(Town(u, v, w))
        }

        edgeList.sort()
        var ans = 0L
        edgeList.forEach {
            if (find(it.st) != find(it.en)) {
                ans += it.cost

                union(it.st, it.en)


                // 모든 도시가 발전소 루트로 변경됐는지 확인
                if (isAllConnect()) {
                    return@forEach
                }
            }
        }

        bw.appendLine("$ans")

        br.close()
        bw.flush()
    }

    private fun union(x: Int, y: Int) {
        var a = find(x)
        var b = find(y)

        if (a != b) {
            if (b == -1) {
                parents[a] = b
            } else {
                parents[b] = a
            }
        }
    }

    private fun find(x: Int): Int {
        if (parents[x] == -1) {
            return -1
        }

        if (x == parents[x]) {
            return x
        }

        return find(parents[x]).also { parents[x] = it }
    }

    private fun isAllConnect(): Boolean {
        return parents.all { it == -1 }
    }
}

private fun main() {
    BOJ10423.solve()
}