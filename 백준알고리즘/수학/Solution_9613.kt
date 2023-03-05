package kr.baekjoon

class Solution_9613 {

    init {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        var t = br.readLine().toInt()

        while (t-- > 0) {
            val arr = br.readLine().split(" ").map { it.toInt() }
            val n = arr[0]
            val list = arr.subList(1, arr.size)

            val combination = mutableListOf<Pair<Int, Int>>()
            var sum: Long = 0
            comb(combination, list, BooleanArray(list.size), 0, 2)
            combination.forEach {
                sum += gcd(it.first, it.second)
            }
            bw.write(sum.toString())
            bw.newLine()
        }

        br.close()
        bw.flush()
    }

    /**
     * @param combination: 조합을 저장할 2차원 배열
     * @param el: 조합을 구할 원소의 집합
     * @param visited: 원소 선택 여부
     * @param start: 시작 위치
     * @param target: 조합할 원소의 개수
     */
    private fun <T> comb(combination: MutableList<Pair<T, T>>, el: List<T>, visited: BooleanArray, start: Int, target: Int) {
        if (target == 0) {
            val a = el.filterIndexed { index, t -> visited[index] }
            if (a.size == 2) {
                combination.add(a.first() to a.last())
            }
        } else {
            for (i in start until el.size) {
                visited[i] = true
                comb(combination, el, visited, i + 1, target - 1)
                visited[i] = false
            }
        }
    }

    private fun gcd(a: Int, b: Int): Int {
        if (a == 0) return b
        return gcd(b % a, a)
    }
}

private fun main() {
    Solution_9613()
}