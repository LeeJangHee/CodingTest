package kr.baekjoon

class Solution_1911 {

    private var puddle = arrayListOf<Pair<Int, Int>>()
    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val (N, L) = br.readLine().split(" ").map { it.toInt() }

        for (i in 0 until N) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            puddle.add(x to y)
        }

        puddle.sortWith { o1, o2 ->
            when {
                o1.first > o2.first -> 1
                o1.first < o2.first -> -1
                else -> o1.second - o2.second
            }
        }

        var range = 0
        var answer = 0

        puddle.forEach {
            if (it.first > range) {
                range = it.first
            }

            if (it.second > range) {
                while(it.second > range) {
                    range += L
                    answer += 1
                }
            }
        }

        bw.appendLine("$answer")

        br.close()
        bw.flush()
    }
}

private fun main() {
    Solution_1911()
}