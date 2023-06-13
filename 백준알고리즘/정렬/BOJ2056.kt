package kr.baekjoon

import java.util.*

object BOJ2056 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        val N = br.readLine().toInt()
        val arr = Array(N + 1) { arrayListOf<Int>() }
        val indegree = IntArray(N + 1) { -1 }
        val workTime = IntArray(N + 1)
        val dp = IntArray(N + 1)
        val (t, cnt) = br.readLine().split(" ").map { it.toInt() }
        indegree[1] = cnt
        workTime[1] = t
        dp[1] = t
        for (i in 2..N) {
            val list = br.readLine()
                .split(" ")
                .map { it.toInt() }

            workTime[i] = list[0]
            dp[i] = workTime[i]
            indegree[i] = list[1]
            list.subList(2, list.size).forEach {
                arr[it].add(i)
            }
        }

        fun topologySort() {
            val q: Queue<Int> = LinkedList()
            for (i in 1..N) {
                if (indegree[i] == 0) {
                    q.offer(i)
                }
            }

            while (q.isNotEmpty()) {
                val now = q.poll()

                for (a in arr[now]) {
                    indegree[a] -= 1
                    dp[a] = maxOf(dp[a], dp[now] + workTime[a])
                    if (indegree[a] == 0) {
                        q.offer(a)
                    }
                }
            }
        }

        // execute
        topologySort()

        bw.appendLine("${dp.maxOf { it }}")

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ2056.solve()
}