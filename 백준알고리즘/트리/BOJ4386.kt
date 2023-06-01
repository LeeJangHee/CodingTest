package baekjoon

import java.util.*

object BOJ4386 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private data class PointF(
        val x: Float,
        val y: Float
    )

    private data class Star(
        val idx: Int,
        val dist: Float
    ) : Comparable<Star> {
        override fun compareTo(other: Star): Int {
            return if (this.dist < other.dist) {
                -1
            } else {
                1
            }
        }
    }

    private lateinit var stars: Array<ArrayList<Star>>
    private var ans: Float = 0f
    fun solve() {
        val N = br.readLine().toInt()
        var arr = arrayListOf<PointF>()
        for (i in 0 until N) {
            val (x, y) = br.readLine()
                .split(" ")
                .map { it.toFloat() }
            arr.add(PointF(x, y))
        }

        stars = Array(N) { arrayListOf() }
        val visited = BooleanArray(N)
        val selected = Array(2) { 0 to PointF(0f, 0f) }
        fun setStars(st: Int, t: Int) {
            if (t == 2) {
                // 루트 (x2-x1)^2 + (y2-y1)^2
                val (start, p1) = selected[0]
                val (end, p2) = selected[1]
                val dist = Math.sqrt(
                    ((p2.x - p1.x) * (p2.x - p1.x) +
                            (p2.y - p1.y) * (p2.y - p1.y)).toDouble()
                ).toFloat()
                stars[start].add(Star(end, dist))
                stars[end].add(Star(start, dist))
                return
            }

            for (i in st until arr.size) {
                if (!visited[i]) {
                    visited[i] = true
                    selected[t] = Pair(i, arr[i])
                    setStars(i, t + 1)
                    visited[i] = false
                }
            }
        }

        // 모든 점의 경우의 수 만큼 거리 연결
        // (1, 2) | (2, 1) 중복 제거
        setStars(0, 0)

        prim(N)
        bw.appendLine(String.format("%.2f", ans))


        br.close()
        bw.flush()
    }

    private fun prim(size: Int) {
        val visited = BooleanArray(size)
        val pq = PriorityQueue<Star>()
        pq.offer(Star(0, 0f))

        while (pq.isNotEmpty()) {
            val (now, dist) = pq.poll()

            if (visited[now]) continue

            ans += dist
            visited[now] = true

            for (star in stars[now]) {
                if (!visited[star.idx]) {
                    pq.offer(star)
                }
            }
        }
    }
}

private fun main() {
    BOJ4386.solve()
}