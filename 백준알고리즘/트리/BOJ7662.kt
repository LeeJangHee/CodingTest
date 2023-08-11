package baekjoon

import java.util.*

/**
 * 제한시간 6초 = 6*10^8
 */

object BOJ7662 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun solve() {

        var t = br.readLine().toInt()

        while (t-- > 0) {
            val K = br.readLine().toInt()
            val map = TreeMap<Int, Int>()
            // I = n을 insert
            // D = 1: 최대값 삭제, -1: 최소값 삭제
            for (i in 0 until K) {
                val (oper, n) = br.readLine().split(Regex("\\s"))

                if (oper == "I") {
                    map.put(n.toInt(), map.getOrDefault(n.toInt(), 0) + 1)
                } else {
                    if (map.isEmpty()) continue

                    val key = if (n.toInt() < 0) map.firstKey() else map.lastKey()
                    val cnt = map.getOrDefault(key, 0)
                    if (cnt == 1) {
                        // 최대값 삭제
                        map.remove(key)
                    } else {
                        // 최소값 삭제
                        map.put(key, cnt - 1)
                    }
                }
            }

            if (map.size == 0) {
                bw.appendLine("EMPTY")
            } else {
                bw.appendLine("${map.lastKey()} ${map.firstKey()}")
            }

        }


        br.close()
        bw.flush()
    }
}

private fun main() {
    BOJ7662.solve()
}