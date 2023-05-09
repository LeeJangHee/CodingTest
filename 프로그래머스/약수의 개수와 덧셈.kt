package programmers

object Challenge_mineral_water {
    fun solution(left: Int, right: Int): Int {
        var answer = 0
        for (num in left..right) {
            var cnt = 0
            // 약수 구하기
            for (i in 1..num) {
                if (num % i == 0) {
                    cnt += 1
                }
            }
            if (cnt % 2 == 0) {
                // 짝수 (+)
                answer += num
            } else {
                // 홀수 (-)
                answer -= num
            }
        }
        return answer
    }
}

private fun main() {
    Challenge_mineral_water.solution(13, 17)
    Challenge_mineral_water.solution(24, 27)
}
