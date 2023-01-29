class Solution_1541 {

    init {
        solution()
    }

    private fun solution() {
        val br = System.`in`.bufferedReader()
        val modification = br.readLine().toString()
        val arr = modification.split("-")
        val numbers = mutableListOf<Int>()

        for (a in arr) {
            val tmpArr = a.split("+")
            numbers.add(tmpArr.sumOf { it.toInt() })
        }
        
        var answer = numbers[0]
        for (i in 1 until numbers.size) {
            answer -= numbers[i]
        }

        println(answer)

        br.close()
    }
}

fun main() {
    Solution_1541()
}
