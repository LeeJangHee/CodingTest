package baekjoon.barkingdog

class Solution_1806 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {

        val (N, S) = br.readLine().split(" ".toRegex()).map { it.toInt() }

        val arr = br.readLine().split(" ".toRegex()).map { it.toInt() }

        // 연속된 수들의 부분합 중 S 이상, 가장 짧은 것 길이
        var lt = 0
        var rt = 0
        var sum = 0L
        var length = Int.MAX_VALUE
        while (true) {
            // lt,rt 이동 조건 확인
            // rt: sum 값이 작은 경우 이동
            // lt: sum 값이 큰 경우 이동
            if (sum >= S) {
                sum -= arr[lt]
                length = minOf(length, rt - lt)
                lt += 1
            } else {
                // rt 가 마지막 index 보다 큰 경우
                // 반복문 종료
                if (rt > arr.lastIndex) break
                sum += arr[rt]
                rt += 1
            }
        }

        // 초기값인 경우 불가능한 경우라고 판단, 0으로 변경
        if (length == Int.MAX_VALUE) {
            length = 0
        }
        bw.appendLine("$length")

        br.close()
        bw.flush()
    }
}

private fun main() {
    Solution_1806()
}