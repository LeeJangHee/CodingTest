/**
 * https://www.acmicpc.net/problem/2075
 */
class Solution_2075 {

    private val arr = mutableListOf<List<Long>>()

    init {
        val br = System.`in`.bufferedReader()
        val N = br.readLine().toInt()
        repeat(N) {
            arr.add(br.readLine().split(" ").map { it.toLong() })
        }
        bigNumberOf(N)
        br.close()
    }

    private fun bigNumberOf(n: Int) {
        val a = mutableListOf<Long>()
        repeat(arr.size) {
            a.addAll(arr[it])
        }
        println(a.sortedDescending()[n-1])
    }
}

fun main() {
    Solution_2075()
}
