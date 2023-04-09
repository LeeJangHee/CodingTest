package baekjoon.barkingdog

class Solution_15654 {
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    private var ans: ArrayList<Int>
    init {

        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        ans = arrayListOf()
        var arr = br.readLine()
            .split(" ")
            .map { it.toInt() }
            .sorted()


        backtracking(arr, N, M, 0)

        br.close()
        bw.flush()
    }

    private fun backtracking(arr: List<Int>, n: Int, m: Int, target: Int) {
        if (target == m) {
            ans.forEach {
                bw.append("$it ")
            }
            bw.appendLine()
            return
        }

        for (value in arr) {
            if (ans.contains(value)) continue
            ans.add(value)
            backtracking(arr, n, m, target + 1)
            ans.remove(value)
        }
    }
}

private fun main() {
    Solution_15654()
}