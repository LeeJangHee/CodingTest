private fun main() {
    Solution()
}

private class Solution {

    init {
        solution()
    }


    private fun solution() {
        val br = System.`in`.bufferedReader()
        val n = br.readLine().toInt()
        val nCards = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

        // 정렬
        Arrays.sort(nCards)
        val m = br.readLine().toInt()

        val mCards = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

        val sb = StringBuilder()
        for (i in 0 until m) {
            sb.append(upperBound(nCards, mCards[i]) - lowerBound(nCards, mCards[i]))
                .append(' ')
        }

        println(sb)

        br.close()
    }


    private fun upperBound(arr: Array<Int>, target: Int): Int {
        var start = 0
        var end = arr.size

        while (start < end) {
            val mid = (start + end) / 2

            if (target < arr[mid]) {
                end = mid
            } else {
                start = mid + 1
            }
        }

        return start
    }

    private fun lowerBound(arr: Array<Int>, target: Int): Int {
        var start = 0
        var end = arr.size

        while(start < end) {
            val mid = (start + end) /2

            if (target <= arr[mid]) {
                end = mid
            } else {
                start = mid + 1
            }
        }

        return start
    }
}
