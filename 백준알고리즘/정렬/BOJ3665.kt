package baekjoon

import java.util.*

object BOJ3665 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {
        var case = br.readLine().toInt()
        while (case-- > 0) {
            val N = br.readLine().toInt()
            val rank = Array(N + 1) { IntArray(N + 1) }
            val t = br.readLine().split(Regex("\\s")).map { it.toInt() }
            val indeg = IntArray(N + 1)

            for (i in t.indices) {
                val list = t.subList(i + 1, N)
                val idx = t[i]
                indeg[idx] = list.size
                list.forEach {
                    rank[it][idx] = 1
                }
            }
            val M = br.readLine().toInt()

            for (i in 1..M) {
                val (a, b) = br.readLine().split(Regex("\\s")).map { it.toInt() }
                if (rank[a][b] == 1) {
                    rank[a][b] = 0
                    rank[b][a] = 1
                    indeg[a]++; indeg[b]--
                } else {
                    rank[b][a] = 0
                    rank[a][b] = 1
                    indeg[b]++; indeg[a]--
                }
            }

            var flag: Boolean? = true
            val ans = ArrayDeque<Int>()
            fun topologySort() {
                val q = LinkedList<Int>()
                for (i in 1..N) {
                    if (indeg[i] == 0) {
                        q.offer(i)
                    }
                }

                for (i in 1..N) {
                    if (q.isEmpty()) {
                        flag = false
                        return
                    } else if (q.size > 1) {
                        flag = null
                        return
                    }

                    val now = q.poll()
                    ans.addFirst(now)
                    for (j in 1..N) {
                        if (rank[now][j] == 1) {
                            rank[now][i] == 0
                            indeg[j] -= 1
                            if (indeg[j] == 0) {
                                q.offer(j)
                            }
                        }
                    }
                }

            }

            topologySort()

            when (flag) {
                true -> {
                    bw.appendLine(ans.joinToString(" "))
                }
                false -> {
                    bw.appendLine("IMPOSSIBLE")
                }
                else -> {
                    bw.appendLine("?")
                }
            }

        }

        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ3665.solve()
}