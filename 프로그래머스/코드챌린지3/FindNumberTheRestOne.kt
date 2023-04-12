package kr.programmers.challenge3

class FindNumberTheRestOne {
    fun solution(n: Int): Int {
        var answer = n

        for (i in 1 until n) {
            if (n % i == 1) {
                answer = i
                break
            }
        }

        return answer
    }
}

private fun main() {
    val t = FindNumberTheRestOne()

    val bw = System.out.bufferedWriter()

    bw.appendLine(t.solution(10).toString())
    bw.appendLine(t.solution(12).toString())
    bw.flush()
}
