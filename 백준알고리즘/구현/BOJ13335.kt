package baekjoon

import java.util.*

class BOJ13335 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {
        val (n, w, L) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { it.toInt() }

        solve(n, w, L, arr)

        br.close()
        bw.flush()
    }

    private fun solve(n: Int, w: Int, L: Int, arr: List<Int>) {
        var count = 0
        val q = LinkedList<Int>()
        var total = 0
        for (i in 0 until n) {
            while (true) {
                if (q.size == w) {
                    total -= q.poll()
                }
                if (total + arr[i] <= L) break
                q.offer(0)
                count += 1
            }
            q.offer(arr[i])
            total += arr[i]
            count += 1
        }
        count += w
        bw.appendLine("$count")
    }
}

/*
n개의 트럭이 다리 건넘
w: 무게
L: 쵀대 하중
ex)
w = 2
L = 10
트럭 = [7 4 5 6]
7 0 4 5 0 6 0
 */
private fun main() {
    BOJ13335()
}