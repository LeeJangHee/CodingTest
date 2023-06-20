package baekjoon

import java.util.*

object BOJ11725 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()


    private val UNSET = -1
    fun solve() {
        val N = br.readLine().toInt()
        val arr = Array(N + 1) { arrayListOf<Int>() }
        for (i in 1 until N) {
            val (a, b) = br.readLine()
                .split(Regex("\\s"))
                .map { it.toInt() }

            arr[a].add(b)
            arr[b].add(a)
        }

        val parents = IntArray(N + 1) { UNSET }
        fun bfs() {
            val q = LinkedList<Int>()
            q.offer(1)
            parents[1] = 1

            while (q.isNotEmpty()) {
                val p = q.poll()

                for (leaf in arr[p]) {
                    if (parents[leaf] == UNSET) {
                        parents[leaf] = p
                        q.offer(leaf)
                    }
                }
            }
        }

        // execute
        bfs()

        for (i in 2..N) {
            bw.appendLine("${parents[i]}")
        }


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ11725.solve()
}