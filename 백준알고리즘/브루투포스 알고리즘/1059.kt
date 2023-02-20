package kr.baekjoon

class Solution_1059 {

    private var count = 0

    init {
        val br = System.`in`.bufferedReader()

        val L: Int = br.readLine().toInt()
        val S: List<Int> = br.readLine().split(" ").map { it.toInt() }.sorted()
        val n: Int = br.readLine().toInt()

        try {
            val range = S.findByRange(n)
            for (a in range.first..n) {
                for (b in n..range.last) {
                    if (a == b) continue
                    count++
                }
            }
            println(count)
        } catch (e: Exception) {
            println(0)
        }


        br.close()
    }

    @Throws(Exception::class)
    private fun List<Int>.findByRange(n: Int): IntRange {
        var minValue = Int.MAX_VALUE
        var maxValue = Int.MIN_VALUE
        var x = 0
        var y = 0
        this.forEach {
            val v = it - n
            if (it > n) {
                // 작은 값 찾기
                if (minValue > v) {
                    minValue = v
                    y = it
                }
            } else if (it < n) {
                // 큰 값 찾기
                if (maxValue < v) {
                    maxValue = v
                    x = it
                }
            } else {
                throw Exception()
            }
        }
        return x + 1 until y
    }
}

private fun main() {
    Solution_1059()
}
