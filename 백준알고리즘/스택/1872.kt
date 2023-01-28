import java.util.*

class Solution_1872 {

    private var st: Stack<Int> = Stack<Int>()
    private var pushCount = 0

    init {
        solution()
    }


    private fun solution() {
        val br = System.`in`.bufferedReader()

        val n = br.readLine().toInt()

        val arrList: MutableList<Int> = mutableListOf()

        for (i in 0 until n) {
            arrList.add(br.readLine().toInt())
        }

        val stackMatrix = arrList.stackMatrix()

        if (stackMatrix.first == null) {
            println(stackMatrix.second)
        } else {
            stackMatrix.first!!.forEach {
                println(it)
            }
        }
    }


    private fun List<Int>.stackMatrix(): Pair<MutableList<String>?, String?> {
        val answer: MutableList<String> = mutableListOf()
        this.forEach { popNum ->
            if (pushCount < popNum) {
                do {
                    pushCount++
                    st.push(pushCount)
                    answer.add("+")
                } while (pushCount != popNum)
            }

            if (popNum == st.peek()) {
                st.pop()
                answer.add("-")
            } else {
                return null to "NO"
            }

        }

        return answer to null
    }

}

fun main() {
    Solution_1872()
}
