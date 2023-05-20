package baekjoon

import java.util.*

@Deprecated(message = "DP, 위상정렬 개념 필요, 해설을 봐야함.")
object BOJ1005 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        var t = br.readLine().toInt()

        while (t-- > 0) {
            val (N, K) = br.readLine().split(" ").map { it.toInt() }
            val delay = mutableListOf(0)
            delay.addAll(br.readLine().split(" ").map { it.toInt() })
            val arr = Array(N + 1) { BooleanArray(N + 1) }
            val link = IntArray(N + 1)
            for (i in 1..K) {
                val (x, y) = br.readLine().split(" ").map { it.toInt() }
                arr[x][y] = true
                link[y] += 1
            }
            val W = br.readLine().toInt()
            solution(N, W, delay, arr, link)
        }

        br.close()
        bw.flush()
    }

    private fun solution(
        n: Int,
        w: Int,
        delay: List<Int>,
        build: Array<BooleanArray>,
        link: IntArray
    ) {
        val ans = IntArray(n + 1)

        fun topologicalSort() {
            val q = LinkedList<Int>()

            for (i in link.indices) {
                if (link[i] == 0) {
                    ans[i] = delay[i]
                    q.offer(i)
                }
            }

            while (q.isNotEmpty()) {
                val prev = q.poll()
                for (i in 1 until link.size) {
                    // 하위 건물 건설 요구하는 건물
                    if (build[prev][i]) {
                        ans[i] = maxOf(ans[i], ans[prev] + delay[i])
                        // 건물 요구 개수 감소
                        link[i] -= 1

                        if (link[i] == 0) {
                            q.add(i)
                        }
                    }
                }
            }
        }

        topologicalSort()
        bw.appendLine("${ans[w]}")
    }
}

private fun main() {
    BOJ1005.solve()
}

