class Solution_1652 {
    init {
        solution()
    }

    private fun solution() {
        val br = System.`in`.bufferedReader()

        val N = br.readLine().toInt()
        val roomList = mutableListOf<String>()
        for (i in 0 until N) {
            roomList.add(br.readLine())
        }
        val xArr = roomList.toTypedArray()
        val yArr = Array<String>(N) { "" }
        yArr.forEachIndexed { index, _ ->
            var yStr = ""
            roomList.forEach {
                yStr += it[index]
            }
            yArr[index] = yStr
        }

        println("${getCount(xArr)} ${getCount(yArr)}")
    }

    private fun getCount(arr: Array<String>): Int {
        var count = 0
        arr.forEach {
            val cnt = it.split("X").filter { split -> split.length >= 2 }.size
            count += cnt
        }

        return count
    }
}

fun main() {
    Solution_1652()
}
