/**
 * 18870 좌표 압축
 */
private fun main() {
    Solution_18870()
}


private class Solution_18870 {

    init {
        solution()
    }

    private fun solution() {
        val br = System.`in`.bufferedReader()

        val N = br.readLine().toInt()
        val xArray = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
        val sortArray = xArray.distinct().sorted()
        val answer = mutableListOf<Int>()
        xArray.forEach {
            answer.add(binarySearch(sortArray, it))
        }

        val sb = StringBuilder()
        answer.forEach { sb.append(it).append(' ') }
        sb.deleteAt(sb.lastIndex)
        println(sb)

        br.close()
    }

    private fun binarySearch(arr: List<Int>, target: Int): Int {
        var start = 0
        var end = arr.size

        while (start < end) {
            val mid = (start + end) / 2

            if (arr[mid] < target) {
                start = mid + 1
            } else {
                end = mid
            }
        }

        return start
    }
}
