package kr.programmers.challenge3

class CropArray {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer = arrayListOf<Int>()

        // 2차원 배열 초기화
        for (i in left .. right) {
            val value = maxOf(i / n, i % n) + 1
            answer.add(value.toInt())
        }

        return answer.toTypedArray().toIntArray()
    }
}

private fun main() {
    val t = CropArray()
    val bw = System.out.bufferedWriter()
    bw.appendLine(t.solution(3, 2, 5).joinToString())
    bw.appendLine(t.solution(4, 7, 14).joinToString())
    bw.flush()
}