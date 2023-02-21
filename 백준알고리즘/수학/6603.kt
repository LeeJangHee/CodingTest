package kr.baekjoon

class Solution_6603 {

    init {
        val br = System.`in`.bufferedReader()

        while (true) {
            val x = br.readLine().split(" ").map { it.toInt() }
            // 0 인경우 종료
            val k = x.first()
            if (k == 0) break

            val S = x.subList(1, x.size)
            val visited = BooleanArray(S.size)
            combination(S, visited, 0, 0)
            print("\n")
        }

        br.close()
    }

    private fun combination(c: List<Int>, visited: BooleanArray, start: Int, r: Int) {
        if (r == 6) {
            c.printComb(visited)
            return
        }

        for (i in start until c.size) {
            visited[i] = true
            combination(c, visited, i + 1, r + 1)
            visited[i] = false
        }
    }

    private fun List<Int>.printComb(visited: BooleanArray) {
        var str = ""
        this.forEachIndexed { i, v ->
            if (visited[i]) {
                str += "$v "
            }
        }
        println(str)
    }
}

private fun main() {
    Solution_6603()
}
