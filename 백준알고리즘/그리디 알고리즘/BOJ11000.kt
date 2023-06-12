import java.util.*

object BOJ11000 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val N = br.readLine().toInt()
        val arr = Array(N) { Pair(0, 0) }
        for (i in 0 until N) {
            val (s, e) = br.readLine()
                .split(" ")
                .map { it.toInt() }
            arr[i] = Pair(s, e)
        }

        arr.sortWith { o1, o2 ->
            if (o1.first == o2.first) {
                o1.second - o2.second
            } else {
                o1.first - o2.first
            }
        }

        val pq = PriorityQueue<Int>()
        for ((s, e) in arr) {
            if (pq.isEmpty()) {
                // 최초 값 추가
                pq.offer(e)
                continue
            }

            if (s < pq.peek()) {
                pq.offer(e)
            } else {
                pq.poll()
                pq.offer(e)
            }
        }

        bw.appendLine("${pq.size}")


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ11000.solve()
}