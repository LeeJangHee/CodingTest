package baekjoon

import java.util.*

object BOJ16398 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private data class Plant(
        val idx: Int,
        val dist: Int
    ): Comparable<Plant> {
        override fun compareTo(other: Plant): Int {
            return this.dist - other.dist
        }
    }

    private var ans = 0L
    fun solve() {
        val N = br.readLine().toInt()
        val arr = Array(N) { IntArray(N) }
        for (i in 0 until N) {
            br.readLine()
                .split(" ")
                .forEachIndexed { j, s ->
                    arr[i][j] = s.toInt()
                }
        }

        val plants = Array(N) { arrayListOf<Plant>() }
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                plants[i].add(Plant(j, arr[i][j]))
                plants[j].add(Plant(i, arr[j][i]))
            }
        }

        fun prim() {
            val visited = BooleanArray(N)
            val pq = PriorityQueue<Plant>()
            pq.offer(Plant(0, 0))

            while (pq.isNotEmpty()) {
                val (now, dist) = pq.poll()

                if (!visited[now]) {
                    visited[now] = true
                    ans += dist

                    for (p in plants[now]) {
                        if (!visited[p.idx]) {
                            pq.offer(p)
                        }
                    }
                }
            }
        }

        prim()

        bw.appendLine("$ans")

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ16398.solve()
}