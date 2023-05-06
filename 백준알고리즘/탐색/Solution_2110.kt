package baekjoon.barkingdog

class Solution_2110 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    init {
        val (N, C) = br.readLine().split(" ").map { it.toInt() }

        val arr = mutableListOf<Int>()
        var maxValue = 0
        for (i in 1..N) {
            val v = br.readLine().toInt()
            maxValue = maxOf(maxValue, v)
            arr.add(v)
        }

        arr.sort()

        var st = 0
        var en = maxValue
        var len = 0
        while (st <= en) {
            val mid = (st + en) / 2

            // 첫번째 집은 공유기 설치
            var cnt = 1
            // 마지막 설치된 공유기 좌표
            var last = arr[0]
            // 거리(mid) 에 공유기를 설치 할 수 있는지 확인
            for (i in 1 until arr.size) {
                val locate = arr[i]

                // 설치 했다면 cnt + 1, 마지막 공유기 설치 위치 변경
                if (locate - last >= mid) {
                    cnt += 1
                    last = locate
                }
            }

            // 필요한 공유기 개수를 확인하여
            // st, en 값 변경
            if (cnt < C) {
                en = mid - 1
            } else {
                len = maxOf(len, mid)
                st = mid + 1
            }
        }

        bw.appendLine("$len")

        br.close()
        bw.flush()
    }
}

private fun main() {
    Solution_2110()
}